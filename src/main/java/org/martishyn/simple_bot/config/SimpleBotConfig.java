package org.martishyn.simple_bot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.martishyn.simple_bot")
@Data
public class SimpleBotConfig {
    @Value("${simple.tg.bot.name}")
    private String botName;
    @Value("${simple.tg.bot.token}")
    private String botToken;
}
