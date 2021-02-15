package com.example.mstcapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.navbarFragments.feedFragment;

import java.util.List;

public class feedAdapter extends RecyclerView.Adapter <feedAdapter.FeedView>{
    List<feedFragment>mData_feed;
    Context mContext;

    public feedAdapter(List<feedFragment>mData, Context context) {
       mData_feed= mData;
        mContext=context;
    }

    @NonNull
    @Override
    public FeedView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //fills the view with card view layout made (item_feed)
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed,parent,false);
        return new FeedView(view);
    }
    //clickable to browser with image

    @Override
    public void onBindViewHolder(@NonNull FeedView holder, final int position) {
        //used to set everything in the feed page
        holder.desc_textView.setText(mData_feed.get(position).getDesc_sample1());
        holder.title_textView.setText(mData_feed.get(position).getTitle_sample1());
        holder.feed_imageView.setImageResource(mData_feed.get(position).getFeedPicture());
        holder.link_textView.setText(mData_feed.get(position).getLink_sample1());
        holder.link_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link=mData_feed.get(position).getLink_sample1();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse(link)));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData_feed.size();
    }

    public class FeedView extends RecyclerView.ViewHolder{

        ImageView feed_imageView;
        TextView desc_textView,title_textView,link_textView;
        public FeedView(@NonNull View itemView) {
            super(itemView);
            feed_imageView=(ImageView)itemView.findViewById(R.id.feed_image);
            desc_textView=itemView.findViewById(R.id.feed_description);
            title_textView=itemView.findViewById(R.id.feed_title);
            link_textView=itemView.findViewById(R.id.feed_link);

        }
    }
}
