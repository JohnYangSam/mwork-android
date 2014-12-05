package com.siliconvalleyinsight.mwork.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.siliconvalleyinsight.mwork.R;
import com.siliconvalleyinsight.mwork.activities.LoginActivity;
import com.siliconvalleyinsight.mwork.activities.OneHandTaskActivity;


public class FragmentTaskSelectionTab extends Fragment implements View.OnClickListener {
    private static String TAG = "FTST";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task_selection_tab, container, false);

        // Get handles to the buttons from the inflated fragment
        ImageButton oneHandTaskBtn = (ImageButton) v.findViewById(R.id.one_hand_task_btn);
        ImageButton twoHandTaskBtn = (ImageButton) v.findViewById(R.id.two_hand_task_btn);
        ImageButton secludedTaskBtn = (ImageButton) v.findViewById(R.id.secluded_task_btn);
        ImageButton singleSessionTaskBtn = (ImageButton) v.findViewById(R.id.single_session_task_button);
        ImageButton travelingTaskBtn = (ImageButton) v.findViewById(R.id.traveling_task_btn);
        ImageButton randomTaskBtn = (ImageButton) v.findViewById(R.id.random_task_btn);

        // Set the fragment to capture button clicks
        oneHandTaskBtn.setOnClickListener(this);
        twoHandTaskBtn.setOnClickListener(this);
        secludedTaskBtn.setOnClickListener(this);
        singleSessionTaskBtn.setOnClickListener(this);
        travelingTaskBtn.setOnClickListener(this);
        randomTaskBtn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        // testing with LoginActivity
        Log.e("TEST", "hit here");

        Intent intent = null;

        switch(v.getId()) {
            case R.id.one_hand_task_btn:
                Log.v(TAG, "oneHandTaskBtn clicked");
                intent = new Intent(getActivity(), OneHandTaskActivity.class);
                break;

            case R.id.two_hand_task_btn:
                Log.v(TAG, "oneHandTaskBtn clicked");
                intent = new Intent(getActivity(), LoginActivity.class);
                break;

            case R.id.secluded_task_btn:
                Log.v(TAG, "oneHandTaskBtn clicked");
                intent = new Intent(getActivity(), LoginActivity.class);
                break;

            case R.id.single_session_task_button:
                Log.v(TAG, "oneHandTaskBtn clicked");
                intent = new Intent(getActivity(), LoginActivity.class);
                break;

            case R.id.traveling_task_btn:
                Log.v(TAG, "oneHandTaskBtn clicked");
                intent = new Intent(getActivity(), LoginActivity.class);
                break;

            case R.id.random_task_btn:
                Log.v(TAG, "oneHandTaskBtn clicked");
                intent = new Intent(getActivity(), LoginActivity.class);
                break;
        }

        if (intent != null) {
            getActivity().startActivity(intent);
        }
    }
}

