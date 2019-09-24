package cn.ruoshy.mq;

import cn.ruoshy.mq.rabbitmq.RabbitFanoutConfig;
import cn.ruoshy.mq.rabbitmq.RabbitHeaderConfig;
import cn.ruoshy.mq.rabbitmq.RabbitTopicConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {

    @Resource
    private RabbitTemplate template;

    /* Direct */
    @Test
    public void directPhone() {
        template.convertAndSend("phone", "11111111111");
    }

    @Test
    public void directZjs() {
        template.convertAndSend("zjs", "浙江省");
    }

    /* Fanout */
//    @Test
//    public void fanout() {
//        template.convertAndSend(RabbitFanoutConfig.FANOUT_NAME, null, "Hello world！");
//    }


    /* Topic */
//    @Test
//    public void phonTopic() {
//        template.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "phone", "11111111111");
//    }

//    @Test
//    public void zjsPhoneTopic() {
//        template.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "zjs.phone", "11111111111");
//    }

//    @Test
//    public void zjsPhoneAddressTopic() {
//        template.convertAndSend(RabbitTopicConfig.TOPIC_NAME,"zjs.phone.address", "杭州");
//    }

//    @Test
//    public void zjsNewTopic() {
//        template.convertAndSend(RabbitTopicConfig.TOPIC_NAME, "zjs.new", "新闻");
//    }

    /* header */
//    /**
//     * 添加头 name
//     */
//    @Test
//    public void whereExists() {
//        Message message = MessageBuilder.withBody("11111111111".getBytes())
//                .setHeader("name", null)
//                .build();
//        template.convertAndSend(RabbitHeaderConfig.HEADER_NAME, null, message);
//    }
//
//    /**
//     * 添加头 name 值 ruoshy
//     */
//    @Test
//    public void whereMatches() {
//        Message message = MessageBuilder.withBody("22222222222".getBytes())
//                .setHeader("name", "ruoshy")
//                .build();
//        template.convertAndSend(RabbitHeaderConfig.HEADER_NAME, null, message);
//    }
//
//    /**
//     * 添加头 name age
//     */
//    @Test
//    public void whereAnyExist() {
//        Message message = MessageBuilder.withBody("33333333333".getBytes())
//                .setHeader("name", null)
//                .setHeader("age", null)
//                .build();
//        template.convertAndSend(RabbitHeaderConfig.HEADER_NAME, null, message);
//    }
//
//    /**
//     * 添加头 name 值 ruoshy
//     * 添加头 age 值 20
//     */
//    @Test
//    public void whereAnyMatches() {
//        Message message = MessageBuilder.withBody("44444444444".getBytes())
//                .setHeader("name", "ruoshy")
//                .setHeader("age", 20)
//                .build();
//        template.convertAndSend(RabbitHeaderConfig.HEADER_NAME, null, message);
//    }
}
