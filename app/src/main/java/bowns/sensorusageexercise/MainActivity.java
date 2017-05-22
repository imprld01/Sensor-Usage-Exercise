package bowns.sensorusageexercise;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        this.buildViews();

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {

        super.onResume();

        sm.getSensorList(Sensor.TYPE_ALL).size();

        Sensor acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, acc, sm.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {

        super.onPause();

        sm.unregisterListener(this);
    }

    private void buildViews() {

        TextView tv_x = (TextView)findViewById(R.id.x_axis);
        TextView tv_y = (TextView)findViewById(R.id.y_axis);
        TextView tv_z = (TextView)findViewById(R.id.z_axis);

        tv_x.setTextSize(25);
        tv_y.setTextSize(25);
        tv_z.setTextSize(25);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {

        TextView tv_x = (TextView)findViewById(R.id.x_axis);
        TextView tv_y = (TextView)findViewById(R.id.y_axis);
        TextView tv_z = (TextView)findViewById(R.id.z_axis);

        Sensor acc = event.sensor;

        acc.getName();
        acc.getType();
        acc.getPower();
        acc.getVendor();

        float [] gValues = event.values;

        tv_x.setText("X-Axis: " + String.valueOf(gValues[0]));
        tv_y.setText("Y-Axis: " + String.valueOf(gValues[1]));
        tv_z.setText("Z-Axis: " + String.valueOf(gValues[2]));
        float y = gValues[1];
        float z = gValues[2];
    }
}
