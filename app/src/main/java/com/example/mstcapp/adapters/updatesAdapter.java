package com.example.mstcapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;

import java.util.List;

public class updatesAdapter extends RecyclerView.Adapter<updatesAdapter.updatesViewholder>{
    List <String> list_updates_titles;
    public updatesAdapter(List<String> updates_titles) {
        list_updates_titles=updates_titles;
    }

    @NonNull
    @Override
    public updatesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updates_view,parent,false);
        return new updatesAdapter.updatesViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull updatesViewholder holder, int position) {
    holder.updates_title.setText(list_updates_titles.get(position));
    }

    @Override
    public int getItemCount() {
        return list_updates_titles.size();
    }

    public class updatesViewholder extends RecyclerView.ViewHolder{
        TextView updates_title;
        public updatesViewholder(@NonNull View itemView) {
            super(itemView);
            updates_title=itemView.findViewById(R.id.update_title);
        }
    }
}
