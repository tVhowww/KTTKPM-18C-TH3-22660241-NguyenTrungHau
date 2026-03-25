package edu.iuh.fit.adapter.data_converter;

// Client (Hệ thống cũ) dùng XML, nên Adapter phải implement XmlProcessor để giao tiếp với Client
public class XmlToJsonAdapter implements XmlProcessor {
    private JsonProcessor jsonService; // Hệ thống muốn kết nối tới

    public XmlToJsonAdapter(JsonProcessor jsonService) {
        this.jsonService = jsonService;
    }

    @Override
    public void processXml(String xmlData) {
        System.out.println("   -> [Adapter] Đang dịch XML sang JSON...");
        // Giả lập thuật toán convert
        String jsonData = "{ \"data\": \"converted_from_xml\" }";

        // Gọi hệ thống mới xử lý
        jsonService.processJson(jsonData);
    }
}