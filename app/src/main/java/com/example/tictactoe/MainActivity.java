package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;

 int activeplayer=0;
 int[] gameState={2,2,2,2,2,2,2,2,2};
 int [][] winpositions={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};
 public void taptap(View view){
     ImageView img=(ImageView) view;
int tapimage=Integer.parseInt(img.getTag().toString());
     if(!gameActive){
         gameReset(view);

     }
if(gameState[tapimage]==2){
    gameState[tapimage]=activeplayer;
    //img.setTranslationY(-1000f);
    if (activeplayer==0){
        img.setImageResource(R.drawable.xi);
        activeplayer=1;
        TextView textView11=findViewById(R.id.textView11);
        textView11.setText("O's Turn-Tap To Play");
    }
    else{
        img.setImageResource(R.drawable.o);
        activeplayer=0;
        TextView textView11=findViewById(R.id.textView11);
        textView11.setText("X's Turn-Tap To Play");

    }
}
//img.animate().translationXBy(1000f).setDuration(300);







  for(int[] winposition:winpositions)

    {
        if (gameState[winposition[0]] == gameState[winposition[1]] &&
                gameState[winposition[1]] == gameState[winposition[2]] &&
                gameState[winposition[0]] != 2) {
            String winnerstr;
            gameActive = false;
            if (gameState[winposition[0]] == 0) {
                winnerstr = "X has won";
            } else {
                winnerstr = "O has won";
            }
            TextView textView11 = findViewById(R.id.textView11);
            textView11.setText(winnerstr);
        }
    }
}
        private void gameReset(View view) {
            gameActive=true;
            activeplayer=0;
            for (int i=0; i<gameState.length;i++){
                gameState[i]=2;
            }
            ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
            TextView textView11=findViewById(R.id.textView11);
            textView11.setText(("X's Turn Tap to play"));
        }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
