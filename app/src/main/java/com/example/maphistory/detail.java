package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class detail extends AppCompatActivity {
    private String name;
    private TextView textView;
    private ImageView imageView;
    private TextView eventInfor;

    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getIntent().getExtras();
        if (args != null) {
            name = args.getString("event");
        }

//        ImageSlider imageSlider = findViewById(R.id.imageSlider);
//        ArrayList<SlideModel> slideModels = new ArrayList<>();
//
//        slideModels.add(new SlideModel(R.drawable.home_pic, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.img_8, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.img_12, ScaleTypes.FIT));
//        slideModels.add(new SlideModel(R.drawable.img_13, ScaleTypes.FIT));
//
//        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        setContentView(R.layout.activity_detail);
        FloatingActionButton fab = findViewById(R.id.changeFont);
        imageView = findViewById(R.id.eventImage);
        textView = findViewById(R.id.infor_detail);
        eventInfor = findViewById(R.id.event_infor);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);

        Button quizButotn = findViewById(R.id.quizButton);

        quizButotn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                intent.putExtra("event", name);
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView text = findViewById(R.id.infor_detail);
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX,text.getTextSize() + 1);
            }

        });

        switch (name) {
            case "bachdang":
                textView.setText(R.string.bachdang_des);
                imageView.setImageResource(R.drawable.bachdang1);
                String name = getResources().getString(R.string.bachdang_name);
                String time = getResources().getString(R.string.bachdang_time);
                eventInfor.setText(name + "\n" + time);
                collapsingToolbarLayout.setTitle(name);
                break;
        }


    }
}