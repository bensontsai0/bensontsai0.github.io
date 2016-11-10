package com.azuro.job.telegarm;

import org.telegram.telegrambots.BotConfig;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class SendMessageJob extends TelegramLongPollingBot{

	@Override
	public void onUpdateReceived(Update update) {
		if(update.hasMessage()){
	        Message message = update.getMessage();

	        //check if the message has text. it could also contain for example a location ( message.hasLocation() )
	        if(message.hasText()){
	            //create an object that contains the information to send back the message
	            SendMessage sendMessageRequest = new SendMessage();
	            sendMessageRequest.setChatId(message.getChatId().toString()); //who should get from the message the sender that sent it.
	            sendMessageRequest.setText("you said: " + message.getText());
	            try {
	                sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
	            } catch (TelegramApiException e) {
	            	e.getStackTrace();
	            	//do some error handling
	            }
	        }
	    }
	}

	@Override
	public String getBotUsername() {
		return BotConfig.BOT_USERNAME;
	}

	@Override
	public String getBotToken() {
		return BotConfig.BOT_TOKEN;
	}

}
