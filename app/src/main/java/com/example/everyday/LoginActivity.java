package com.example.everyday;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.everyday.Function.DangKy_DangNhap.DangKyActivity;
import com.example.everyday.Function.DangKy_DangNhap.DangNhapActivity;
import com.example.everyday.Function.DangKy_DangNhap.FacebookActivity;
import com.example.everyday.Function.DangKy_DangNhap.GoogleActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private ImageSlider sildeImage;
    private LinearLayout facebook,google;
    private TextView signup,login;
    private LoginButton facebookApp;
    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sildeImage = (ImageSlider) findViewById(R.id.sildeImage);
        ArrayList<SlideModel> image =new ArrayList<>();
        image.add(new SlideModel(R.drawable.slide1,null));
        image.add(new SlideModel(R.drawable.slide2,null));
        image.add(new SlideModel(R.drawable.slide3,null));
        sildeImage.setImageList(image, ScaleTypes.CENTER_CROP);


        google = (LinearLayout) findViewById(R.id.google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, GoogleActivity.class);
                startActivity(intent);
            }
        });
        facebook=(LinearLayout) findViewById(R.id.face);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, FacebookActivity.class);
                startActivity(intent);
            }
        });

        signup = (TextView) findViewById(R.id.signup);
        //Đăng ký
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });
        // Dăng nhập
        login = (TextView) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this, DangNhapActivity.class);
                startActivity(intent);
            }
        });
        //// Facebook
      /*  facebookApp = (LoginButton) findViewById(R.id.facebook_app);*/
       /* facebookApp.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(getApplicationContext(), loginResult.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(@NonNull FacebookException e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });*/
    }

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }*/
}