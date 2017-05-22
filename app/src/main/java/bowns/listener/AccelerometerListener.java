package bowns.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class AccelerometerListener implements SensorEventListener {

    private TextView tv_x;
    private TextView tv_y;
    private TextView tv_z;

    public AccelerometerListener(TextView tv_x, TextView tv_y, TextView tv_z) {

        this.tv_x = tv_x;
        this.tv_y = tv_y;
        this.tv_z = tv_z;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {

        /* get sensor by event, and get the sensor info by this obj */
        // Sensor acc = event.sensor;

        float [] gValues = event.values;

        double x = Math.round(gValues[0] * 100) / 100.0;
        double y = Math.round(gValues[1] * 100) / 100.0;
        double z = Math.round(gValues[2] * 100) / 100.0;

        String xs = ((x >= 0) ? "+" : "") + String.valueOf(x);
        String ys = ((y >= 0) ? "+" : "") + String.valueOf(y);
        String zs = ((z >= 0) ? "+" : "") + String.valueOf(z);

        this.tv_x.setText(xs);
        this.tv_y.setText(ys);
        this.tv_z.setText(zs);
    }
}