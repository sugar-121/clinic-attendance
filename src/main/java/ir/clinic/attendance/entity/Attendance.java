package ir.clinic.attendance.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance extends BaseEntity<Long> {

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Shift shift;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "attendance"
            , cascade = CascadeType.ALL
            , orphanRemoval = true)
    private List<WorkSession> workSessions;

    @Column
    private String explanation;


    public void addWorkSession(WorkSession workSession){
        workSessions.add(workSession);
        workSession.setAttendance(this);
    }

}
