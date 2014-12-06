package com.siliconvalleyinsight.mwork.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;

import com.siliconvalleyinsight.mwork.R;
import com.siliconvalleyinsight.mwork.fragments.FragmentPaymentTab;
import com.siliconvalleyinsight.mwork.fragments.FragmentSettingsTab;
import com.siliconvalleyinsight.mwork.fragments.FragmentTaskSelectionTab;
import com.siliconvalleyinsight.mwork.singletons.MWorkApp;
import com.siliconvalleyinsight.mwork.singletons.MWorkStateManager;


public class HomeActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("Home").setIndicator("Home", null),
            FragmentTaskSelectionTab.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("Payment").setIndicator("Payment", null),
            FragmentPaymentTab.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("More").setIndicator("More", null),
            FragmentSettingsTab.class, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Wizard of Oz login check

        //Comment out forced login for testing
        MWorkStateManager mStateManager = ((MWorkApp) getApplication()).getStateManager();
        if (!mStateManager.getLogin()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_menu, menu);
        return super.onCreateOptionsMenu(menu);
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
