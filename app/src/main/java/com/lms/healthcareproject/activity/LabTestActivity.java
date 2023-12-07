package com.lms.healthcareproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.lms.healthcareproject.R;
import com.lms.healthcareproject.databinding.ActivityLabTestBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private ActivityLabTestBinding binding;

    private String [][] packages={
            {"Package 1 : Full Body Checkup", "", "", "", "999"},
            {"Package 2 : Blood Glucose Fasting", "", "", "", "299"},
            {"Package 3 : COVID-19 Antibody - IgG", "", "", "", "899"},
            {"Package 4 : Thyroid Check", "", "", "", "499"},
            {"Package 5 : Immunity Check", "", "", "", "699"},
    };

    private String [] package_details ={

            "Blood glucose Fasting\n"+"Complete Hemogram\n"+"HbA1c\n"+" Iron Studies\n"+"Kidney Function Test\n"+
                    "LHD Lactate Dehydrogenase,serum\n"+
                    "Lipid Profile\n"+"Liver Function Test",
            "Blood Glucose Fasting",
            "Covid-19 Antibody - IgG",
            "Thyroid Profile-Total(T3, T4 & TSH Ultra-sensititve)",
            "Complete Hemogram\n" +
                    "CRP (C Reactive Protein) Quantitative, Serum\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n"+
                    "Vitamen D Total-25 Hydroxy\n"+
                    "Liver Function Test\n" +
                    "Lipid Profile"
    };

    HashMap<String,String> item;
    ArrayList list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      binding=ActivityLabTestBinding.inflate(getLayoutInflater());
      setContentView(binding.getRoot());

      binding.btnBack.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
          }
      });

      list=new ArrayList();
      for (int i=0;i<packages.length;i++){
          item=new HashMap<String,String>();
          item.put("line1",packages[i][0]);
          item.put("line2",packages[i][1]);
          item.put("line3",packages[i][2]);
          item.put("line4",packages[i][3]);
          item.put("line5","Total Cost:"+packages[i][4]+"/-");
          list.add(item);
      }

        SimpleAdapter sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"}
                ,new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        binding.listviewDD.setAdapter(sa);

        binding.listviewDD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(LabTestActivity.this, LabTestDetailActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

        binding.btnAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}