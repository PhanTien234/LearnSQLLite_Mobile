package com.example.mobile5lecture.dao;

// /dao/PersonDao.java
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mobile5lecture.models.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert
    long insertPerson(Person person);

    @Query("SELECT * FROM persons ORDER BY name")
    List<Person> getAllPersons();

    @Delete
    void DeletePerson (Person person);
}