package com.example.maphistory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maphistory.databinding.ActivityListBinding;
import com.example.maphistory.databinding.ActivityMainBinding;
import com.example.maphistory.databinding.FragmentInforBinding;
import com.example.maphistory.databinding.ListItemBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imgageId = {R.drawable.img_7, R.drawable.img_7,R.drawable.img_7,R.drawable.img_7,R.drawable.img_7, R.drawable.img_7,
                R.drawable.img_7,R.drawable.img_7,R.drawable.img_7,R.drawable.img_7};
        String[] name = {"Trận Bạch Đằng", "Trận Bạch Đằng", "Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng",
                "Trận Bạch Đằng", "Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng","Trận Bạch Đằng"};
        String[] time = {"Năm 938", "Năm 938","Năm 938","Năm 938","Năm 938","Năm 938","Năm 938",
                "Năm 938","Năm 938","Năm 938",};

        ArrayList<ListData> eventList = new ArrayList<>();

        for (int i = 0; i < imgageId.length; i++) {
            ListData listData = new ListData(name[i], time[i], imgageId[i]);
            eventList.add(listData);
        }
        ListAdapter listAdapter = new ListAdapter(ListActivity.this, eventList);



        binding.listview2.setAdapter(listAdapter);
        binding.listview2.setClickable(true);
        binding.listview2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Log.d("TAG",Integer.toString(position) + " - " + Long.toString(id));
                Intent intent = new Intent(getApplicationContext(), detail.class);
                intent.putExtra("event", "bachdang");
                startActivity(intent);
            }
        });

    }
}
