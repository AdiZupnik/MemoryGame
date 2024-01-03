package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[][] board;
    int[] pic;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void onNewGame() {
        board = new int[4][4];
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++)
                board[row][col] = new int();
        count = 0;
    }
    private void onNewGame1() {
        pic = new int[8];
        for (int row1 = 0; row1 < 4; row1++)
                pic[row1] = new int();
        count = 0;
    }

    public void knock(View view) {
        if (view.getId() == R.id.im_11)
            handleClick(0, 0, R.id.im_11);
        if (view.getId() == R.id.im_12)
            handleClick(0, 1, R.id.im_12);
        if (view.getId() == R.id.im_13)
            handleClick(0, 2, R.id.im_13);
        if (view.getId() == R.id.im_14)
            handleClick(0, 3, R.id.im_14);
        if (view.getId() == R.id.im_21)
            handleClick(1, 0, R.id.im_21);
        if (view.getId() == R.id.im_22)
            handleClick(1, 1, R.id.im_22);
        if (view.getId() == R.id.im_23)
            handleClick(1, 2, R.id.im_23);
        if (view.getId() == R.id.im_24)
            handleClick(1, 3, R.id.im_24);
        if (view.getId() == R.id.im_31)
            handleClick(2, 0, R.id.im_31);
        if (view.getId() == R.id.im_32)
            handleClick(2, 1, R.id.im_32);
        if (view.getId() == R.id.im_33)
            handleClick(2, 2, R.id.im_33);
        if (view.getId() == R.id.im_34)
            handleClick(2, 3, R.id.im_34);
        if (view.getId() == R.id.im_41)
            handleClick(3, 0, R.id.im_41);
        if (view.getId() == R.id.im_42)
            handleClick(3, 1, R.id.im_42);
        if (view.getId() == R.id.im_43)
            handleClick(3, 2, R.id.im_43);
        if (view.getId() == R.id.im_44)
            handleClick(3, 3, R.id.im_44);
    }
}