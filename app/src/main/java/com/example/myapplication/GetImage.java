package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class GetImage extends AppCompatActivity {

    private MaterialButton button_cancel, button_ok;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_image);
        imageView = findViewById(R.id.preview_image);

        String fileDir = getIntent().getStringExtra("filedir");

//        Toast.makeText(this, "received dir: "+ fileDir, Toast.LENGTH_SHORT).show();
        Bitmap bitmap = BitmapFactory.decodeFile(fileDir);
        imageView.setImageBitmap(bitmap);

        button_cancel = findViewById(R.id.materialButton_retry);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GetImage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
