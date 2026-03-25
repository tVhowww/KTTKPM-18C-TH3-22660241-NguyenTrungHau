package edu.iuh.fit.adapter.data_converter;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TRƯỜNG HỢP 1: GỬI XML VÀO WEB SERVICE (CHỈ NHẬN JSON) ===");
        String myXmlData = "<user><name>Trung Hau</name></user>";

        // Dịch vụ web mới
        JsonProcessor webAPI = new ModernJsonService();

        // Dùng Adapter để cắm dữ liệu XML vào Web API
        XmlProcessor adapter1 = new XmlToJsonAdapter(webAPI);
        adapter1.processXml(myXmlData);


        System.out.println("\n=== TRƯỜNG HỢP 2: GỬI JSON VỀ HỆ THỐNG CŨ (CHỈ NHẬN XML) ===");
        String myJsonData = "{\"user\": {\"name\": \"Trung Hau\"}}";

        // Hệ thống cũ
        XmlProcessor legacySystem = new LegacyXmlService();

        // Dùng Adapter để cắm dữ liệu JSON vào Hệ thống cũ
        JsonProcessor adapter2 = new JsonToXmlAdapter(legacySystem);
        adapter2.processJson(myJsonData);
    }
}