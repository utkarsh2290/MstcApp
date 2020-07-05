package com.example.mstcapp.aboutFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mstcapp.R;

public class boardFragment extends Fragment {
    View view1;
    public boardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view1=inflater.inflate(R.layout.fragment_board,container,false);
        ImageView imageView=(ImageView)view1.findViewById(R.id.photoPresident);
        ImageView imageView2=(ImageView)view1.findViewById(R.id.photoProLead);
        ImageView imageView3=(ImageView)view1.findViewById(R.id.photoTechMentor);
        ImageView imageView4=(ImageView)view1.findViewById(R.id.photoManageLead);
        ImageView imageView5=(ImageView)view1.findViewById(R.id.photoFinanceLead);

        return view1;
    }
}
