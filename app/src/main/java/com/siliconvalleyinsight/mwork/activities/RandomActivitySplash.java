package com.siliconvalleyinsight.mwork.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

import com.siliconvalleyinsight.mwork.R;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RandomActivitySplash extends Activity {
    private static final int AUTO_HIDE_DELAY_MILLIS = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_random_activity_splash);

        // Got to real task
        delayToNextActivity();
    }

    private static final ScheduledExecutorService worker =
            Executors.newSingleThreadScheduledExecutor();

    void delayToNextActivity() {
        Runnable task = new Runnable() {
            public void run() {
                Intent intent = new Intent(getApplicationContext(), TwoHandedTaskActivity.class);
                startActivity(intent);
            }
        };
        worker.schedule(task, 1, TimeUnit.SECONDS);
    }
}
