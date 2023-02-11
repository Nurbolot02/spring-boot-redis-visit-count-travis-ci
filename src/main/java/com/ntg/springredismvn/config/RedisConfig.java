package com.ntg.springredismvn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
    @Bean
    @Profile("!dev")
    public Jedis redis() {
        Jedis jedis = new Jedis("redis", 6379);
        jedis.set("countOfVisitors", "0");
        return jedis;
    }
}
