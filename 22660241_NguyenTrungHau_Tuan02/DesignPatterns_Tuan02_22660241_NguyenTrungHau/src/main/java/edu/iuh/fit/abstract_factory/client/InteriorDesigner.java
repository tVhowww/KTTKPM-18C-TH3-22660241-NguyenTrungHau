package edu.iuh.fit.abstract_factory.client;

import edu.iuh.fit.abstract_factory.factory.FurnitureFactory;
import edu.iuh.fit.abstract_factory.product.Chair;
import edu.iuh.fit.abstract_factory.product.CoffeeTable;
import edu.iuh.fit.abstract_factory.product.Sofa;

public class InteriorDesigner {
    private Chair chair;
    private Sofa sofa;
    private CoffeeTable table;

    // Client nhận một factory cụ thể và tạo ra toàn bộ họ sản phẩm tương ứng
    public InteriorDesigner(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
        this.table = factory.createCoffeeTable();
    }

    public void decorate() {
        System.out.println("Đang thiết kế phòng với các nội thất sau:");
        chair.sitOn();
        sofa.lieOn();
        table.putCoffee();
    }
}