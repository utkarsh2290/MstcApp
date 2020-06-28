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
import androidx.viewpager.widget.PagerAdapter;

import com.example.mstcapp.R;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

public class ResourcesArticlesAdapter extends RecyclerView.Adapter<ResourcesArticlesAdapter.ResourcesArticleView> {

    List<String> res_article_titleList=new ArrayList<>();
    List<String> res_article_linkList=new ArrayList<>();
    Context mContext2;
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;

    public ResourcesArticlesAdapter(List<String> res_article_titleList, List<String> sample_titles_links, Context context) {
        this.res_article_titleList = res_article_titleList;
        res_article_linkList=sample_titles_links;
        mContext2=context;
    }

    @NonNull
    @Override
    public ResourcesArticleView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resources_articlelinks_view,parent,false);
        ResourcesArticleView resourcesArticleView= new ResourcesArticleView(view);
        return resourcesArticleView;
    }

    @Override
    public void onBindViewHolder(@NonNull final ResourcesArticleView holder, final int position) {
        holder.res_article_title.setText(res_article_titleList.get(position));
        holder.res_article_link.setText(res_article_linkList.get(position));
        final boolean isExpanded = position==mExpandedPosition;
        holder.res_article_link.setVisibility(isExpanded?View.VISIBLE:View.GONE);
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

        holder.res_article_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=holder.res_article_link.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse(link)));
                mContext2.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return res_article_titleList.size();
    }

    public class ResourcesArticleView extends RecyclerView.ViewHolder{

        TextView res_article_title,res_article_link;
        public ResourcesArticleView(@NonNull View itemView) {
            super(itemView);
            res_article_title=itemView.findViewById(R.id.res_article_title);
            res_article_link=itemView.findViewById(R.id.res_article_link);
            res_article_link.setVisibility(View.GONE);

        }
    }
}
