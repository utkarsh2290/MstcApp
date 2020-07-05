package com.example.mstcapp.aboutFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mstcapp.R;

public class infoFragment extends Fragment {
    View view;
    public infoFragment() {
    }
    TextView textView_info;


    //INFLATING VIEW ONTO THE INFO SUB FRAGMENT
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_info,container,false);
        return view;
    }


    //INITIALIZING THE VIEW OF A SUB FRAGMENT
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView_info=view.findViewById(R.id.info_tv);


    }
}
