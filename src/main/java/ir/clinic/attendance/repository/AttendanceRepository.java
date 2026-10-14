package ir.clinic.attendance.repository;


import ir.clinic.attendance.entity.Attendance;
import ir.clinic.attendance.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findAttendanceByDateAndEmployeeIdAndShift(LocalDate date, Long employeeId, Shift shift);

}
