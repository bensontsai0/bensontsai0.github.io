package com.azuro.job.telegram;

import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;

import com.azuro.job.telegarm.GetMessage;

public class Test {

	public static void main(String[] args) {
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
	    try {
	        telegramBotsApi.registerBot(new GetMessage());
	    } catch (TelegramApiException e) {
	        BotLogger.error("Benson", e);
	    }
	}

}
