package com.androidlearn.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.VideosAdapter;
import com.androidlearn.aparat.databinding.FragmentFavoriteBinding;
import com.androidlearn.aparat.db.AppDataBase;

public class favoriteFragment extends Fragment {


    FragmentFavoriteBinding binding;


    public favoriteFragment() {
        // Required empty public constructor
    }

    AppDataBase appDataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());
        appDataBase = AppDataBase.getInstance(getActivity());



        return binding.getRoot();
    }

    @Override
    public void onResume() {


        super.onResume();

        binding.recyclerFavorite.setAdapter(new VideosAdapter(getActivity(),appDataBase.idao().getAllVideos()));

        GridLayoutManager manager = new GridLayoutManager(getActivity(),2);
        binding.recyclerFavorite.setLayoutManager(manager);
    }


}