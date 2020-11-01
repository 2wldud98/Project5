package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentUris;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button searchButton = (Button)findViewById(R.id.searchButton);
        final Button starButton = (Button)findViewById(R.id.starButton);

        final LinearLayout main = (LinearLayout)findViewById(R.id.main);

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                main.setVisibility(View.GONE);
                searchButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                starButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new SearchFragment());
                fragmentTransaction.commit();
            }
        });

        starButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                main.setVisibility(View.GONE);
                starButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                searchButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new StarFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private long lastTimeBackPressed;
    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()-lastTimeBackPressed<1500)
        {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.",Toast.LENGTH_SHORT);
        lastTimeBackPressed = System.currentTimeMillis();
    }
}
