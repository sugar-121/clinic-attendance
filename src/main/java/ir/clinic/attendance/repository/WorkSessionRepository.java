package ir.clinic.attendance.repository;

import ir.clinic.attendance.entity.WorkSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkSessionRepository extends JpaRepository<WorkSession, Long> {

    boolean existsWorkSessionByAttendanceEmployeeIdAndCheckOutIsNull(Long employeeId);
}
