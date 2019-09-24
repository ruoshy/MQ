package cn.ruoshy.mq.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

//@Configuration
public class RabbitHeaderConfig {

    public final static String HEADER_NAME = "user_header";

    /**
     * 创建队列 test-queue
     */
    @Bean
    Queue phoneQueue() {
        return new Queue("phone");
    }

    /**
     * 创建交换策略 header
     */
    @Bean
    HeadersExchange topicExchange() {
        return new HeadersExchange(HEADER_NAME, true, false);
    }


    /**
     * 若头存在 name 使用该策略
     */
    @Bean
    Binding binding1() {
        return BindingBuilder.bind(phoneQueue())
                .to(topicExchange())
                .where("name")
                .exists();
    }

    /**
     * 若头存在 name 且值为 ruoshy 使用该策略
     */
    @Bean
    Binding binding2() {
        return BindingBuilder.bind(phoneQueue()).to(topicExchange())
                .where("name")
                .matches("ruoshy");
    }

    /**
     * 若存在 name，age 使用该策略
     */
    @Bean
    Binding binding3() {
        return BindingBuilder.bind(phoneQueue()).to(topicExchange())
                .whereAny("name", "age")
                .exist();
    }

    /**
     * 若头存在 name，age 且值分别为 ruoshy，20 使用该策略
     */
    @Bean
    Binding binding4() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ruoshy");
        map.put("age", 20);
        return BindingBuilder.bind(phoneQueue()).to(topicExchange())
                .whereAny(map)
                .match();
    }
}
