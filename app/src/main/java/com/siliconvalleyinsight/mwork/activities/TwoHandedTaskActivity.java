package com.siliconvalleyinsight.mwork.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.siliconvalleyinsight.mwork.R;

import java.util.Random;

public class TwoHandedTaskActivity extends Activity {

    private double money;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_handed_task);
        index = -1;

        final TypedArray questions = getResources().obtainTypedArray(R.array.two_handed_questions);
        final int length = questions.length();

        ((Button)findViewById(R.id.submit_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText q1Response = ((EditText) findViewById(R.id.two_handed_question_1_response));
                EditText q2Response = ((EditText) findViewById(R.id.two_handed_question_2_response));

                if (q1Response.getText().length() < 10) {
                    Context context = getApplicationContext();
                    // Only show two digits deep of the string
                    CharSequence text = "Q1 response too short. Please write more to complete the question!";
                    int duration = Toast.LENGTH_SHORT;

                    final Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    return;
                } else if (q2Response.getText().length() < 10) {
                    Context context = getApplicationContext();
                    // Only show two digits deep of the string
                    CharSequence text = "Q2 response too short. Please write more to complete the question!";
                    int duration = Toast.LENGTH_SHORT;

                    final Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    return;
                }


                int i1 = ++index;
                int i2 = ++index;

                if ( !(i1 < length) || !(i2 < length)) {
                    i1 = 0;
                    i2 = 1;
                }

                TextView q1 = (TextView) findViewById(R.id.two_handed_question_1);
                TextView q2 = (TextView) findViewById(R.id.two_handed_question_2);

                // Setup new questions
                q1.setText(questions.getText(i1));
                q2.setText(questions.getText(i2));


                // Clear the response text
                q1Response.setText("");
                q2Response.setText("");

                money += ((double) (new Random()).nextInt(120)) / 100;

                Context context = getApplicationContext();
                // Only show two digits deep of the string
                CharSequence text = "Earned $" + String.format("%.2f", money) + "!";
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
                }, 500);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        money=0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_two_handed_task, menu);

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
