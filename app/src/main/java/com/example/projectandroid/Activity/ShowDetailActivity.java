package com.example.projectandroid.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.projectandroid.Activity.Domain.FoodDomain;
import com.example.projectandroid.Helper.ManagementCart;
import com.example.projectandroid.R;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView addTocartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberoderTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private FoodDomain object;
    int numberOder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }
    private void getBundle(){
    object = (FoodDomain) getIntent().getSerializableExtra("object");

    int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberoderTxt.setText(String.valueOf(numberOder));
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOder = numberOder + 1;
                numberoderTxt.setText(String.valueOf(numberOder));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOder > 1){
                    numberOder = numberOder-1;
                }
                numberoderTxt.setText(String.valueOf(numberOder));
            }
        });
        addTocartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberIncart(numberOder);
                managementCart.insertFood(object);
            }
        });
    }
    private void initView(){
        addTocartBtn = findViewById(R.id.cartBtn);
        titleTxt = findViewById(R.id.txtviewtitle);
        feeTxt = findViewById(R.id.txtviewprice);
        descriptionTxt = findViewById(R.id.descriptiontxt);
        numberoderTxt = findViewById(R.id.numberOdertxt);
        plusBtn = findViewById(R.id.PlusBtn);
        minusBtn = findViewById(R.id.minusBtn);
        picFood = findViewById(R.id.picfood);
    }
}