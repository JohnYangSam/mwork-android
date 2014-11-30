package com.siliconvalleyinsight.mwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentHomeTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // has to use getActivity to use findViewById
//        ImageButton oneHandTaskBtn = (ImageButton) getActivity().findViewById(R.id.one_hand_task_btn);
//        oneHandTaskBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // testing with LoginActivity
//                Intent one_hand_task_intent = new Intent(getActivity(), LoginActivity.class);
//                getActivity().startActivity(one_hand_task_intent);
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_tab, container, false);
        return v;
    }
}
