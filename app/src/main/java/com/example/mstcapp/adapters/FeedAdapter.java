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
    public FeedAdapter(List<Integer> urls_sample, List<String> desc) {
    samples=urls_sample;
    desc_sample=desc;
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
        holder.textView.setText(desc_sample.get(position));
    }

    @Override
    public int getItemCount() {
        return samples.size();
    }

    public class FeedView extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        public FeedView(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.feed_image);
            textView=itemView.findViewById(R.id.feed_description);

        }
    }
}
