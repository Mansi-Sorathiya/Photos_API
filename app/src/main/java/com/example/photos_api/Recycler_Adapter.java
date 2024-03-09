package com.example.photos_api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.Holder> {
    MainActivity mainActivity;
    ArrayList<DataModel> dataList;

    public Recycler_Adapter(MainActivity mainActivity, ArrayList<DataModel> dataList) {
        this.mainActivity = mainActivity;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mainActivity).inflate(R.layout.recycle_item,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.albumid.setText("albumId : "+dataList.get(position).getAlbumid());
        holder.id.setText("Id : "+dataList.get(position).getId());
        holder.title.setText("title : "+dataList.get(position).getTitle());
        holder.url.setText("Url : "+dataList.get(position).getUrl());
        holder.thumbnailurl.setText("Thumbnailurl : "+dataList.get(position).getThumbnailurl());
        Glide.with(holder.itemView).load(dataList.get(position).getUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView albumid,id,title,url,thumbnailurl;
        ImageView imageView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            albumid=itemView.findViewById(R.id.albumid);
            id=itemView.findViewById(R.id.id);
            title=itemView.findViewById(R.id.title);
            url=itemView.findViewById(R.id.url);
            imageView=itemView.findViewById(R.id.imageview);
            thumbnailurl=itemView.findViewById(R.id.thumbnailurl);
        }
    }
}
