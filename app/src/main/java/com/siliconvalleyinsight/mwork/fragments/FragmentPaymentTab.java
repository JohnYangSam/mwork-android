package com.siliconvalleyinsight.mwork.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.siliconvalleyinsight.mwork.R;
import com.siliconvalleyinsight.mwork.activities.BetterCashOutActivity;

public class FragmentPaymentTab extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_payment_tab, container, false);

        Button mCashOutButton = (Button) v.findViewById(R.id.cash_out_btn);

        mCashOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(v.getContext(), BetterCashOutActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
