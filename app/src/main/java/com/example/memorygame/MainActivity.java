package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void knock1(View view) {
        ImageView cardOne = findViewById(R.id.im_11);
        cardOne.setImageResource(R.drawable.dog1);
    }
    public void knock2(View view) {
        ImageView cardOne = findViewById(R.id.im_12);
        cardOne.setImageResource(R.drawable.dog2);
    }
    public void knock3(View view) {
        ImageView cardOne = findViewById(R.id.im_13);
        cardOne.setImageResource(R.drawable.dog3);
    }
    public void knock4(View view) {
        ImageView cardOne = findViewById(R.id.im_14);
        cardOne.setImageResource(R.drawable.dog4);
    }
    public void knock5(View view) {
        ImageView cardOne = findViewById(R.id.im_21);
        cardOne.setImageResource(R.drawable.dog5);
    }
    public void knock6(View view) {
        ImageView cardOne = findViewById(R.id.im_22);
        cardOne.setImageResource(R.drawable.dog6);
    }
    public void knock7(View view) {
        ImageView cardOne = findViewById(R.id.im_23);
        cardOne.setImageResource(R.drawable.dog7);
    }
    public void knock8(View view) {
        ImageView cardOne = findViewById(R.id.im_24);
        cardOne.setImageResource(R.drawable.dog8);
    }
    public void knock9(View view) {
        ImageView cardOne = findViewById(R.id.im_31);
        cardOne.setImageResource(R.drawable.dog1);
    }
    public void knock10(View view) {
        ImageView cardOne = findViewById(R.id.im_32);
        cardOne.setImageResource(R.drawable.dog2);
    }
    public void knock11(View view) {
        ImageView cardOne = findViewById(R.id.im_33);
        cardOne.setImageResource(R.drawable.dog3);
    }
    public void knock12(View view) {
        ImageView cardOne = findViewById(R.id.im_34);
        cardOne.setImageResource(R.drawable.dog4);
    }
    public void knock13(View view) {
        ImageView cardOne = findViewById(R.id.im_41);
        cardOne.setImageResource(R.drawable.dog5);
    }
    public void knock14(View view) {
        ImageView cardOne = findViewById(R.id.im_42);
        cardOne.setImageResource(R.drawable.dog6);
    }
    public void knock15(View view) {
        ImageView cardOne = findViewById(R.id.im_43);
        cardOne.setImageResource(R.drawable.dog7);
    }
    public void knock16(View view) {
        ImageView cardOne = findViewById(R.id.im_44);
        cardOne.setImageResource(R.drawable.dog8);
    }
}