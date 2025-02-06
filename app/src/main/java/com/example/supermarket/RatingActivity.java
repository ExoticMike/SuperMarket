package com.example.supermarket;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RatingActivity extends AppCompatActivity {


    private TextView displayAverage;
    private RatingBar rating1, rating2, rating3, rating4, rating5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        updateAverageRating();
        setRatingChangeListener();
    }

    private void initViews() {
        displayAverage = findViewById(R.id.total);
        rating1 = findViewById(R.id.ratingBar);
        rating2 = findViewById(R.id.ratingBar2);
        rating3 = findViewById(R.id.ratingBar3);
        rating4 = findViewById(R.id.ratingBar4);
        rating5 = findViewById(R.id.ratingBar5);
    }

    private void updateAverageRating() {
        float average = (rating1.getRating() + rating2.getRating() + rating3.getRating() +
                rating4.getRating() + rating5.getRating()) / 5;

        displayAverage.setText(String.format("%.1f", average));
    }

    private void setRatingChangeListener() {
        RatingBar.OnRatingBarChangeListener listener = (ratingBar, rating, fromUser) -> updateAverageRating();

        rating1.setOnRatingBarChangeListener(listener);
        rating2.setOnRatingBarChangeListener(listener);
        rating3.setOnRatingBarChangeListener(listener);
        rating4.setOnRatingBarChangeListener(listener);
        rating5.setOnRatingBarChangeListener(listener);
    }
}