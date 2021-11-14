package com.androidlearn.aparat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.activities.VideoPlayerActivity;
import com.androidlearn.aparat.models.Video;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoVH> {

    Context context;
    List<Video> videoList;
    LayoutInflater inflater;

    public VideosAdapter(Context context , List<Video> videoList){
        this.context = context;
        this.videoList = videoList;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.video_row,null);
        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {

        Video video = videoList.get(position);
        holder.txt_title.setText(video.getTitle());

        Picasso.get().load(video.getIcon()).into(holder.img_video);
        holder.linear_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , VideoPlayerActivity.class);
                intent.putExtra("video",video);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    class VideoVH extends RecyclerView.ViewHolder{

        AppCompatImageView img_video;
        AppCompatTextView txt_title;
        LinearLayout linear_video;

        public VideoVH(@NonNull View itemView) {
            super(itemView);
            img_video = itemView.findViewById(R.id.img_video);
            txt_title = itemView.findViewById(R.id.txt_title);
            linear_video = itemView.findViewById(R.id.linear_video);
        }
    }

}
