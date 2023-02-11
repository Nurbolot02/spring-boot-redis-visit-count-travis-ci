package com.ntg.springredismvn.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserCountController {
    private final Jedis redis;

    @GetMapping
    public String countOfVisitors(){
        String countOfVisitors = "countOfVisitors";
        int count = Integer.parseInt(redis.get(countOfVisitors));
        if (count >= 10) {
            System.exit(0);
        }
        redis.set(countOfVisitors, String.valueOf(count + 1));
        return "Count of visitors: %d".formatted(count);
    }

    @GetMapping("/st")
    public String status () {
        return "OK NTG";
    }
}
