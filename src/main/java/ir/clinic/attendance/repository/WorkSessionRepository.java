package ir.clinic.attendance.repository;

import ir.clinic.attendance.entity.WorkSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkSessionRepository extends JpaRepository<WorkSession, Long> {
}
