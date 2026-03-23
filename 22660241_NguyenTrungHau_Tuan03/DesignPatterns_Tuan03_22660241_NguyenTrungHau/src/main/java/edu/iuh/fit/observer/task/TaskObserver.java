package edu.iuh.fit.observer.task;

public interface TaskObserver {
    void onTaskChanged(String taskName, String status);
}