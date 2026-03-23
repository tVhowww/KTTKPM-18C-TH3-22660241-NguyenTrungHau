package edu.iuh.fit.observer.task;
import java.util.ArrayList;
import java.util.List;

public class Task implements TaskSubject {
    private String name;
    private String status;
    private List<TaskObserver> teamMembers;

    public Task(String name) {
        this.name = name;
        this.status = "To Do"; // Mặc định khi tạo mới
        this.teamMembers = new ArrayList<>();
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println("\n[HỆ THỐNG] Task '" + name + "' vừa được chuyển sang: " + status);
        notifyTeam();
    }

    @Override
    public void subscribe(TaskObserver o) { teamMembers.add(o); }
    @Override
    public void unsubscribe(TaskObserver o) { teamMembers.remove(o); }

    @Override
    public void notifyTeam() {
        for (TaskObserver member : teamMembers) {
            member.onTaskChanged(name, status);
        }
    }
}