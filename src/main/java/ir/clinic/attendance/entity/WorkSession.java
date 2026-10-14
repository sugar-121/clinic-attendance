package ir.clinic.attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkSession extends BaseEntity<Long>{

    @ManyToOne
    private Attendance attendance;

    @Column
    private LocalTime checkIn;

    @Column
    private LocalTime checkOut;

    public void determineAttendance(Attendance attendance){
        attendance.addWorkSession(this);
    }

}
