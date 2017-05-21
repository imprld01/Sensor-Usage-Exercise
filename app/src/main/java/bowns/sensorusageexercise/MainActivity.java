package bowns.sensorusageexercise;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import bowns.listener.AccelerometerListener;

public class MainActivity extends AppCompatActivity {

    private SensorManager sm;
    private AccelerometerListener accListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        this.buildViews();

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        accListener = new AccelerometerListener();
    }

    @Override
    protected void onResume() {

        super.onResume();

        sm.getSensorList(Sensor.TYPE_ALL).size();

        Sensor acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(accListener, acc, sm.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {

        super.onPause();

        sm.unregisterListener(accListener);
    }

    private void buildViews() {

    }
}
