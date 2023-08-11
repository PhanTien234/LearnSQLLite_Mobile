package com.example.mobile5lecture.activities;

// /activities/DetailsActivity.java
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mobile5lecture.R;
import com.example.mobile5lecture.adapters.ContactAdapter;
import com.example.mobile5lecture.database.AppDatabase;
import com.example.mobile5lecture.models.Person;

import java.util.List;

// DetailsActivity.java
public class DetailsActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "sqlite_example_db")
                .allowMainThreadQueries() // For simplicity, don't use this in production
                .build();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Person> persons = appDatabase.personDao().getAllPersons();

        adapter = new ContactAdapter(persons);
        recyclerView.setAdapter(adapter);
    }
}