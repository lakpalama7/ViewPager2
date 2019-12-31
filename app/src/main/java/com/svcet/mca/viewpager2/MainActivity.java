package com.svcet.mca.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private List<String> listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2=findViewById(R.id.viewpager2);

        listdata=new ArrayList<>();
        getListData();
        viewPager2.setAdapter(new ViewPager2Adapter(listdata,this,viewPager2));

    }

    private void getListData() {
        listdata.add("First Page");
        listdata.add("Second Page");
        listdata.add("Third Page");
        listdata.add("Fourth Page");
    }
}
