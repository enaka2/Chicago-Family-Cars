package com.example.project2;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setBackgroundColor(Color.parseColor("#222222"));

        imageView.setImageResource(intent.getIntExtra("image", 0));
        String website = intent.getStringExtra("website");

        imageView.setOnClickListener(view -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            startActivity(webIntent);
        });

        setContentView(imageView);
    }
}
