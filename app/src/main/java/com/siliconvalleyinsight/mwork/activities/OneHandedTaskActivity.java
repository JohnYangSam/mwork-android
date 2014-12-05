package com.siliconvalleyinsight.mwork.activities;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Handler;

import com.siliconvalleyinsight.mwork.R;

public class OneHandedTaskActivity extends Activity {

    // Simulate a database
    private int testCount;
    private int money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_handed_task);

        testCount = 1;

        Button mYesBtn = (Button) findViewById(R.id.btnYes);
        Button mNoBtn = (Button) findViewById(R.id.btnNo);

        mYesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick(v);
            }
        });

        mNoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick(v);
            }
        });

    }


    private void handleClick(View v) {

        if (testCount > 15) {
            // Loop around when we go through all the images
            testCount = 1;
        } else {
            testCount++;
            money++;
        }
        TypedArray imgs = getResources().obtainTypedArray(R.array.dog_test_imgs);
        ((ImageView) findViewById(R.id.imageView)).setImageResource(imgs.getResourceId(testCount, R.drawable.dog_test_1));

        // Notify user of payment/completion
        Context context = getApplicationContext();
        CharSequence text = "Earned: $" + ( ((double)money) / 100) + "!";
        int duration = Toast.LENGTH_SHORT;
        final Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        // Cancel toast faster than normal
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 400);

    }

    @Override
    protected void onResume() {
        super.onStart();
        // Start money at 0 at the beginning of each open of the activity
        money = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_one_handed_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
