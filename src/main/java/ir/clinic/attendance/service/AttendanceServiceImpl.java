package ir.clinic.attendance.service;

import ir.clinic.attendance.entity.Attendance;
import ir.clinic.attendance.entity.Shift;
import ir.clinic.attendance.repository.AttendanceRepository;
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

    @Override
    public boolean checkIn(long employeeId) {

        LocalDateTime now = LocalDateTime.now();

        Shift shift = shiftSchedule.determineShift(now.toLocalTime());

        if (shift.equals(Shift.INVALID)){
            throw new
        }

        Optional<Attendance> attendance = attendanceRepository.findAttendanceByDateAndEmployeeIdAndShift(
                now.toLocalDate(),
                employeeId,
                shift);



        return false;
    }
}
