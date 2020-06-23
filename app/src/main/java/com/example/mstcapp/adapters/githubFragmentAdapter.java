package com.example.mstcapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.onlineFootprint.githubFragment;

import java.util.List;

public class githubFragmentAdapter extends RecyclerView.Adapter<githubFragmentAdapter.myViewHolder> {

    Context mContext2;
    List<githubFragment> mData2;

    public githubFragmentAdapter(Context mContext2, List<githubFragment> mData2) {
        this.mContext2 = mContext2;
        this.mData2 = mData2;
    }


    @NonNull
    @Override
    public githubFragmentAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v2;
        v2= LayoutInflater.from(mContext2).inflate(R.layout.items_github_proj, parent, false);
        myViewHolder vHolder2 = new myViewHolder(v2);
        return vHolder2;
    }



    @Override
    public void onBindViewHolder(@NonNull githubFragmentAdapter.myViewHolder holder, int position) {
        holder.githubProj_link.setText(mData2.get(position).getTitleGithubProj());
        holder.githubProj_title.setText(mData2.get(position).getLinkGithubProj());
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
        }

    }

}
