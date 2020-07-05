package com.example.mstcapp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.resourcespageFragments.ResourcesDetails;

import java.util.ArrayList;
import java.util.List;

public class ResourcesAdapter extends RecyclerView.Adapter<ResourcesAdapter.ResourcesView> {
     static List<String> domains= new ArrayList<>();
     List<Integer> domain_background_Id=new ArrayList<>();


    public ResourcesAdapter(List<String> domains,List <Integer> domainbg) {
        this.domains = domains;    //constructor used for initialising the list in the the view
        domain_background_Id=domainbg;
    }

    @NonNull
    @Override
    public ResourcesView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //fills the view with card view layout made (row_domains)
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_domains,parent,false);
        return new ResourcesView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesView holder, int position) {
        //domain title and card
        holder.texttitle.setText(domains.get(position));
        holder.domain_bgImage.setImageResource(domain_background_Id.get(position));

    }

    @Override
    public int getItemCount() {
        return domains.size(); //size of the list
    }

    public static class ResourcesView extends RecyclerView.ViewHolder{

        TextView texttitle;
        ImageView domain_bgImage;
        public ResourcesView(@NonNull View itemView) {
            super(itemView);
            texttitle=(TextView)itemView.findViewById(R.id.domaintitle);
            domain_bgImage=(ImageView)itemView.findViewById(R.id.res_domainImage) ;

            //OnClick Listener to go to the resource page of the particular domain when clicked

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i =new Intent(v.getContext(), ResourcesDetails.class);
                    i.putExtra("test",domains.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });

        }
    }
}
