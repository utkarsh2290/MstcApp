package com.example.mstcapp.onlineFootprint;

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
import com.example.mstcapp.adapters.githubFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class githubFragment extends Fragment {

    private String titleGithubProj,linkGithubProj;
    View view2;

    public githubFragment() {
    }

    private RecyclerView recyclerView2;
    private List<githubFragment> githubProjList;

    public githubFragment(String titleGithubProj, String linkGithubProj) {
        this.titleGithubProj = titleGithubProj;
        this.linkGithubProj = linkGithubProj;

    }

    //GETTER

    public String getTitleGithubProj() {
        return titleGithubProj;
    }

    public String getLinkGithubProj() {
        return linkGithubProj;
    }

    //SETTER

    public void setLinkGithubProj(String linkGithubProj) {
        this.linkGithubProj = linkGithubProj;
    }

    public void setTitleGithubProj(String titleGithubProj) {
        this.titleGithubProj = titleGithubProj;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view2=inflater.inflate(R.layout.github_proj_fragment,container,false);
        recyclerView2=(RecyclerView)view2.findViewById(R.id.github_recycler);
        githubFragmentAdapter githubFragmentAdapter= new githubFragmentAdapter(getContext(),githubProjList);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setAdapter(githubFragmentAdapter);
        return view2;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        githubProjList=new ArrayList<>();
        githubProjList.add(new githubFragment("Covifight","https://github.com/NavdeepChawla/"));
    }
}
