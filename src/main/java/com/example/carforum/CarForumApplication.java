package com.example.carforum;

import com.example.carforum.entity.Post;
import com.example.carforum.entity.Topic;
import com.example.carforum.repository.TopicRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class CarForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarForumApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(TopicRepository topicRepository) throws Exception {
        return (String[] args) -> {
            Topic topic1 = new Topic(1,"Tin tức");
            Topic topic2 = new Topic(2, "Đánh giá xe");
            Topic topic3 = new Topic(3, "Bài viết || Đặt câu hỏi");
            Topic topic4 = new Topic(4, "Kinh nghiệm lái xe");
            Topic topic5 = new Topic(5, "Bảo dưỡng ô tô");
            topicRepository.save(topic1);
            topicRepository.save(topic2);
            topicRepository.save(topic3);
            topicRepository.save(topic4);
            topicRepository.save(topic5);
            topicRepository.findAll().forEach(topic -> System.out.println(topic));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
