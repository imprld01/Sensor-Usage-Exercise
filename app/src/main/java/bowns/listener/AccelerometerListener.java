package bowns.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/**
 * Created by bowns on 5/21/2017.
 */

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

        for(float gValue : gValues) {
            float temp = gValue;
        }
    }
}
