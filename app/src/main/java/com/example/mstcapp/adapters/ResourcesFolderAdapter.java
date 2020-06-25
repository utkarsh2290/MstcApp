package com.example.mstcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;

import java.util.ArrayList;
import java.util.List;

public class ResourcesFolderAdapter extends RecyclerView.Adapter<ResourcesFolderAdapter.ResourcesFolderView> {
    List <String> content_Title = new ArrayList<>();
    public ResourcesFolderAdapter(List<String> sample_title_resfolder) {
        content_Title=sample_title_resfolder;
    }

    @NonNull
    @Override
    public ResourcesFolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.resourcesfolder_view,parent,false);
        return new ResourcesFolderAdapter.ResourcesFolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesFolderView holder, int position) {
        holder.text_contentTitle.setText(content_Title.get(position));
    }

    @Override
    public int getItemCount() {
        return content_Title.size();
    }

    public class ResourcesFolderView extends RecyclerView.ViewHolder{

        TextView text_contentTitle;
        public ResourcesFolderView(@NonNull View itemView) {
            super(itemView);
            text_contentTitle=itemView.findViewById(R.id.resfolder_title);

        }
    }

}
