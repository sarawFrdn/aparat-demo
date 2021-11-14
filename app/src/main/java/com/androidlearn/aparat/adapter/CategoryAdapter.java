package com.androidlearn.aparat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearn.aparat.R;
import com.androidlearn.aparat.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    List<Category> categoryList;
    Context context;
    LayoutInflater inflater;


    public CategoryAdapter(Context context , List<Category> categories){
        categoryList = categories;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cat_row , null);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Category category = categoryList.get(position);

        holder.txt_title.setText(category.getTitle());

        Picasso.get().load(category.getIcon()).into(holder.img_category);

    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryViewHolder  extends RecyclerView.ViewHolder {

        AppCompatTextView txt_title;
        AppCompatImageView img_category;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_title = itemView.findViewById(R.id.txt_title);
            img_category = itemView.findViewById(R.id.img_category);
        }


    }


}
