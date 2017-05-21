package bowns.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class AccelerometerListener implements SensorEventListener {

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {

        Sensor acc = event.sensor;

        acc.getName();
        acc.getType();
        acc.getPower();
        acc.getVendor();

        float [] gValues = event.values;

        float x = gValues[0];
        float y = gValues[1];
        float z = gValues[2];
    }
}
