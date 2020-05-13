package space.nikitin.carrenta;

import java.util.Date;

public class Message {
    public String userName;
    public String textMessge;
    private long messageTime;

    public Message(){}
    public Message(String userName, String textMessge) {
        this.userName = userName;
        this.textMessge = textMessge;
        this.messageTime = new Date().getTime();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextMessge() {
        return textMessge;
    }

    public void setTextMessge(String textMessge) {
        this.textMessge = textMessge;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
