package com.siliconvalleyinsight.mwork.activities;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.siliconvalleyinsight.mwork.R;

// NOTE: This activity is unused


public class SecludedTaskActivityBase extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onStart() {
        super.onStart();

        // Grab buttons here in a kind of hack since we know this will be called after
        // the onCreate methods of subclasses
        Button submitButton = (Button) findViewById(R.id.submit_button);
        Button nextButton = (Button) findViewById(R.id.next_button);
        Button backButton = (Button) findViewById(R.id.back_button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
