package com.example.jewelryshop;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CreateJewel extends AppCompatActivity {
    private Spinner spType, spMaterial, spOre;
    private CheckBox chSigned;
    private String[] optType, optMaterials, optOres;
    private ArrayAdapter<String> typeAdapter;
    private ArrayAdapter<String> matAdapter;
    private ArrayAdapter<String> oreAdapter;
    private Jewel newJewel;
    private TextView price;

    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_menu);

        spType = (Spinner)findViewById(R.id.spinnerType);
        spMaterial = (Spinner)findViewById(R.id.spinnerMaterial);
        spOre = (Spinner)findViewById(R.id.spinnerOre);
        chSigned = (CheckBox)findViewById(R.id.marked);
        price = (TextView)findViewById(R.id.price);
        resources = this.getResources();

        optType = resources.getStringArray(R.array.type);
        optMaterials = resources.getStringArray(R.array.materials);
        optOres = resources.getStringArray(R.array.ores);

        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optType);
        matAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optMaterials);
        oreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optOres);

        spType.setAdapter(typeAdapter);
        spMaterial.setAdapter(matAdapter);
        spOre.setAdapter(oreAdapter);

    }
    public void makeOrder(View view){
        int selectedType = spType.getSelectedItemPosition();
        int selectedMaterial = spMaterial.getSelectedItemPosition();
        int selectedOre = spOre.getSelectedItemPosition();
        boolean selectedCheckBox = chSigned.isChecked();

        if (selectedType == 0 || selectedMaterial == 0 || selectedOre == 0){
            Toast.makeText(this,R.string.field_err, Toast.LENGTH_LONG).show();
        }else{
            newJewel = new Jewel(selectedCheckBox, selectedType, selectedMaterial, selectedOre);
            newJewel.saveOrder();
            price.setText("$"+newJewel.getTotalPrice());
            Toast.makeText(this,R.string.completed, Toast.LENGTH_LONG).show();
        }
    }
}
