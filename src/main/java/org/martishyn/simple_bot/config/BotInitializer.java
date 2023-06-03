package org.martishyn.simple_bot.config;

import org.martishyn.simple_bot.defaultbot.SimpleTelegramBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Component
public class BotInitializer {
    private final SimpleTelegramBot simpleTelegramBot;

    public BotInitializer(SimpleTelegramBot simpleTelegramBot) {
        this.simpleTelegramBot = simpleTelegramBot;
    }

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot((LongPollingBot) simpleTelegramBot);
        } catch (TelegramApiException e) {
            System.out.println(e);
        }
    }
}
