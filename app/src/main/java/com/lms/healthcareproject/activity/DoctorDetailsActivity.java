package com.lms.healthcareproject.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import com.lms.healthcareproject.R;
import com.lms.healthcareproject.databinding.ActivityDoctorDetailsBinding;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1={
            {"Doctor Name : M.Abdul Wahab", "Hospital Address : Rawalpindi", "Exp : 5yrs", "Mobile No:98989898", "600" },
            {"Doctor Name : M.Usama Raja", "Hospital Address : Islamabad", "Exp : 10yrs", "Mobile No:78612346", "900" },
            {"Doctor Name : Ramazan Fazil", "Hospital Address : Peshawar", "Exp : 7yrs", "Mobile No:97899898", "500" },
            {"Doctor Name : Sharjeel Wahab", "Hospital Address : Islamabad", "Exp : 3yrs", "Mobile No:98989898", "800" },
            {"Doctor Name : Saleem Ahmad", "Hospital Address : Karachi", "Exp : 12yrs", "Mobile No:90908765", "800" },
    };


    private String[][] doctor_details2={
            {"Doctor Name : M.Abdul Wahab", "Hospital Address : Rawalpindi", "Exp : 5yrs", "Mobile No:98989898", "600" },
            {"Doctor Name : M.Usama Raja", "Hospital Address : Islamabad", "Exp : 10yrs", "Mobile No:78612346", "900" },
            {"Doctor Name : Ramazan Fazil", "Hospital Address : Peshawar", "Exp : 7yrs", "Mobile No:97899898", "500" },
            {"Doctor Name : Sharjeel Wahab", "Hospital Address : Islamabad", "Exp : 3yrs", "Mobile No:98989898", "800" },
            {"Doctor Name : Saleem Ahmad", "Hospital Address : Karachi", "Exp : 12yrs", "Mobile No:90908765", "800" },
    };

    private String[][] doctor_details3={
            {"Doctor Name : M.Abdul Wahab", "Hospital Address : Rawalpindi", "Exp : 5yrs", "Mobile No:98989898", "600" },
            {"Doctor Name : M.Usama Raja", "Hospital Address : Islamabad", "Exp : 10yrs", "Mobile No:78612346", "900" },
            {"Doctor Name : Ramazan Fazil", "Hospital Address : Peshawar", "Exp : 7yrs", "Mobile No:97899898", "500" },
            {"Doctor Name : Sharjeel Wahab", "Hospital Address : Islamabad", "Exp : 3yrs", "Mobile No:98989898", "800" },
            {"Doctor Name : Saleem Ahmad", "Hospital Address : Karachi", "Exp : 12yrs", "Mobile No:90908765", "800" },
    };

    private String[][] doctor_details4={
            {"Doctor Name : M.Abdul Wahab", "Hospital Address : Rawalpindi", "Exp : 5yrs", "Mobile No:98989898", "600" },
            {"Doctor Name : M.Usama Raja", "Hospital Address : Islamabad", "Exp : 10yrs", "Mobile No:78612346", "900" },
            {"Doctor Name : Ramazan Fazil", "Hospital Address : Peshawar", "Exp : 7yrs", "Mobile No:97899898", "500" },
            {"Doctor Name : Sharjeel Wahab", "Hospital Address : Islamabad", "Exp : 3yrs", "Mobile No:98989898", "800" },
            {"Doctor Name : Saleem Ahmad", "Hospital Address : Karachi", "Exp : 12yrs", "Mobile No:90908765", "800" },
    };

    private String[][] doctor_details5={
            {"Doctor Name : M.Abdul Wahab", "Hospital Address : Rawalpindi", "Exp : 5yrs", "Mobile No:98989898", "600" },
            {"Doctor Name : M.Usama Raja", "Hospital Address : Islamabad", "Exp : 10yrs", "Mobile No:78612346", "900" },
            {"Doctor Name : Ramazan Fazil", "Hospital Address : Peshawar", "Exp : 7yrs", "Mobile No:97899898", "500" },
            {"Doctor Name : Sharjeel Wahab", "Hospital Address : Islamabad", "Exp : 3yrs", "Mobile No:98989898", "800" },
            {"Doctor Name : Saleem Ahmad", "Hospital Address : Karachi", "Exp : 12yrs", "Mobile No:90908765", "800" },
    };
    private ActivityDoctorDetailsBinding binding;

    String [][] doctor_detail= {};
    ArrayList list;

    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDoctorDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent it =getIntent();
        String title=it.getStringExtra("title");
        binding.textViewCartPackageName.setText(title);

        if (title.compareTo("Family Physicians")==0)
            doctor_detail=doctor_details1;
        else
            if (title.compareTo("Dietician")==0)
                doctor_detail=doctor_details2;
            else
            if (title.compareTo("Family Physicians")==0)
                doctor_detail=doctor_details3;
            else
            if (title.compareTo("Surgeon")==0)
                doctor_detail=doctor_details4;
            else
                doctor_detail=doctor_details5;



        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list=new ArrayList();

        for (int i=0;i<doctor_detail.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_detail[i][0]);
            item.put("line2",doctor_detail[i][1]);
            item.put("line3",doctor_detail[i][2]);
            item.put("line4",doctor_detail[i][3]);
            item.put("line5","Fee "+doctor_detail[i][4]+"/-");
            list.add(item);


        }
        SimpleAdapter sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"}
                ,new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        binding.listviewDD.setAdapter(sa);

        binding.listviewDD.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detail[i][0]);
                it.putExtra("text3",doctor_detail[i][1]);
                it.putExtra("text4",doctor_detail[i][3]);
                it.putExtra("text5",doctor_detail[i][4]);
                startActivity(it);

            }
        });
    }
}