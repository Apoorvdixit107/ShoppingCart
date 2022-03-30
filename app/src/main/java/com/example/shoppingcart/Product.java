package com.example.shoppingcart;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="product")
public class Product {
@PrimaryKey(autoGenerate = true)
    int pid;
@ColumnInfo(name="pname")
String pname;
@ColumnInfo(name="price")
int price;
@ColumnInfo(name="qty")
int qty;

    public Product(int pid, String pname, int price, int qty) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.qty = qty;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
