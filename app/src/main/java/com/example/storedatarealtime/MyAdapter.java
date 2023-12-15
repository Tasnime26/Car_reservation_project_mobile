package com.example.storedatarealtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<DataClass> dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getDataImage()).into(holder.recImage);
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recBrand.setText(dataList.get(position).getDataBrand());


        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Image", dataList.get(position).getDataImage());
                intent.putExtra("Description", dataList.get(position).getDataDesc());
                intent.putExtra("Title", dataList.get(position).getDataTitle());
                intent.putExtra("Price", dataList.get(position).getDataPrice());
                intent.putExtra("Key", dataList.get(position).getKey());
                intent.putExtra("Brand", dataList.get(position).getDataBrand());
                context.startActivity(intent);
            }
        });

        holder.bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileActivity(position);
            }
        });
    }

    private void openProfileActivity(int position) {
        Intent intent = new Intent(context, Profil.class);

        intent.putExtra("Image2", dataList.get(position).getDataImage());
        intent.putExtra("Description", dataList.get(position).getDataDesc());
        intent.putExtra("Title2", dataList.get(position).getDataTitle());
        intent.putExtra("Key", dataList.get(position).getKey());
        intent.putExtra("Brand2", dataList.get(position).getDataBrand());
        intent.putExtra("Price", dataList.get(position).getDataPrice());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<DataClass> searchList) {
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView recImage;
    TextView recTitle, recBrand;
    CardView recCard;
    Button bookButton;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recImage);
        recCard = itemView.findViewById(R.id.recCard);
        recBrand = itemView.findViewById(R.id.recBrand);
        recTitle = itemView.findViewById(R.id.recTitle);


        bookButton = itemView.findViewById(R.id.bookButton);
    }
}
