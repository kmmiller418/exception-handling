package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean on;

    public boolean isOn() {
        return on;
    }

    public void setOn() {
        on = true;
    }

    public void setOff() {
        on = false;
    }

    public int read() {
        if (on) {
            return new Random().nextInt(-30,30);
        } else{
            throw new IllegalStateException("The TemperatureSensor is off");
        }
    }


}
