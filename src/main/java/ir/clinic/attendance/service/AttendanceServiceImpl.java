package ir.clinic.attendance.service;

import ir.clinic.attendance.entity.Attendance;
import ir.clinic.attendance.entity.Employee;
import ir.clinic.attendance.entity.Shift;
import ir.clinic.attendance.entity.WorkSession;
import ir.clinic.attendance.repository.AttendanceRepository;
import ir.clinic.attendance.repository.EmployeeRepository;
import ir.clinic.attendance.repository.WorkSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final ShiftSchedule shiftSchedule;
    private final EmployeeRepository employeeRepository;
    private final WorkSessionRepository workSessionRepository;

    @Override
    public WorkSession checkIn(long employeeId) {

        LocalDateTime now = LocalDateTime.now();

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new IllegalArgumentException("employee not found")
                );

        Shift shift = shiftSchedule.determineShift(now.toLocalTime());

        if (shift.equals(Shift.INVALID)) {
            throw new IllegalStateException(
                    "Check-in is not allowed at this time."
            );
        }

        if (workSessionRepository.existsWorkSessionByAttendanceEmployeeIdAndCheckOutIsNull(employeeId)) {
            throw new IllegalStateException("You already have an open work session.");
        }


        Attendance attendance = attendanceRepository.findAttendanceByDateAndEmployeeIdAndShift(
                now.toLocalDate(),
                employeeId,
                shift).orElseGet(() -> {

            Attendance newAttendance = Attendance.builder()
                    .date(now.toLocalDate())
                    .shift(shift)
                    .employee(employee)
                    .build();

            return attendanceRepository.save(newAttendance);

        });

        WorkSession workSession = WorkSession.builder()
                .checkIn(now.toLocalTime())
                .checkOut(null)
                .build();

        workSession.determineAttendance(attendance);

        return workSessionRepository.save(workSession);
    }
}
