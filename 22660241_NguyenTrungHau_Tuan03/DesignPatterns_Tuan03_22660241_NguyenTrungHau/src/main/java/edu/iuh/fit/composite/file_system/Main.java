package edu.iuh.fit.composite.file_system;

public class Main {
    public static void main(String[] args) {
        // 1. Tạo các tập tin (Files)
        FileComponent file1 = new File("tai_lieu.docx", 1200);
        FileComponent file2 = new File("hinh_anh.png", 3500);
        FileComponent file3 = new File("bao_cao_cuoi_ky.pdf", 5000);
        FileComponent file4 = new File("mat_khau.txt", 1);

        // 2. Tạo các thư mục (Directories)
        Directory rootFolder = new Directory("C:");
        Directory docFolder = new Directory("Documents");
        Directory picFolder = new Directory("Pictures");
        Directory secretFolder = new Directory("Secret_Do_Not_Open");

        // 3. Xây dựng cấu trúc cây
        // Đưa file vào thư mục con
        docFolder.addComponent(file1);
        docFolder.addComponent(file3);

        picFolder.addComponent(file2);

        secretFolder.addComponent(file4);

        // Đưa thư mục con vào thư mục gốc (Root)
        rootFolder.addComponent(docFolder);
        rootFolder.addComponent(picFolder);

        // Thư mục Secret nằm lồng bên trong thư mục Documents
        docFolder.addComponent(secretFolder);

        // 4. Hiển thị toàn bộ cấu trúc cây
        System.out.println("=== CẤU TRÚC HỆ THỐNG TẬP TIN ===");
        rootFolder.display("|");
    }
}