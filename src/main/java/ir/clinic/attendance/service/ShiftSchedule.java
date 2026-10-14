package ir.clinic.attendance.service;

import ir.clinic.attendance.entity.Shift;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ShiftSchedule {

    private static final LocalTime MORNING_START = LocalTime.of(9, 0);
    private static final LocalTime MORNING_EARLY_START = LocalTime.of(8, 30);
    private static final LocalTime MORNING_FINISH = LocalTime.of(13, 0);

    private static final LocalTime AFTERNOON_START = LocalTime.of(16, 0);
    private static final LocalTime AFTERNOON_EARLY_START = LocalTime.of(15, 30);
    private static final LocalTime AFTERNOON_FINISH = LocalTime.of(20, 0);


    public Shift determineShift(LocalTime time) {
        if (time.isAfter(MORNING_EARLY_START)
                && time.isBefore(MORNING_FINISH)) {
            return Shift.MORNING;
        }
        if (time.isAfter(AFTERNOON_EARLY_START)
                && time.isBefore(AFTERNOON_FINISH)) {
            return Shift.NOON;
        }
        return Shift.INVALID;
    }
}
