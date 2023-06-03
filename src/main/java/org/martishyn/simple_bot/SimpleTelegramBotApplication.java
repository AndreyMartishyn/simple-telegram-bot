package org.martishyn.simple_bot;

import org.martishyn.simple_bot.defaultbot.SimpleTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class SimpleTelegramBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(SimpleTelegramBotApplication.class, args);
	}
}
