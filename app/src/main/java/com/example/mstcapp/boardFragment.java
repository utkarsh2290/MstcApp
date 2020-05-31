package com.example.mstcapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

public class boardFragment extends Fragment {
    View view1;
    public boardFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view1=inflater.inflate(R.layout.boardfragment,container,false);
        ImageView imageView=(ImageView)view1.findViewById(R.id.imageView);
        ImageView imageView2=(ImageView)view1.findViewById(R.id.imageView2);
        ImageView imageView3=(ImageView)view1.findViewById(R.id.imageView3);
        ImageView imageView4=(ImageView)view1.findViewById(R.id.imageView4);
        ImageView imageView5=(ImageView)view1.findViewById(R.id.imageView5);
        ImageView imageView6=(ImageView)view1.findViewById(R.id.imageView6);
        ImageView imageView7=(ImageView)view1.findViewById(R.id.imageView7);

        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        imageView2.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        imageView3.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        imageView4.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        imageView5.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        imageView6.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        imageView7.setImageDrawable(ResourcesCompat.getDrawable(getResources(),R.drawable.mstclogo,null));
        return view1;
    }
}
