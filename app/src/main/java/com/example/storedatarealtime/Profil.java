package com.example.storedatarealtime;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Profil extends AppCompatActivity {
    ImageView backButton;
    ImageView profileImage;
    TextView profileTitle, profileBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        backButton = findViewById(R.id.backButton);
        profileImage = findViewById(R.id.bookedCarImage);
        profileTitle = findViewById(R.id.bookedCarTitle);
        profileBrand = findViewById(R.id.bookedCarBrand);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String image = extras.getString("Image2");
            String title = extras.getString("Title2");
            String brand = extras.getString("Brand2");


            Glide.with(this).load(image).into(profileImage);
            profileTitle.setText(title);
            profileBrand.setText(brand);
        }
    }
}
