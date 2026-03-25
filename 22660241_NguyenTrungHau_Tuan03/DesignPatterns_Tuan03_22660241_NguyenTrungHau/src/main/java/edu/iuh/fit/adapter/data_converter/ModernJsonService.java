package edu.iuh.fit.adapter.data_converter;

public class ModernJsonService implements JsonProcessor {
    @Override
    public void processJson(String jsonData) {
        System.out.println("[Web Service Mới] Đang phân tích dữ liệu JSON: " + jsonData);
    }
}