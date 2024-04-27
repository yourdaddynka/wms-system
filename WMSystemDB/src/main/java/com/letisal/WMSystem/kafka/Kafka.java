//package com.letisal.WMSystem.kafka;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//
//@Configuration
//public class Kafka {
//    @Bean
//    public NewTopic newTopicTESTCONNECT(){
//        return TopicBuilder.name("TESTCONNECT")
//                .partitions(2)
//                .replicas(2)
//                .build();
//    }
//    @Bean
//    public NewTopic newTopicProduct(){
//        return TopicBuilder.name("dbProduct")
//                .partitions(2)
//                .replicas(2)
//                .build();
//    }
//    @Bean
//    public NewTopic newTopicDocument(){
//        return TopicBuilder.name("dbDocument")
//                .partitions(2)
//                .replicas(2)
//                .build();
//    }
//    @Bean
//    public NewTopic newTopicProvider(){
//        return TopicBuilder.name("dbProvider")
//                .partitions(2)
//                .replicas(2)
//                .build();
//    }
//}
