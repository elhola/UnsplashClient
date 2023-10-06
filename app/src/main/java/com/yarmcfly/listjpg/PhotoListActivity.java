// com.yarmcfly.listjpg/PhotoListActivity java class -->
package com.yarmcfly.listjpg;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhotoListActivity extends AppCompatActivity {
    private GridView gridView;
    private List<UnsplashPhoto> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);

        gridView = findViewById(R.id.grid_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PhotoApi api = retrofit.create(PhotoApi.class);
        Call<List<UnsplashPhoto>> call = api.getPhotos("ehnqj5GVLZhw61LlAyqGydSwfA7SVbkIpACXdWHckig");

        call.enqueue(new Callback<List<UnsplashPhoto>>() {
            @Override
            public void onResponse(@NonNull Call<List<UnsplashPhoto>> call, @NonNull Response<List<UnsplashPhoto>> response) {
                if (response.isSuccessful()) {
                    photos = response.body();
                    PhotoAdapter adapter = new PhotoAdapter(PhotoListActivity.this, photos);
                    gridView.setAdapter(adapter);

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(PhotoListActivity.this, PhotoDetailActivity.class);
                            intent.putExtra("photo", photos.get(position));
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(PhotoListActivity.this, "Ошибка загрузки фото", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<UnsplashPhoto>> call, @NonNull Throwable t) {
                Toast.makeText(PhotoListActivity.this, "Ошибка загрузки фото: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}