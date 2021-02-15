package com.example.mstcapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.highlightsFragment.projectFragment;

import java.util.List;

public class projectRecyclerAdapter extends RecyclerView.Adapter<projectRecyclerAdapter.myViewHolder> {

    Context mContext1;
    List<projectFragment> mData1;
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;

    public projectRecyclerAdapter(Context mContext1, List<projectFragment> mData) {
        this.mContext1 = mContext1;
        this.mData1 = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext1).inflate(R.layout.item_projects, parent, false);
        myViewHolder vHolder = new myViewHolder(v);
        return vHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final myViewHolder holder, final int position) {
        holder.proj_name.setText(mData1.get(position).getProjHeader());
        holder.proj_descrip.setText(mData1.get(position).getDescriptionProj());
        holder.proj_mediumLink.setText(mData1.get(position).getMediumLink_Proj());
        holder.proj_contributors.setText("Contributors : "+mData1.get(position).getContributorsProj());

        final boolean isExpanded = position==mExpandedPosition;
        holder.proj_descrip.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.proj_mediumLink.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.proj_contributors.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        if (isExpanded)
            previousExpandedPosition = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
        holder.proj_mediumLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=mData1.get(position).getMediumLink_Proj();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse(link)));
                mContext1.startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return mData1.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder {

        private TextView proj_name,proj_descrip,proj_contributors,proj_mediumLink;
        CardView cardView_project;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            proj_name = (TextView) itemView.findViewById(R.id.tv_name_proj);
            proj_descrip = (TextView) itemView.findViewById(R.id.tv_descrip_proj);
            proj_contributors=(TextView)itemView.findViewById(R.id.tv_contributors_proj);
            proj_mediumLink=(TextView)itemView.findViewById(R.id.tv_mediumLink_proj);
            proj_descrip.setVisibility(View.GONE);
            proj_contributors.setVisibility(View.GONE);
            proj_mediumLink.setVisibility(View.GONE);
            cardView_project=itemView.findViewById(R.id.project_cardview);
        }
    }
}
