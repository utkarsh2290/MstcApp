package com.example.mstcapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class projectFragment extends Fragment {

    private String projHeader;
    private String descriptionProj;
    View view;

    public projectFragment() {
    }

    private RecyclerView recyclerView1;
    private List<projectFragment> projectsList;

    public projectFragment(String nameProj, String descripProj) {
        projHeader= nameProj;
        descriptionProj = descripProj;
    }


    //Getter
    public String getProjHeader() {
        return projHeader;
    }
    public String getDescriptionProj() {
        return descriptionProj;
    }

    //Setter



    public void setProjHeader(String projHeader) {
        this.projHeader = projHeader;
    }

    public void setDescriptionProj(String descriptionProj) {
        this.descriptionProj = descriptionProj;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.projectsfragment,container,false);
        recyclerView1=(RecyclerView)view.findViewById(R.id.projects_recycler1);
        projectRecyclerAdapter projectRecyclerAdapter= new projectRecyclerAdapter(getContext(),projectsList);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setAdapter(projectRecyclerAdapter);
    return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        projectsList=new ArrayList<>();
        projectsList.add(new projectFragment("Mstc App","Our App"));
        projectsList.add(new projectFragment("Notes Segragation","Another App"));
    }

}
