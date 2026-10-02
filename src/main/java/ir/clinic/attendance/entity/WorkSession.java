package ir.clinic.attendance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.CustomLog;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.time.LocalDateTime;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class WorkSession extends BaseEntity<Long>{

    @ManyToOne
    private Attendance attendance;

    @Column
    private LocalDateTime checkIn;

    @Column
    private LocalDateTime checkOut;


}
