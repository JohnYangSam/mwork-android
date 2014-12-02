package com.siliconvalleyinsight.mwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentTaskSelectionTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_task_selection_tab, container, false);

        // has to use getActivity to use findViewById
        ImageButton oneHandTaskBtn = (ImageButton) getActivity().findViewById(R.id.one_hand_task_btn);
        Log.e("TEST", "" + (oneHandTaskBtn == null));
        oneHandTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // testing with LoginActivity
                Intent one_hand_task_intent = new Intent(getActivity(), LoginActivity.class);
                getActivity().startActivity(one_hand_task_intent);
            }
        });
        return v;
    }
}
