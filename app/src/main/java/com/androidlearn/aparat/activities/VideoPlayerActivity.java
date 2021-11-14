package com.androidlearn.aparat.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.databinding.ActivityVideoPlayerBinding;
import com.androidlearn.aparat.db.AppDataBase;
import com.androidlearn.aparat.models.Video;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

public class VideoPlayerActivity extends AppCompatActivity {

    Bundle bundle;
    Video video;

    ActivityVideoPlayerBinding binding;
    SimpleExoPlayer player;

    AppDataBase appDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();
        video = bundle.getParcelable("video");
        appDataBase = AppDataBase.getInstance(getApplicationContext());

        binding.txtViews.setText(video.getView() + "");
        binding.txtTime.setText(video.getTime());
        binding.txtDescription.setText(video.getDescription());

        player = new SimpleExoPlayer.Builder(getApplicationContext()).build();


        MediaItem item = MediaItem.fromUri(Uri.parse(video.getLink()));
        player.setMediaItem(item);
        binding.videoView.setPlayer(player);

        player.play();

        binding.imgFavorite.setOnClickListener(v ->
        {
            int size = appDataBase.idao().searchVideos(video.getTitle()).size();
            if (size <= 0) {
                long result = appDataBase.idao().insert(video);
                binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
            } else {
                appDataBase.idao().deleteVideo(video.getId());
                binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();

        if (player != null) {
            player.stop();
        }
    }
}