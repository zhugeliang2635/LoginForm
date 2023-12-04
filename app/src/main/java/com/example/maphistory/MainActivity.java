package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.maphistory.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.home){
                replaceFragment(new HomeFragment());
            }
            if(item.getItemId() == R.id.map){
                replaceFragment(new MapFragment());
            }
            if(item.getItemId() == R.id.infor){
//                replaceFragment(new InforFragment());
                Intent move = new Intent(MainActivity.this, ListActivity.class);
                startActivity(move);
            }
            if(item.getItemId() == R.id.person){
                replaceFragment(new ProfileFragment());
            }


            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}