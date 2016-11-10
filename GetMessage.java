package com.azuro.job.telegarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.telegram.telegrambots.BotConfig;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class GetMessage extends TelegramLongPollingBot{
	private List<String> allMsg = new ArrayList<String>();
	private String msgs = "";
	Calendar cal = Calendar.getInstance();
	Calendar cal2 = Calendar.getInstance();
	@Override
	public void onUpdateReceived(Update update) {
		cal2.set(Calendar.HOUR, 12);
		cal2.set(Calendar.MINUTE, 01);
		cal = Calendar.getInstance();
		if(update.hasMessage()){
	        Message message = update.getMessage();

	        //check if the message has text. it could also contain for example a location ( message.hasLocation() )
	        if(message.hasText()){
	            //create an object that contains the information to send back the message
	        	if( "-161423892".equals( message.getChatId().toString() ) ){
	        		
//		            sendMessageRequest.setText("you said: " + message.getText());
		            allMsg.add(message.getText().replace("/", ""));
		            System.out.println(message.getText());
		            System.out.println(cal);
		            System.out.println(cal2);
		            for(String msg: allMsg){
		            	System.out.println("array" + msg);
	            	}
	        	}
	        }
	    }
		
		if( cal.get(Calendar.HOUR_OF_DAY) == cal2.get(Calendar.HOUR_OF_DAY) && cal.get(Calendar.MINUTE) == cal2.get(Calendar.MINUTE) ){
        	msgs = "";
        	for(String msg: allMsg){
        		msgs = msgs + msg;
        	}
        	allMsg = new ArrayList<String>();
        	if(!"".equals(msgs)){
        		SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId("-161423892"); //who should get from the message the sender that sent it.
            	sendMessageRequest.setText("you said: " + msgs);
            	System.out.println("you said: " + msgs);
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
