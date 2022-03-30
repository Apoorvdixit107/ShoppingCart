package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button b1,b2;
TextView lbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextTextPersonName);
        e2=findViewById(R.id.editTextTextPersonName2);
        e3=findViewById(R.id.editTextTextPersonName3);
        e4=findViewById(R.id.editTextTextPersonName4);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        lbl=findViewById(R.id.lbl);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                DataBase db = Room.databaseBuilder(getApplicationContext(),
                        DataBase.class, "cart-database").allowMainThreadQueries().build();
                ProductDao productDao = db.ProductDao();
                Boolean check=productDao.is_exists(Integer.parseInt(e1.getText().toString()));
                if(!check){
                    int pid=Integer.parseInt(e1.getText().toString());
                    String pname=e2.getText().toString().trim();
                    int price=Integer.parseInt(e3.getText().toString());
                    int qty=Integer.parseInt(e4.getText().toString());
                    productDao.insertrecord(new Product(pid,pname,price,qty));
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    lbl.setText("Data Inserted Successfully");

                }
                else{
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");
                    lbl.setText("Data Already in Cart");
                }


            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Cart.class));
            }
        });


    }
}