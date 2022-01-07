package com.example.kunal.takehometest;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.kunal.takehometest.databinding.PurchasesActivityBinding;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PurchasesActivity extends AppCompatActivity {

    private PurchasesActivityBinding purchasesActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        purchasesActivityBinding = DataBindingUtil.setContentView(PurchasesActivity.this, R.layout.activity_purchases);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        makeApiCallToGetPurchases();

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void makeApiCallToGetPurchases() {

        NetworkAPI networkAPI = NetworkModule.getRetrofit().create(NetworkAPI.class);

        networkAPI.getAllPurchases().enqueue(new Callback<List<Purchases>>() {
            @Override
            public void onResponse(Call<List<Purchases>> call, Response<List<Purchases>> response) {

                if (response.isSuccessful())
                {
                    if (response.body() != null)
                    {
                        List<Purchases> purchasesList = response.body();
                        sendPurchasesListToAdapter(purchasesList);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Purchases>> call, Throwable t) {
                Toast.makeText(PurchasesActivity.this, "Call Failure : " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void sendPurchasesListToAdapter(List<Purchases> purchasesList) {
        purchasesActivityBinding.rvPurchasesList.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapterPurchasesData recyclerViewAdapterPurchasesData = new RecyclerViewAdapterPurchasesData(purchasesList, this);
        purchasesActivityBinding.rvPurchasesList.setAdapter(recyclerViewAdapterPurchasesData);
    }

}