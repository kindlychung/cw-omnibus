package com.commonsware.android.containers.sampler;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LayoutFragment extends Fragment {
    private static final String ARG_LAYOUT="layout";

    static LayoutFragment newInstance(int layoutId) {
        LayoutFragment result=new LayoutFragment();
        Bundle args=new Bundle();

        args.putInt(ARG_LAYOUT, layoutId);
        result.setArguments(args);

        return(result);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        assert getArguments() != null;
        return inflater.inflate(
                getArguments().getInt(ARG_LAYOUT),
                container,
                false);
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        View compassButton=view.findViewById(R.id.compassButton);
        if (compassButton!=null) {
            compassButton.setOnClickListener(v -> {
                View group=view.findViewById(R.id.directions);
                if (group.getVisibility()==View.VISIBLE) {
                    group.setVisibility(View.GONE);
                }
                else {
                    group.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
