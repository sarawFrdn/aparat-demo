package com.androidlearn.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.adapter.CategoryAdapter;
import com.androidlearn.aparat.databinding.FragmentCategoryBinding;
import com.androidlearn.aparat.models.Category;
import com.androidlearn.aparat.models.IResponseListener;
import com.androidlearn.aparat.webservice.WebserviceCaller;

import java.util.List;


public class CategoryFragment extends Fragment {

     FragmentCategoryBinding binding;

     WebserviceCaller webserviceCaller;

    public CategoryFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        webserviceCaller = new WebserviceCaller();

        binding.progressbar.setVisibility(View.VISIBLE);

        webserviceCaller.getCategory(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {
                binding.progressbar.setVisibility(View.GONE);
                binding.recyclerCategories.setAdapter(new CategoryAdapter(getActivity(),(List<Category>) responseMessage));
                binding.recyclerCategories.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL , false));
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


        return binding.getRoot();

    }
}