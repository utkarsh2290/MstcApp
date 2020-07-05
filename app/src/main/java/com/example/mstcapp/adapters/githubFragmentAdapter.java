package com.example.mstcapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.highlightsFragment.githubFragment;

import java.util.List;

public class githubFragmentAdapter extends RecyclerView.Adapter<githubFragmentAdapter.myViewHolder> {

    Context mContext2;
    List<githubFragment> mData2;
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;

    public githubFragmentAdapter(Context mContext2, List<githubFragment> mData2) {
        this.mContext2 = mContext2;
        this.mData2 = mData2;
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v2;
        v2= LayoutInflater.from(mContext2).inflate(R.layout.item_github, parent, false);
        myViewHolder vHolder2 = new myViewHolder(v2);
        return vHolder2;
    }



    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, final int position) {
        holder.githubProj_link.setText(mData2.get(position).getLinkGithubProj());
        holder.githubProj_title.setText(mData2.get(position).getTitleGithubProj());
        holder.githubProj_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=mData2.get(position).getLinkGithubProj();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse(link)));
                mContext2.startActivity(intent);
            }
        });
        final boolean isExpanded = position==mExpandedPosition;
        holder.githubProj_link.setVisibility(isExpanded?View.VISIBLE:View.GONE);
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
    }

    @Override
    public int getItemCount() {
        return mData2.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private TextView githubProj_link,githubProj_title;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            githubProj_link = (TextView) itemView.findViewById(R.id.tv_repo_link);
            githubProj_title = (TextView) itemView.findViewById(R.id.tv_github_title);
            githubProj_link.setVisibility(View.GONE);
        }

    }

}
