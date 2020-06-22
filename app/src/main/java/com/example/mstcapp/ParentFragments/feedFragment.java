package com.example.mstcapp.ParentFragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mstcapp.LoginActivity;
import com.example.mstcapp.MainActivity;
import com.example.mstcapp.R;
import com.google.firebase.auth.FirebaseAuth;

public class feedFragment extends Fragment {


    View feedFragment;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);



    }


}
