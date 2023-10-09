package com.example.ram8;

import static com.example.ram8.MainActivity.country;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {

    //String api="2cbc507273d440c88433593ae1f8d851";
    String api="2cbc507273d440c88433593ae1f8d851";
    ArrayList<ModelClass> modelClassArrayList;
   // String country="in";
    Adapter adapter;
    private  String category ="health";
    private RecyclerView recyclerViewofhome;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.healthfragment,null);
        recyclerViewofhome=view.findViewById(R.id.recyclerviewhealth);
        modelClassArrayList= new ArrayList<>();
        recyclerViewofhome.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new Adapter(getContext(),modelClassArrayList);
        recyclerViewofhome.setAdapter(adapter);
        findnews();
        return  view;

    }

    private void findnews() {
        Apiutilities.getapiInterface().getCategerynews(country,category,100,api).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}
