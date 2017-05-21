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
        float [] gravity = new float[3];
        float [] linear_acceleration = new float[3];

        float x = gValues[0];
        float y = gValues[1];
        float z = gValues[2];

        final float alpha = (float)0.8;

        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

        linear_acceleration[0] = event.values[0] - gravity[0];
        linear_acceleration[1] = event.values[1] - gravity[1];
        linear_acceleration[2] = event.values[2] - gravity[2];
    }
}
