package edu.iuh.fit.adapter.data_converter;

public class LegacyXmlService implements XmlProcessor {
    @Override
    public void processXml(String xmlData) {
        System.out.println("[Hệ thống Cũ] Đang xử lý dữ liệu XML: " + xmlData);
    }
}