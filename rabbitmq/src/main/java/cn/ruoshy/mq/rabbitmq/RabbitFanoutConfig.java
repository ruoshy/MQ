package cn.ruoshy.mq.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitFanoutConfig {

    public final static String FANOUT_NAME = "user-fanout";

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
     * 创建交换策略 fanout
     */
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_NAME, true, false);
    }

    /**
     * 将队列与交换策略进行绑定
     */
    @Bean
    Binding binding1() {
        return BindingBuilder.bind(phoneQueue()).to(fanoutExchange());
    }

    @Bean
    Binding binding2() {
        return BindingBuilder.bind(zjsQueue()).to(fanoutExchange());
    }
}
