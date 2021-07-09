package com.test.spring.boot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class HelloService {

    @Value("${message.default}")
    private String message;

    public String getMessage(String message) {
        return "Hey, " + message;
    }
}
