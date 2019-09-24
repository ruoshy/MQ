package cn.ruoshy.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "phone")
    public void phone(String message) {
        System.out.println("phone - " + message);
    }

    @RabbitListener(queues = "zjs")
    public void news(String message) {
        System.out.println("zjs - " + message);
    }

//    @RabbitListener(queues = "phone")
//    public void phone(byte[] bytes) {
//        System.out.println("phone - " + new String(bytes));
//    }
}
