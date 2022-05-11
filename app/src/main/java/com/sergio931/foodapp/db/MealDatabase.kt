package com.sergio931.foodapp.db

import android.content.Context
import androidx.room.*
import com.sergio931.foodapp.pojo.Meal

@Database(entities = [Meal::class],version = 1)
@TypeConverters(MealTypeConvertor::class)
abstract class MealDatabase:RoomDatabase(){
    abstract fun mealDao():MealDao
    companion object{
        @Volatile
        var  INSTANCE: MealDatabase? = null
        @Synchronized
        fun getInstance(context: Context): MealDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context,
                MealDatabase::class.java,
                "meal.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE as MealDatabase
        }
    }
}