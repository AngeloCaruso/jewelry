package com.example.jewelryshop;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Jewel> jewels;
    private Intent In;
    private TextView no_orders;
    private ArrayList<String> order_detail;
    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orders_list);
        resources = this.getResources();

        lv = (ListView) findViewById(R.id.orders);
        no_orders = (TextView) findViewById(R.id.no_orders);
        jewels = ShoppingCart.showOrders();
        order_detail = new ArrayList<String>();

        no_orders.setVisibility(View.VISIBLE);
        lv.setVisibility(View.INVISIBLE);


        if (jewels.size() > 0) {
            String signedString = "", typeString = "", materialString = "", oreString = "";
            lv.setVisibility(View.VISIBLE);
            no_orders.setVisibility(View.INVISIBLE);

            for (int i = 0; i < jewels.size(); i++) {
                if(jewels.get(i).isSigned()){
                    signedString = resources.getString(R.string.jewel_signed);
                }else{
                    signedString = "";
                }

                if(jewels.get(i).getType() == 1){
                    typeString = resources.getString(R.string.Type1);
                }else{
                    typeString = resources.getString(R.string.Type2);
                }

                switch (jewels.get(i).getMaterial()){
                    case 1:
                        materialString = resources.getString(R.string.material1);
                        break;
                    case 2:
                        materialString = resources.getString(R.string.material2);
                        break;
                    case 3:
                        materialString = resources.getString(R.string.material3);
                        break;
                }

                switch (jewels.get(i).getOre()){
                    case 1:
                        oreString = resources.getString(R.string.ore1);
                        break;
                    case 2:
                        oreString = resources.getString(R.string.ore2);
                        break;
                    case 3:
                        oreString = resources.getString(R.string.ore3);
                        break;
                }

                order_detail.add("#" + i + "\t" + signedString + "\n" + typeString + "\n" + materialString + " + " + oreString + "\n" + jewels.get(i).getTotalPrice());
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, order_detail);
        lv.setAdapter(adapter);

    }
}
