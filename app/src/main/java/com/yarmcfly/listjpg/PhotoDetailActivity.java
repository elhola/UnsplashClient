// com.yarmcfly.listjpg/PhotoAdapter java class -->
package com.yarmcfly.listjpg;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class PhotoDetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView altDescriptionTextView;
    private TextView firstNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        imageView = findViewById(R.id.photo_detail_image);

        UnsplashPhoto photo = getIntent().getParcelableExtra("photo");

        if (photo != null) {
            Picasso.get().load(photo.getUrls().getRegular()).into(imageView);
        }
    }

}