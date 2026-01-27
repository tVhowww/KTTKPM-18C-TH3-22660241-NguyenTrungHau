package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.Map;

@Service
public class MessageListener {

    // Lắng nghe queue "order_queue"
    @RabbitListener(queues = "order_queue", ackMode = "MANUAL")
    public void receiveMessage(Map<String, Object> message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            System.out.println("DANG XU LY: " + message);
            String orderId = (String) message.get("orderId");

            // Giả lập lỗi nếu orderId là "fail"
            if ("fail".equals(orderId)) {
                throw new RuntimeException("Loi gia lap de test DLQ");
            }

            // Giả lập thời gian xử lý 2 giây
            Thread.sleep(2000);
            System.out.println("XU LY THANH CONG: " + orderId);

            // Báo cho RabbitMQ biết là đã xong (ACK)
            channel.basicAck(tag, false);

        } catch (Exception e) {
            System.out.println("GAPA LOI: " + e.getMessage());

            // Báo lỗi (NACK) -> RabbitMQ sẽ đẩy tin này sang DLQ
            channel.basicNack(tag, false, false);
        }
    }
}