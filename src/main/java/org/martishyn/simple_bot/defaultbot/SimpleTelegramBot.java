package org.martishyn.simple_bot.defaultbot;

import org.martishyn.simple_bot.config.SimpleBotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class SimpleTelegramBot extends TelegramLongPollingBot {
    private final SimpleBotConfig simpleBotConfig;

    public SimpleTelegramBot(SimpleBotConfig simpleBotConfig) {
        this.simpleBotConfig = simpleBotConfig;
    }

    @Override
    public String getBotToken() {
        return simpleBotConfig.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        var from = update.getMessage().getChatId();
        sendAnswer(from, "hello, boy");
    }

    @Override
    public String getBotUsername() {
        return simpleBotConfig.getBotName();
    }

    public void sendAnswer(Long client, String answer) {
        SendMessage sendMessage = SendMessage.builder()
                .chatId(client.toString())
                .text(answer)
                .build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
