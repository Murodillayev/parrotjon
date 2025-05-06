package uz.pdp;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class ParrotBot extends TelegramLongPollingBot {

//    public ParrotBot() {
//        super("7971917611:AAErGQ1at9Ca3dtLyIIvSoT38Ll4b1aLo-A");
//    }


    @Override
    public String getBotToken() {
        return "7971917611:AAErGQ1at9Ca3dtLyIIvSoT38Ll4b1aLo-A";
    }

    // handler
    @Override
    public void onUpdateReceived(Update update) {
        String messageText = update.getMessage().getText();
        long chatId = update.getMessage().getChatId();
        System.out.println(update.getMessage().getFrom().getUserName() + " " + chatId);
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.setText(messageText);

        sendMessage(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return "g53_parrot_bot";
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Cannot send message: " + e.getMessage());
        }
    }

}
