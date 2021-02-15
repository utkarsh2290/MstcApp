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
import com.example.mstcapp.exclusiveModels.updatesModelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class updatesAdapter extends RecyclerView.Adapter<updatesAdapter.updatesViewholder>{

    List <updatesModelClass> list_updates;
    public static int mExpandedPosition=-1;
    public static int previousExpandedPosition=-1;


    public updatesAdapter(List<updatesModelClass> list_updates) {
        this.list_updates = list_updates;
    }

    @NonNull
    @Override
    public updatesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_updates,parent,false);
        return new updatesAdapter.updatesViewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull updatesViewholder holder, final int position) {
        String date = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(new Date());
        String date_num=date.substring(0,2);
        String date_month=date.substring(3,6);
        holder.updates_title.setText(list_updates.get(position).getTitle());
        holder.updates_content.setText(list_updates.get(position).getContent());
        holder.date_num.setText(list_updates.get(position).getDate());
        holder.date_month.setText(list_updates.get(position).getMonth());
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
        return list_updates.size();
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
