package com.example.projectandroid.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.projectandroid.Activity.Adaptor.CategoryAdaptor;
import com.example.projectandroid.Activity.Adaptor.PopularAdaptor;
import com.example.projectandroid.Activity.Domain.CategoryDomain;
import com.example.projectandroid.Activity.Domain.FoodDomain;
import com.example.projectandroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recylerViewPopular();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.cartBtn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger","cat_2"));
        category.add(new CategoryDomain("Hotdog","cat_3"));
        category.add(new CategoryDomain("Drink","cat_4"));
        category.add(new CategoryDomain("Donut","cat_5"));

        adapter = new CategoryAdaptor(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private void recylerViewPopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain>FoodList = new ArrayList<>();
        FoodList.add(new FoodDomain("Bánh pizza Xúc Xích","pop_1","Thành phần gồm: Xúc xích tiêu, Phô mai mozzarella,Cam tươi, Tiêu đen xay, Sốt pizza", 8.23));
        FoodList.add(new FoodDomain("Hamburger Phô Mai","pop_2","Thành phần gồm: Thịt bò, Phô mai Gouda, Sốt đặc biệt, Xà lách, Cà chua", 9.00));
        FoodList.add(new FoodDomain("Pizza Rau Củ","pop_3"," Thành phần gồm: Dầu ô liu, Dầu thực vật, Cà chua bi, Cam tươi, Rau Quế",7.20));

        adapter2 = new PopularAdaptor(FoodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}