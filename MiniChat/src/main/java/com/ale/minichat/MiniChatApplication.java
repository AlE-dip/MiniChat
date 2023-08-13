package com.ale.minichat;

import com.ale.minichat.entity.User;
import com.ale.minichat.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MiniChatApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MiniChatApplication.class, args);

        UserService userService = context.getBean(UserService.class);

        if(userService.findFirst() == null) {
            userService.save(
                    new User().builder()
                            .username("admin")
                            .password("admin")
                            .role(User.Role.ADMIN)
                            .build()
            );
            userService.save(
                    new User().builder()
                            .username("customer")
                            .password("customer")
                            .role(User.Role.CUSTOMER)
                            .build()
            );
        }
    }

}
