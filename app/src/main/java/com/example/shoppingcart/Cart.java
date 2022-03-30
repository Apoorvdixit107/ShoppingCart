package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class Cart extends AppCompatActivity {
TextView rateview;
RecyclerView recview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();
        rateview=findViewById(R.id.rateview);
        getroomdata();

    }

    private void getroomdata() {
        DataBase db = Room.databaseBuilder(getApplicationContext(),
                DataBase.class, "cart-database").allowMainThreadQueries().build();
        ProductDao productDao = db.ProductDao();
        recview=findViewById(R.id.recview);
recview.setLayoutManager(new LinearLayoutManager(this));

        List<Product> products=productDao.getallproduct();
MyAdapter adapter=new MyAdapter(products,rateview);
recview.setAdapter(adapter);
        int sum=0,i;
        for(i=0;i<products.size();i++){
            sum+=products.get(i).getPrice()*products.get(i).getQty();
            rateview.setText("Total Ammount: INR"+sum);}


    }
}