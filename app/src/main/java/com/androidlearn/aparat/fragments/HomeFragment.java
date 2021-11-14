package com.androidlearn.aparat.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.NewsAdapter;
import com.androidlearn.aparat.adapter.VideosAdapter;
import com.androidlearn.aparat.models.IResponseListener;
import com.androidlearn.aparat.models.News;
import com.androidlearn.aparat.models.Video;
import com.androidlearn.aparat.webservice.WebserviceCaller;

import java.util.List;


public class HomeFragment extends Fragment {

  WebserviceCaller webserviceCaller;
  ProgressBar progressBar_new;
  ProgressBar progressBar_best;
  ProgressBar progressBar_special;

  ViewPager pager;

  RecyclerView recycler_new_videos;
    RecyclerView recycler_best_videos;
     RecyclerView  recycler_special_videos;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recycler_new_videos = view.findViewById(R.id.recycler_new_videos);
        recycler_best_videos = view.findViewById(R.id.recycler_best_videos);
        recycler_special_videos = view.findViewById(R.id.recycler_special_videos);
        pager = view.findViewById(R.id.pager);



        webserviceCaller = new WebserviceCaller();

        progressBar_new = view.findViewById(R.id.progressBar_new);
        progressBar_best = view.findViewById(R.id.progressBar_best);
        progressBar_special = view.findViewById(R.id.progressBar_special);

        progressBar_new.setVisibility(View.VISIBLE);
        progressBar_best.setVisibility(View.VISIBLE);
        progressBar_special.setVisibility(View.VISIBLE);

        webserviceCaller.getNewVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("","");
                progressBar_new.setVisibility(View.GONE);
                progressBar_best.setVisibility(View.GONE);
                progressBar_special.setVisibility(View.GONE);

                recycler_new_videos.setAdapter(new VideosAdapter(getActivity(),(List<Video>)responseMessage));
                recycler_new_videos.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
                recycler_new_videos.setHasFixedSize(true);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

                Log.e("","");
                progressBar_new.setVisibility(View.GONE);


            }
        });

        webserviceCaller.getBestVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("","");
                recycler_best_videos.setAdapter(new VideosAdapter(getActivity(),(List<Video>)responseMessage));
                recycler_best_videos.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
                recycler_best_videos.setHasFixedSize(true);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

                progressBar_best.setVisibility(View.GONE);
                Log.e("","");
            }
        });

        webserviceCaller.getSpecialVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("","");
                recycler_special_videos.setAdapter(new VideosAdapter(getActivity(),(List<Video>)responseMessage));
                recycler_special_videos.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
                recycler_special_videos.setHasFixedSize(true);
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("","");
                progressBar_special.setVisibility(View.GONE);
            }
        });


        webserviceCaller.getNews(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                pager.setAdapter(new NewsAdapter(getActivity(), (List<News>) responseMessage));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        return view ;


}  }