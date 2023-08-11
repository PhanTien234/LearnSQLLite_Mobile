package com.example.mobile5lecture.database;

// /database/AppDatabase.java
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mobile5lecture.dao.PersonDao;
import com.example.mobile5lecture.models.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
}