package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList hk_id, hk_name, hk_time, hk_length;
    CustomAdapter(Context context, ArrayList hk_id, ArrayList hk_name, ArrayList hk_time, ArrayList hk_length) {
        this.context = context;
        this.hk_id = hk_id;
        this.hk_name = hk_name;
        this.hk_time = hk_time;
        this.hk_length = hk_length;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.hk_id_txt.setText(String.valueOf(hk_id.get(position)));
        holder.hk_name_txt.setText(String.valueOf(hk_name.get(position)));
        holder.hk_time_txt.setText(String.valueOf(hk_time.get(position)));
        holder.hk_length_txt.setText(String.valueOf(hk_length.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intern = new Intent(context, UpdateActivity.class);
                intern.putExtra("id", String.valueOf(hk_id.get(position)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return hk_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView hk_id_txt, hk_name_txt, hk_time_txt, hk_length_txt;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            hk_id_txt = itemView.findViewById(R.id.hk_id_text);
            hk_name_txt = itemView.findViewById(R.id.hk_name_text);
            hk_time_txt = itemView.findViewById(R.id.hk_time_text);
            hk_length_txt = itemView.findViewById(R.id.hk_length_text);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
