package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class bmiactivity extends AppCompatActivity {



    TextView mbmidisplay,mbmicategory,mgender;
    Button mgotomain;
    Intent intent;

    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout mbackground;

    @SuppressLint({"ResourceAsColor", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        Objects.requireNonNull(getSupportActionBar()).setElevation(0);
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        ///   ColorDrawable colorDrawable2=new ColorDrawable(Color.parseColor("#1E1D1D"));
        //      getSupportActionBar().setBackgroundDrawable(colorDrawable);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");


        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategorydispaly);
        mgotomain=findViewById(R.id.gotomain);

        mimageview=findViewById(R.id.imageview);

        //   mheightdisplay=findViewById(R.id.heightdisplay);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");


        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);


        mbmi=Float.toString(intbmi);
        System.out.println(mbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
            //   mbackground.setBackgroundColor(Color.GRAY);
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.crosss);
            //  mimageview.setBackground(colorDrawable2);

        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //   mimageview.setBackground(colorDrawable2);

        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //   mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi<24.9 && intbmi>18.5 )
        {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.ok);
        }
        else if(intbmi <29.9 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(R.color.halfwarn);
            mimageview.setImageResource(R.drawable.warning);
            //  mimageview.setBackground(colorDrawable2);
        }
        else
        {
            mbmicategory.setText("Obese Class II");
            mbackground.setBackgroundColor(R.color.warn);
            mimageview.setImageResource(R.drawable.crosss);
            //  mimageview.setBackground(colorDrawable2);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


        mgotomain.setOnClickListener(v -> {
            Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent1);
        });

    }
}