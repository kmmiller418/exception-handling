package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> readings;

    public AverageSensor(){
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        return sensors.stream()
                .allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensors.forEach(sensor -> sensor.setOn());
    }


    @Override
    public void setOff() {
        sensors.forEach(sensor -> sensor.setOff());
    }


    @Override
    public int read() {
        if (!isOn()){
            throw new IllegalStateException("Sensor is not on!");
        }

        int avg = (int) sensors.stream()
                .mapToInt(sensor -> sensor.read())
                .average().getAsDouble();

        readings.add(avg);
        return avg;
    }

    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }

    public List<Integer> readings(){
        return readings;
    }

}
