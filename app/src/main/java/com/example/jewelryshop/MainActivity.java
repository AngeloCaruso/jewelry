package com.example.jewelryshop;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private String Opc[];
    private android.content.res.Resources Resources;
    private Intent In;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.Options);
        Resources = this.getResources();
        Opc = Resources.getStringArray(R.array.Menu);
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Opc);
        lv.setAdapter(Adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        In = new Intent(MainActivity.this, CreateJewel.class);
                        startActivity(In);
                        break;
                    case 1:
                        In = new Intent(MainActivity.this, OrderList.class);
                        startActivity(In);
                        break;
                }
            }
        });


    }




}
