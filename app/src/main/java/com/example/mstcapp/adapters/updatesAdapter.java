package com.example.mstcapp.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class updatesAdapter extends RecyclerView.Adapter<updatesAdapter.updatesViewholder>{
    List <String> list_updates_titles;
    List <String> list_updates_content;
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;
    public updatesAdapter(List<String> updatesTitles, List<String> updates_content) {
        list_updates_titles=updatesTitles;
        list_updates_content=updates_content;

    }

    @NonNull
    @Override
    public updatesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.updates_view,parent,false);
        return new updatesAdapter.updatesViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull updatesViewholder holder, final int position) {
    holder.updates_title.setText(list_updates_titles.get(position));
    holder.updates_content.setText(list_updates_content.get(position));
        final boolean isExpanded = position==mExpandedPosition;
        holder.updates_content.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.imageView_updates.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.date_month.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.date_num.setVisibility(isExpanded?View.VISIBLE:View.GONE);

        holder.itemView.setActivated(isExpanded);
        if (isExpanded)
            previousExpandedPosition = position;

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date());
                String date_num=date.substring(0,2);
                String date_month=date.substring(3,6);
                Log.i("Date is ",date+" "+date_num+" "+date_month);
                mExpandedPosition = isExpanded ? -1:position;
                notifyItemChanged(previousExpandedPosition);
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_updates_titles.size();
    }

    public class updatesViewholder extends RecyclerView.ViewHolder{
        ImageView imageView_updates;
        TextView updates_title, updates_content;
        TextView date_num,date_month;
        public updatesViewholder(@NonNull View itemView) {
            super(itemView);
            updates_title=itemView.findViewById(R.id.update_title);
            updates_content=itemView.findViewById(R.id.updates_content);
            imageView_updates=itemView.findViewById(R.id.updates_image);
            date_month=itemView.findViewById(R.id.updates_month);
            date_num=itemView.findViewById(R.id.updates_date_num);

            date_num.setVisibility(View.GONE);
            date_month.setVisibility(View.GONE);
            imageView_updates.setVisibility(View.GONE);
            updates_content.setVisibility(View.GONE);
        }

    }
}
