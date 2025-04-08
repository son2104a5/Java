package Exception_Practise.entity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Schedule implements IApp {
    private int scheduleId;
    private int classroomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private static int autoId = 1;

    public Schedule() {
        this.scheduleId = autoId++;
    }

    public Schedule(int classroomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.scheduleId = autoId++;
        this.classroomId = classroomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void inputData(Scanner scanner) {}

    public int getScheduleId() { return scheduleId; }
    public int getClassroomId() { return classroomId; }
    public void setClassroomId(int classroomId) { this.classroomId = classroomId; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    @Override
    public String toString() {
        return "Lịch học{" +
                "Mã lịch học=" + scheduleId +
                ", Mã lớp học=" + classroomId +
                ", Thời gian bắt đầu=" + startTime +
                ", Thời gian kết thúc=" + endTime +
                '}';
    }
}
