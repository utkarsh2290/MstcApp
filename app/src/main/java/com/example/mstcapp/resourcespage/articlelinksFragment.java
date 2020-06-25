package com.example.mstcapp.resourcespage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.adapters.ResourcesArticlesAdapter;

import java.util.ArrayList;
import java.util.List;

public class articlelinksFragment extends Fragment {
    List <String> sample_titles_article = new ArrayList<>();
    RecyclerView res_article_recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_articlelinks,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sample_titles_article.add("Article sample : Android 101");
        sample_titles_article.add("Using Shared pref in Andreoid");
        sample_titles_article.add("Another random title goes here");

        res_article_recyclerview=view.findViewById(R.id.res_article_recyclerview);
        res_article_recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        res_article_recyclerview.setAdapter(new ResourcesArticlesAdapter(sample_titles_article));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        sample_titles_article.clear();
    }
}
