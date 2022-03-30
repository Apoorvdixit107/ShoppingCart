package com.example.shoppingcart;

import androidx.room.Dao;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
@Insert
    void insertrecord(Product product);
@Query("SELECT EXISTS(SELECT * FROM product WHERE pid=:productid)")
    Boolean is_exists(int productid);
@Query("SELECT * FROM product")
    List<Product> getallproduct();
@Query("DELETE FROM product WHERE pid=:id")
    void deletebyid(int id);
}
