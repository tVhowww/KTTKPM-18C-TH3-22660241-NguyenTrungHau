package edu.iuh.fit.observer.task;

public interface TaskSubject {
    void subscribe(TaskObserver o);
    void unsubscribe(TaskObserver o);
    void notifyTeam();
}