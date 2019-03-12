package com.jhonisaac.daggerretrofitwheatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import javax.inject.Inject;

import API.ApiClient;
import Model.Meteorology;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String TEMPERATURE = "temperature";

    public static final String TEMPERATURE_INT ="temperature_int";

    private TextView mTextView;

    @Inject
    Retrofit retrofit;

    @Inject
    TimeAdapter adapter2;

    private RecyclerView temperatureList;

    private TimeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.text);

        temperatureList = findViewById(R.id.rvLista);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        temperatureList.setLayoutManager(linearLayoutManager);

        adapter = new TimeAdapter();
        temperatureList.setAdapter(adapter2);

        //((BaseApplication)getApplication())
        //        .getApplicationContextComponent().inject(this);
        //((BaseApplication)getApplication()).plusSharedPreferencesSubComponent().inject(this);

        ((BaseApplication)getApplication()).plusRetrofitComponent().inject(this);
        temperatureList.setAdapter(adapter2);

        ApiClient apiClient = retrofit.create(ApiClient.class);
        Call<Meteorology> call = apiClient.getTime();
        call.enqueue(new Callback<Meteorology>() {
            @Override
            public void onResponse(Call<Meteorology> call, Response<Meteorology> response) {
                Log.d("TAG1", response.body().getList().get(0).getDt());
                adapter2.setData(response.body().getList());
            }

            @Override
            public void onFailure(Call<Meteorology> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });

    }
}
