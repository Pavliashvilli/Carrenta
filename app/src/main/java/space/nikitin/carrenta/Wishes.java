package space.nikitin.carrenta;

import java.util.Date;

public class Wishes {
    public String nameUser;
    public String messageText;
    private long timeMessage;
    public String timeInterval;
    public String nameCar;
    public String costCar;
    public int status;

    public Wishes(){}
    public Wishes (String nameUser, String messageText ,String timeInterval,String nameCar, String costCar,int status ) {
        this.nameUser = nameUser;
        this.messageText = messageText;
        this.timeInterval = timeInterval;
        this.nameCar = nameCar;
        this.costCar = costCar;
        this.status = status;

        this.timeMessage = new Date().getTime();
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public long getTimeMessage() {
        return timeMessage;
    }

    public void setTimeMessage(long timeMessage) {
        this.timeMessage = timeMessage;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getCostCar() {
        return costCar;
    }

    public void setCostCar(String costCar) {
        this.costCar = costCar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
