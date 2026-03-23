package edu.iuh.fit.composite.ui_components;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo các thành phần đơn lẻ (Lá)
        UIWidget lblUsername = new Label("Username:");
        UIWidget txtUsername = new Button("Nhập Username vào đây..."); // Tạm dùng Button giả làm Input

        UIWidget lblPassword = new Label("Password:");
        UIWidget txtPassword = new Button("Nhập Password vào đây...");

        UIWidget btnLogin = new Button("Đăng nhập");
        UIWidget btnCancel = new Button("Hủy");

        // 2. Tạo Khung nhập liệu (Panel con 1)
        Panel formPanel = new Panel("Form Input");
        formPanel.addWidget(lblUsername);
        formPanel.addWidget(txtUsername);
        formPanel.addWidget(lblPassword);
        formPanel.addWidget(txtPassword);

        // 3. Tạo Khung chứa nút bấm (Panel con 2)
        Panel actionPanel = new Panel("Action Buttons");
        actionPanel.addWidget(btnLogin);
        actionPanel.addWidget(btnCancel);

        // 4. Tạo Hộp thoại chính (Panel cha chứa 2 Panel con)
        Panel loginDialog = new Panel("LOGIN DIALOG");
        loginDialog.addWidget(formPanel);
        loginDialog.addWidget(actionPanel);

        // 5. Render toàn bộ giao diện chỉ bằng 1 lệnh gọi từ thằng cha ngoài cùng
        System.out.println("=== RENDER GIAO DIỆN NGƯỜI DÙNG ===\n");
        loginDialog.render("");
    }
}