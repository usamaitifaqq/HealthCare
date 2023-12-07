package com.lms.healthcareproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lms.healthcareproject.R;
import com.lms.healthcareproject.database.Database;
import com.lms.healthcareproject.databinding.ActivityLabTestDetailBinding;

public class LabTestDetailActivity extends AppCompatActivity {

    private ActivityLabTestDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLabTestDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.editTextTextMultiLine.setKeyListener(null);
        Intent intent=getIntent();
        binding.textViewLDPackageName.setText(intent.getStringExtra("text1"));
        binding.editTextTextMultiLine.setText(intent.getStringExtra("text2"));
//        binding.tvTotalCost.setText("Total Cost :"+intent.getStringExtra("Text3")+"/-");

        binding.tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
            }
        });

        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","".toString());
                String product=binding.textViewLDPackageName.getText().toString();
                float price=Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if (db.checkCart(username,product)==1){
                    Toast.makeText(LabTestDetailActivity.this, "Product already added", Toast.LENGTH_SHORT).show();
                }else {
                    db.addCart(username,product,price,"lab");
                    Toast.makeText(LabTestDetailActivity.this, "Record inserted into cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailActivity.this,LabTestActivity.class));
                }

            }
        });




    }
}