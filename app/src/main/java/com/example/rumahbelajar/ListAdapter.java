package com.example.rumahbelajar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    private Context context;
    private List<Kelas> resultList;

    public ListAdapter(Context context, List<Kelas> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public ListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.item_kelas, parent, false);

        ListAdapter.MyViewHolder viewHolder = new ListAdapter.MyViewHolder(view);
        return viewHolder;
    };


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvNamaKls.setText(resultList.get(position).getTitle());
        holder.tvMapel.setText(resultList.get(position).getOverview());
        Glide.with(holder.ikon.getContext()).
                load("https://image.tmdb.org/t/p/w185" + resultList.get(position).getPosterPath()).
                into(holder.ikon);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ikon;
        TextView tvNamaKls, tvMapel;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ikon = itemView.findViewById(R.id.ikon);
            tvNamaKls = itemView.findViewById(R.id.tvNamaKls);
            tvMapel = itemView.findViewById(R.id.tvMapel);

        }
    }





}
