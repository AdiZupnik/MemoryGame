package com.example.memorygame;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    GoogleSignInClient googleSignInClient;
    ShapeableImageView imageView;
    TextView name, mail;
    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                try {
                    GoogleSignInAccount signInAccount = accountTask.getResult(ApiException.class);
                    AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                    auth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                auth = FirebaseAuth().getInstance();
                                Glide.with(MainActivity.this).load(Objects.requireNonNull(auth.getCurrentUser()).getPhotoUrl()).into(imageView);
                                name.setText(auth.getCurrentUser().getDisplayName());
                                mail.setText(auth.getCurrentUser().getEmail());
                                Toast.makeText(MainActivity.this, "Sign in successfully!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Failed to sign in: " + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    });


    String[][] board;
    ImageView[] ImageViews;
    int count;
    int countPlayer1 = 0;
    int countPlayer2 = 0;
    int card1;
    String turn = "counterPlayer1";
    Integer[] drawableIds = {
            // Array of drawable resource IDs
            R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4, R.drawable.dog5, R.drawable.dog6, R.drawable.dog7, R.drawable.dog8,
            R.drawable.dog1, R.drawable.dog2, R.drawable.dog3, R.drawable.dog4, R.drawable.dog5, R.drawable.dog6, R.drawable.dog7, R.drawable.dog8
    };
    int[] viewId = {
            //creates arr of view Ids
            R.id.im_11, R.id.im_12, R.id.im_13, R.id.im_14,
            R.id.im_21, R.id.im_22, R.id.im_23, R.id.im_24,
            R.id.im_31, R.id.im_32, R.id.im_33, R.id.im_34,
            R.id.im_41, R.id.im_42, R.id.im_43, R.id.im_44
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void onNewGame() {
        shuffleCards();
        board = new String[4][4];
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                board[row][col] = new String();
            }
        count = 0;
    }

    private void onNewGame1() {
        ImageView[] imageViews = new ImageView[16];
        for (int i = 0; i < drawableIds.length; i++) {
            // Create a new ImageView
            Context context = null;
            ImageView imageView = new ImageView(context);
            // Set the image resource for the ImageView
            imageView.setImageResource(drawableIds[i]);
            // Add the ImageView to the array
            imageViews[i] = imageView;
        }
    }

    private void shuffleCards() {
        List<Integer> drawableIdsList = Arrays.asList(drawableIds);
        Collections.shuffle(drawableIdsList);
        drawableIdsList.toArray(drawableIds);
    }

    public void knock(View view) {
        count++;
        for (int i = 0; i < viewId.length; i++) {
            if (view.getId() == viewId[i]) {
                ImageView backImageView = findViewById(viewId[i]);
                backImageView.setImageResource(drawableIds[i]);
                turnEnd(view);
            }
        }
    }

    public void turnEnd(View view) {
        if (count % 2 != 0) {
            card1 = view.getId();
            return;
        }
        if (count % 2 == 0) {
            ImageView imageViewCard1 = findViewById(card1);
            Drawable image1 = imageViewCard1.getDrawable();
            Drawable image2 = ((ImageView) view).getDrawable();
            if (image1.getConstantState().equals(image2.getConstantState())) {
                if (turn.equals("counterPlayer1")) {
                    countPlayer1++;
                    TextView counterTextView = findViewById(R.id.counter1);
                    counterTextView.setText("P1-" + countPlayer1);
                    turn = "counterPlayer2";
                } else {
                    countPlayer2++;
                    TextView counterTextView = findViewById(R.id.counter2);
                    counterTextView.setText("P2-" + countPlayer2);
                    turn = "counterPlayer1";
                }
            } else {
                if (turn.equals("counterPlayer1")) {
                    turn = "counterPlayer2";
                } else {
                    turn = "counterPlayer1";

                }
            }
        }
    }

    public void Reset(View view) {
        shuffleCards();
        count = 0;
        countPlayer1 = 0;
        TextView counterTextView = findViewById(R.id.counter1);
        counterTextView.setText("P1-" + countPlayer1);
        countPlayer2 = 0;
        TextView counterTextView2 = findViewById(R.id.counter2);
        counterTextView2.setText("P2-" + countPlayer2);
        for (int i = 0; i < viewId.length; i++) {
            ImageView cardClosed = findViewById(viewId[i]);
            cardClosed.setImageResource(R.drawable.card_back);
        }
    }

    public void closeCard(View view) {
        ImageView imageViewCard1 = findViewById(card1);
        Drawable image1 = imageViewCard1.getDrawable();
        Drawable image2 = ((ImageView) view).getDrawable();
        for (int i = 0; i < viewId.length; i++) {
            if(!image1.getConstantState().equals(image2.getConstantState())) {
                ImageView cardClosed = findViewById(viewId[i]);
                cardClosed.setImageResource(R.drawable.card_back);
            }
        }
    }
}