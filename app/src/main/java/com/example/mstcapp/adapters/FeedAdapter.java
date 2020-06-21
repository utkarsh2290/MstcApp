package com.example.mstcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;

import java.util.ArrayList;
import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter <FeedAdapter.FeedView>{
    List <Integer> samples=new ArrayList<>();
    List <String> desc_sample=new ArrayList<>();
    List <String> title_sample=new ArrayList<>();
    List <String> link_sample=new ArrayList<>();

    public FeedAdapter(List<Integer> urls_sample, List<String> desc, List <String> title,List <String> links) {
    samples=urls_sample;
    desc_sample=desc;
    title_sample=title;
    link_sample=links;
    }

    @NonNull
    @Override
    public FeedView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //fills the view with card view layout made (feed_view)
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_view,parent,false);
        return new FeedView(view);
    }
    //clickable to browser with image

    @Override
    public void onBindViewHolder(@NonNull FeedView holder, int position) {
        holder.imageView.setImageResource(samples.get(position));
        holder.desc_textView.setText(desc_sample.get(position));
        holder.title_textvView.setText(title_sample.get(position));
        holder.link_textView.setText(link_sample.get(position));
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    public class FeedView extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView desc_textView,title_textvView,link_textView;
        public FeedView(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.feed_image);
            desc_textView=itemView.findViewById(R.id.feed_description);
            title_textvView=itemView.findViewById(R.id.feed_title);
            link_textView=itemView.findViewById(R.id.feed_link);

        }
    }
}
