package com.androidlearn.aparat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.androidlearn.aparat.activities.SettingActivity;
import com.androidlearn.aparat.adapter.TabsAdapter;
import com.androidlearn.aparat.databinding.ActivityMainBinding;
import com.androidlearn.aparat.fragments.CategoryFragment;
import com.androidlearn.aparat.fragments.HomeFragment;
import com.androidlearn.aparat.fragments.favoriteFragment;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new favoriteFragment());

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,binding.drawer,binding.toolbar,R.string.open,R.string.close);
        toggle.syncState();

        binding.navMenu.setNavigationItemSelectedListener(this::onNavigationItemSelected);
        binding.pager.setAdapter(new TabsAdapter(MainActivity.this, fragments));
        binding.buttomTabs.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.item_home:

                        binding.pager.setCurrentItem(0);
                        binding.buttomTabs.getMenu().findItem(R.id.item_home).setChecked(true);

                        break;

                    case R.id.item_category:

                        binding.pager.setCurrentItem(1);
                        binding.buttomTabs.getMenu().findItem(R.id.item_category).setChecked(true);

                        break;

                    case R.id.item_favorite:

                        binding.pager.setCurrentItem(2);
                        binding.buttomTabs.getMenu().findItem(R.id.item_favorite).setChecked(true);

                        break;

                }

                return false;
            }
        });

        binding.pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:


                        binding.buttomTabs.getMenu().findItem(R.id.item_home).setChecked(true);

                        break;

                    case 1:


                        binding.buttomTabs.getMenu().findItem(R.id.item_category).setChecked(true);

                        break;

                    case 2:


                        binding.buttomTabs.getMenu().findItem(R.id.item_favorite).setChecked(true);

                        break;

                }

            }


        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.setting_item:
                Intent intent = new Intent(getApplicationContext() , SettingActivity.class);
                startActivity(intent);

                break;
        }



        return false;
    }
}