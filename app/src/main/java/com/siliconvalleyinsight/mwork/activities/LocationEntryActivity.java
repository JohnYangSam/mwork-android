package com.siliconvalleyinsight.mwork.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.siliconvalleyinsight.mwork.R;
import com.siliconvalleyinsight.mwork.singletons.MWorkApp;


public class LocationEntryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_entry);

        Button mBackButton = (Button) findViewById(R.id.btnBack);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Button mNextButton = (Button) findViewById(R.id.btnNext);
        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Simulate login because the next activity is the home screen adn we should be logged in
                ((MWorkApp) view.getContext().getApplicationContext()).getStateManager().setLogin(true);

                // Let the user know that the registration is successful
                Context context = getApplicationContext();
                CharSequence text = "Registration Successful!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_location_entry, menu);
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
