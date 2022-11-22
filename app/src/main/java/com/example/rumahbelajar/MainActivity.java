package com.example.rumahbelajar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListAdapter adapter;

    String API_KEY = "8ca437ca3839d80c969410d56d0abc03";
    String LANGUAGE = "en-US";
    String CATEGORY = "popular";
    int PAGE = 1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMovie);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CallRetrofit();
    }


    private void CallRetrofit() {
        Api ApiInterface = RetrofitClient.getClient().create(Api.class);

        Call<Kelas> caller = ApiInterface.getMovie(CATEGORY, API_KEY, LANGUAGE, PAGE);
        caller.enqueue(new Callback<Kelas>() {
            @Override
            public void onResponse(Call<Kelas> call, Response<Kelas> response) {
                List<Kelas> mList = response.body().getResults();
                adapter = new ListAdapter(MainActivity.this, mList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Kelas> call, Throwable t) {
                t.fillInStackTrace();
            }
        });


    }
}