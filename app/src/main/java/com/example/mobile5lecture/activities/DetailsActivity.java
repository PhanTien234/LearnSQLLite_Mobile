package com.example.mobile5lecture.activities;

// /activities/DetailsActivity.java
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mobile5lecture.R;
import com.example.mobile5lecture.database.AppDatabase;
import com.example.mobile5lecture.models.Person;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "sqlite_example_db")
                .allowMainThreadQueries() // For simplicity, don't use this in production
                .build();

        TextView detailsTxt = findViewById(R.id.detailsText);

        List<Person> persons = appDatabase.personDao().getAllPersons();

        StringBuilder detailsBuilder = new StringBuilder();
        for (Person person : persons) {
            detailsBuilder.append(person.person_id).append(" ")
                    .append(person.name).append(" ")
                    .append(person.dob).append(" ")
                    .append(person.email).append("\n");
        }

        detailsTxt.setText(detailsBuilder.toString());
    }
}