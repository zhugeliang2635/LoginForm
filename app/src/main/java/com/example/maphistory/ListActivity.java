package com.example.maphistory;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.maphistory.databinding.ActivityListBinding;
import com.example.maphistory.databinding.ActivityMainBinding;
import com.example.maphistory.databinding.FragmentInforBinding;
import com.example.maphistory.databinding.ListItemBinding;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imgageId = {R.drawable.img_7, R.drawable.img_1,R.drawable.img_7,R.drawable.img_7,R.drawable.img_5, R.drawable.img_7,
                R.drawable.img_7,R.drawable.img_4,R.drawable.img_7,R.drawable.img_6};
        String[] name = {"Trận Bạch Đằng", "Trận Như Nguyệt", "Đông Bộ Đầu","Bạch Đằng","Trận Chi Lăng","Trận Rạch Gầm",
                "Trận Ngọc Hồi", "Điện Biên Phủ","Điện Biên Phủ trên không","Chiến dịch Hồ Chí Minh"};
        String[] time = {"Năm 938", "Năm 1077","Năm 1258","Năm 1288","Năm 1427","Năm 1785","Năm 1789",
                "Năm 1954","Năm 1972","Năm 1975"};

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

            }
        });

    }
}
