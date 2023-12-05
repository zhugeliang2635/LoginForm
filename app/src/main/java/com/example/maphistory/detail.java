package com.example.maphistory;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        FloatingActionButton fab = findViewById(R.id.changeFont);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextView text = findViewById(R.id.infor_detail);
                text.setTextSize(TypedValue.COMPLEX_UNIT_PX,text.getTextSize() + 1);
            }

        });

    }
}