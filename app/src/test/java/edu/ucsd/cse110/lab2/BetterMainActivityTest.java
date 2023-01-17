package edu.ucsd.cse110.lab2;

import static org.junit.Assert.assertEquals;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_one_plus_one_equal_two() {
        var scenario = ActivityScenario.launch(MainActivity.class);
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            assertEquals(scenario.getState(), Lifecycle.State.STARTED);

            Button button1 = activity.findViewById(R.id.btn_one);
            assertEquals(button1.performClick(),true);
            Button button2 = activity.findViewById(R.id.btn_plus);
            assertEquals(button2.performClick(),true);
            Button button3 = activity.findViewById(R.id.btn_one);
            assertEquals(button3.performClick(),true);
            Button button4 = activity.findViewById(R.id.btn_equals);
            assertEquals(button4.performClick(),true);

            TextView result = activity.findViewById(R.id.display);
            assertEquals(result.getText().toString(), "2");


        });
    }
}
