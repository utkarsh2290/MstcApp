package com.example.mstcapp.highlightsFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.adapters.projectRecyclerAdapter;
import com.example.mstcapp.R;

import java.util.ArrayList;
import java.util.List;

public class projectFragment extends Fragment {

    private String projHeader,descriptionProj,contributorsProj,mediumLink_Proj;
    View view;

    public projectFragment() {
    }

    private RecyclerView recyclerView1;
    private List<projectFragment> projectsList;

    public projectFragment(String nameProj, String descripProj,String contributors, String mediumLink) {
        projHeader= nameProj;
        descriptionProj = descripProj;
        contributorsProj=contributors;
        mediumLink_Proj=mediumLink;

    }


    //Getter
    public String getProjHeader() {
        return projHeader;
    }
    public String getDescriptionProj() {
        return descriptionProj;
    }

    public String getContributorsProj() {
        return contributorsProj;
    }

    public String getMediumLink_Proj() {
        return mediumLink_Proj;
    }



    //Setter
    public void setProjHeader(String projHeader) {
        this.projHeader = projHeader;
    }

    public void setDescriptionProj(String descriptionProj) {
        this.descriptionProj = descriptionProj;
    }

    public void setContributorsProj(String contributorsProj) {
        this.contributorsProj = contributorsProj;
    }
    public void setMediumLink_Proj(String mediumLink_Proj) {
        this.mediumLink_Proj = mediumLink_Proj;
    }


   //INITIALIZING VIEWS
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_projects,container,false);
        recyclerView1=(RecyclerView)view.findViewById(R.id.projects_recycler1);
        projectRecyclerAdapter projectRecyclerAdapter= new projectRecyclerAdapter(getContext(),projectsList);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setAdapter(projectRecyclerAdapter);
    return view;
    }

    //ADDING ELEMENTS ON THE RECYLERVIEW
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        projectsList=new ArrayList<>();
        projectsList.add(new projectFragment("Mstc App","Our App is one of a kind app. Head out to playstore to and download it","Utkarsh ,Prateek ,Niharika, Prajesh","https://medium.com/student-technical-community-vit-vellore"));
        projectsList.add(new projectFragment("Notes Segragation","Our App is one of a kind app. Head out to playstore to and download it","Utkarsh ,Prateek ,Niharika, Prajesh","https://medium.com/student-technical-community-vit-vellore"));
    }
}
