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

import com.example.mstcapp.Adapters.eventFragmentAdapter;
import com.example.mstcapp.Adapters.githubFragmentAdapter;
import com.example.mstcapp.R;

import java.util.List;

public class githubFragment extends Fragment {

    private String headerProj;
    private String descriptionProj;
    private String linkProj;
    private int Photo;
    View view;
    public githubFragment() {
    }
/*
    private RecyclerView recyclerView2;
    private List<githubFragment> githubLists;

    public githubFragment(String nameProj, String descripProj,int photo,String linkproj) {
        headerProj= nameProj;
        descriptionProj = descripProj;
        Photo=photo;
        linkProj=linkproj;

    }

    //GETTER
    public String getHeaderProj() {
        return headerProj;
    }

    public String getDescriptionProj() {
        return descriptionProj;
    }

    public String getLinkProj() {
        return linkProj;
    }

    public int getPhoto() {
        return Photo;
    }


    //SETTER
    public void setHeaderProj(String headerProj) {
        this.headerProj = headerProj;
    }

    public void setDescriptionProj(String descriptionProj) {
        this.descriptionProj = descriptionProj;
    }

    public void setLinkProj(String linkProj) {
        this.linkProj = linkProj;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.github_proj_fragment,container,false);

        recyclerView2=(RecyclerView)view.findViewById(R.id.github_recycler);
        githubFragmentAdapter recyclerAdapter2= new githubFragmentAdapter(getContext(),githubLists);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView2.setAdapter(recyclerAdapter2);
        return view;
    }*/
}
