package cn.ruoshy.mq.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirectConfig {

    public final static String DIRECT_NAME = "user-direct";

    /**
     * 创建队列 test-queue
     */
    @Bean
    Queue phoneQueue() {
        return new Queue("phone");
    }

    @Bean
    Queue zjsQueue() {
        return new Queue("zjs");
    }

    /**
     * 创建交换策略 direct
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(DIRECT_NAME, true, false);
    }

    /**
     * 将队列与交换策略进行绑定
     */
    @Bean
    Binding binding1() {
        return BindingBuilder.bind(phoneQueue())
                .to(directExchange()).with("direct");
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(zjsQueue())
                .to(directExchange()).with("direct");
    }
}
