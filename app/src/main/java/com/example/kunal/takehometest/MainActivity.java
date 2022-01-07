package com.example.kunal.takehometest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.example.kunal.takehometest.databinding.MainActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding mainActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainActivityBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        makeApiCallToGetUserProfile();

        mainActivityBinding.btnViewpurchases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PurchasesActivity.class);
                startActivity(intent);
            }
        });

    }

    private void makeApiCallToGetUserProfile() {

        NetworkAPI networkAPI = NetworkModule.getRetrofit().create(NetworkAPI.class);

        networkAPI.getUserProfile().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        User user = response.body();
                        displayUserProfileData(user);
                    }
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call Failure : " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void displayUserProfileData(User user) {

        Glide.with(MainActivity.this).load(user.getImage()).placeholder(R.drawable.loading).into(mainActivityBinding.ivUserimage);

        mainActivityBinding.tvUserName.setText(user.getName());
        mainActivityBinding.tvUsername.setText(user.getUser_name());
        mainActivityBinding.tvFullUsername.setText(user.getFull_name());

        String ph_num = user.getPhone_number();
        mainActivityBinding.tvPhonenumber.setText(Utils.formatPhoneNumber(ph_num));

        String red_date = user.getRegistration();
        mainActivityBinding.tvRegistrationdate.setText(Utils.formatDate(red_date));
    }


}