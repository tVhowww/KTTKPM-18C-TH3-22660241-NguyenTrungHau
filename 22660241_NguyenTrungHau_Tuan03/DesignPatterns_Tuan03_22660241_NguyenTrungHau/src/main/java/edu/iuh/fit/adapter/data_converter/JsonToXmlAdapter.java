package edu.iuh.fit.adapter.data_converter;

public class JsonToXmlAdapter implements JsonProcessor {
    private XmlProcessor xmlService;

    public JsonToXmlAdapter(XmlProcessor xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void processJson(String jsonData) {
        System.out.println("   -> [Adapter] Đang dịch JSON ngược về XML...");
        // Giả lập thuật toán convert
        String xmlData = "<data>converted_from_json</data>";

        xmlService.processXml(xmlData);
    }
}