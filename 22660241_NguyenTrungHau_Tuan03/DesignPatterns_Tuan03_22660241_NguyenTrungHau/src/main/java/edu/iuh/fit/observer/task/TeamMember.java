package edu.iuh.fit.observer.task;

public class TeamMember implements TaskObserver {
    private String name;

    public TeamMember(String name) { this.name = name; }

    @Override
    public void onTaskChanged(String taskName, String status) {
        System.out.println("   -> Email gửi tới [" + name + "]: Task '" + taskName + "' đã cập nhật thành '" + status + "'.");
    }
}