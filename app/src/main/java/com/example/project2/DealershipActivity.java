package com.example.project2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DealershipActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dealership_listview);

        String dealerName1 = getIntent().getStringExtra("dealerName1");
        String dealerAddress1 = getIntent().getStringExtra("dealerAddress1");
        String dealerName2 = getIntent().getStringExtra("dealerName2");
        String dealerAddress2 = getIntent().getStringExtra("dealerAddress2");

        List<String> dealershipList = new ArrayList<>();
        dealershipList.add(dealerName1 + "\n" + dealerAddress1);
        dealershipList.add(dealerName2 + "\n" + dealerAddress2);

        ListView listView = findViewById(R.id.dealership_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, dealershipList);
        listView.setAdapter(adapter);
    }
}