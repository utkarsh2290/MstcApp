package com.example.mstcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class ResourcesArticlesAdapter extends RecyclerView.Adapter<ResourcesArticlesAdapter.ResourcesArticleView> {

    List<String> res_article_titleList=new ArrayList<>();

    public ResourcesArticlesAdapter(List<String> res_article_titleList) {
        this.res_article_titleList = res_article_titleList;
    }

    @NonNull
    @Override
    public ResourcesArticleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resources_articlelinks_view,parent,false);
        ResourcesArticleView resourcesArticleView= new ResourcesArticleView(view);
        return resourcesArticleView;
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesArticleView holder, int position) {
        holder.res_article_title.setText(res_article_titleList.get(position));
    }

    @Override
    public int getItemCount() {
        return res_article_titleList.size();
    }

    public class ResourcesArticleView extends RecyclerView.ViewHolder{

        TextView res_article_title;
        public ResourcesArticleView(@NonNull View itemView) {
            super(itemView);
            res_article_title=itemView.findViewById(R.id.res_article_title);
        }
    }
}
