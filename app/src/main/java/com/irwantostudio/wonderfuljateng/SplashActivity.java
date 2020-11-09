package com.irwantostudio.wonderfuljateng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private int waktu_loading=4000;
//    private FirebaseAuth firebaseAuth;
    private boolean isLogin;
//    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        firebaseAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener(){
//            @Override
//            public  void  onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                if(user!=null){
////                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
////                    startActivity(intent);
////                    finish();
//                    isLogin = true;
//                }else{
                    isLogin = false;
//                }
//            }
//        };

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                if(isLogin) {
//                    //setelah loading maka akan langsung berpindah ke home activity
//                    Intent home = new Intent(SplashActivity.this, MainActivity.class);
//                    startActivity(home);
//                    finish();
//                }else{

                    //setelah loading maka akan langsung berpindah ke login activity
                    Intent home = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(home);
                    finish();
//                }
            }
        },waktu_loading);
    }
}
