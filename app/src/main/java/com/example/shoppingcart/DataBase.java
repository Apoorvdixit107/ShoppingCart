package com.example.shoppingcart;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities={Product.class},version = 1,exportSchema = true)
abstract class DataBase extends RoomDatabase {
public abstract ProductDao ProductDao();
}
