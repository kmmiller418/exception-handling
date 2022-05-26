package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean on;

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void setOn() {
        on = true;
    }

    @Override
    public void setOff() {
        on = false;
    }

    @Override
    public int read() {
        if (on) {
            return new Random().nextInt(-30,30);
        } else{
            throw new IllegalStateException("The TemperatureSensor is off");
        }
    }


}
