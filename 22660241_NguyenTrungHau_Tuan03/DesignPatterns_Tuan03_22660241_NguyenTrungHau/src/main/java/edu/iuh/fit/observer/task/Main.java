package edu.iuh.fit.observer.task;

public class Main {
    public static void main(String[] args) {
        Task buildAPI = new Task("Xây dựng API Đăng nhập");

        TaskObserver dev = new TeamMember("Dev Backend");
        TaskObserver tester = new TeamMember("QC Tester");
        TaskObserver pm = new TeamMember("Project Manager");

        buildAPI.subscribe(dev);
        buildAPI.subscribe(tester);
        buildAPI.subscribe(pm);

        // Đổi trạng thái -> Mọi người tự động nhận mail
        buildAPI.setStatus("In Progress");

        // Dev code xong, hủy theo dõi vì không liên quan nữa
        buildAPI.unsubscribe(dev);

        // Chuyển cho QC test
        buildAPI.setStatus("Testing");
    }
}