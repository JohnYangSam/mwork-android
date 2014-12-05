package com.siliconvalleyinsight.mwork.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.siliconvalleyinsight.mwork.R;
import com.siliconvalleyinsight.mwork.activities.HomeActivity;
import com.siliconvalleyinsight.mwork.singletons.MWorkApp;

public class FragmentSettingsTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings_tab, container, false);


        TextView mLogoutText = (TextView) v.findViewById(R.id.settings_log_out_text);
        ImageView mLogoutImage = (ImageView) v.findViewById(R.id.settings_log_out_icon);

        mLogoutText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout(view);
            }
        });

        mLogoutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout(view);
            }
        });

        return v;
    }

    private void logout(View view) {
        Intent intent = new Intent(getActivity().getApplicationContext(), HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Simulate with wizard of Oz logging out the user
        ((MWorkApp) getActivity().getApplication()).getStateManager().setLogin(false);
        getActivity().startActivity(intent);
    }
}
