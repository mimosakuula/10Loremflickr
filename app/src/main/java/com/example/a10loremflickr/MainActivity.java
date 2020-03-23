package com.example.a10loremflickr;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUrl;
    Button buttonLoad;
    Button buttonAdd;
    Button buttonClear;
    NetworkImageView imageView;
    ImageLoader imageLoader;
    String tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.editTextUrl);
        buttonLoad = findViewById(R.id.buttonLoad);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        imageView = findViewById(R.id.imageView);
        buttonLoad.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
    }

    private void loadImage(){
        String url = "https://loremflickr.com/320/240/" + editTextUrl.getText().toString().trim();
        if(url.equals("https://loremflickr.com/320/240/")){
            Toast.makeText(this,"Please enter a tag",Toast.LENGTH_LONG).show();
            return;
        }

        imageLoader = CustomVolleyRequest.getInstance(this.getApplicationContext()).getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(imageView, 0, 0));
        imageView.setImageUrl(url, imageLoader);
    }

    private void clear(){
        tags = "";
    }

    private void addTag(){
        tags = editTextUrl.getText().toString().trim();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.buttonLoad:
                loadImage();
                break;

            case R.id.buttonAdd:
                addTag();
                break;

            case R.id.buttonClear:
                clear();
                break;

            default:
                break;
        }

    }
}