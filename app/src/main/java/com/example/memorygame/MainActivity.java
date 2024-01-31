package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String[][] board;
    ImageView[] ImageViews;
    int count;
    int countPlayer1 = 0 ;
    int countPlayer2 = 0;
    int card1;
    String turn = "counterPlayer1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void onNewGame() {
        board = new String[4][4];
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                board[row][col] = new String();
            }
        count = 0;
    }

    private void onNewGame1() {
        ImageView[] imageViews = new ImageView[8];

        // Array of drawable resource IDs
        int[] drawableIds = {
                R.drawable.dog1,
                R.drawable.dog2,
                R.drawable.dog3,
                R.drawable.dog4,
                R.drawable.dog5,
                R.drawable.dog6,
                R.drawable.dog7,
                R.drawable.dog8
        };

        for (int i = 0; i < 8; i++) {
            // Create a new ImageView
            Context context = null;
            ImageView imageView = new ImageView(context);
            // Set the image resource for the ImageView
            imageView.setImageResource(drawableIds[i]);
            // Add the ImageView to the array
            imageViews[i] = imageView;
        }
    }

    public void knock(View view) {
        if (view.getId() == R.id.im_11) {
            count++;
            ImageView backImageView = findViewById(R.id.im_11);
            backImageView.setImageResource(R.drawable.dog1);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_12) {
            count++;
            ImageView backImageView = findViewById(R.id.im_12);
            backImageView.setImageResource(R.drawable.dog2);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_13){
            count++;
            ImageView backImageView = findViewById(R.id.im_13);
            backImageView.setImageResource(R.drawable.dog3);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_14){
            count++;
            ImageView backImageView = findViewById(R.id.im_14);
            backImageView.setImageResource(R.drawable.dog4);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_21){
            count++;
            ImageView backImageView = findViewById(R.id.im_21);
            backImageView.setImageResource(R.drawable.dog5);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_22){
            count++;
            ImageView backImageView = findViewById(R.id.im_22);
            backImageView.setImageResource(R.drawable.dog6);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_23){
            count++;
            ImageView backImageView = findViewById(R.id.im_23);
            backImageView.setImageResource(R.drawable.dog7);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_24){
            count++;
            ImageView backImageView = findViewById(R.id.im_24);
            backImageView.setImageResource(R.drawable.dog8);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_31){
            count++;
            ImageView backImageView = findViewById(R.id.im_31);
            backImageView.setImageResource(R.drawable.dog1);
            turnEnd(view);
        }
        if (view.getId() == R.id.im_32){
                count++;
                ImageView backImageView = findViewById(R.id.im_32);
                backImageView.setImageResource(R.drawable.dog2);
                turnEnd(view);
            }
        if (view.getId() == R.id.im_33) {
                count++;
                ImageView backImageView = findViewById(R.id.im_33);
                backImageView.setImageResource(R.drawable.dog3);
                turnEnd(view);
            }
        if (view.getId() == R.id.im_34) {
                count++;
                ImageView backImageView = findViewById(R.id.im_34);
                backImageView.setImageResource(R.drawable.dog4);
                turnEnd(view);
            }
        if (view.getId() == R.id.im_41) {
                count++;
                ImageView backImageView = findViewById(R.id.im_41);
                backImageView.setImageResource(R.drawable.dog5);
                turnEnd(view);
            }
        if (view.getId() == R.id.im_42) {
                count++;
                ImageView backImageView = findViewById(R.id.im_42);
                backImageView.setImageResource(R.drawable.dog6);
                turnEnd(view);
            }
        if (view.getId() == R.id.im_43) {
                count++;
                ImageView backImageView = findViewById(R.id.im_43);
                backImageView.setImageResource(R.drawable.dog7);
                turnEnd(view);
            }
        if (view.getId() == R.id.im_44) {
                count++;
                ImageView backImageView = findViewById(R.id.im_44);
                backImageView.setImageResource(R.drawable.dog8);
                turnEnd(view);
            }
        }
        public void closeCard(int card1, ImageView view){
            ImageView card1Closed = findViewById(card1);
            card1Closed.setImageResource(R.drawable.card_back);
            ImageView card2Closed = findViewById(view.getId());
            card2Closed.setImageResource(R.drawable.card_back);
        }
        public void turnEnd(View view) {
            if (count % 2 != 0){
                card1 = view.getId();
                return;
            }
            if(count % 2 == 0){
                ImageView imageViewCard1 = findViewById(card1);
                Drawable image1 = imageViewCard1.getDrawable();
                Drawable image2 = ((ImageView)view).getDrawable();
                if(image1.getConstantState().equals(image2.getConstantState())){
                    if(turn.equals("counterPlayer1")){
                        countPlayer1 ++ ;
                        turn  = "counterPlayer2";
                    }
                    else{
                        countPlayer2++;
                        turn = "counterPlayer1";
                    }
                }
                else{
                    final Handler handler = new Handler();
                    handler.postDelayed(() -> closeCard(card1,((ImageView) view)), 400);
                    if(turn.equals("counterPlayer1")){
                        turn  = "counterPlayer2";
                    }
                    else{
                        turn = "counterPlayer1";
                    }
                }
            }
        }

    }