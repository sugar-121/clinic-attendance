package ir.clinic.attendance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
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
}
