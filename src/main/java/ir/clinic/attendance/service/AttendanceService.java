package ir.clinic.attendance.service;

import ir.clinic.attendance.entity.WorkSession;

public interface AttendanceService {

    WorkSession checkIn(long employee);
}
