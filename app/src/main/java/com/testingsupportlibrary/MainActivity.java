package com.testingsupportlibrary;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.testingsupportlibrary.utils.Calculator;

import static android.view.View.VISIBLE;

public class MainActivity extends AppCompatActivity {

    private EditText mScreenEditText;
    private Calculator mCalculator;
    private CardView mCardView;
    private TextView mTotalTextView;
    private Handler mHandler;

    private int mFirstArgument = 0;
    private int mSecondArgument = 0;
    private char mOperator = '+';
    private boolean mArgumentSwitcher = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardView = (CardView)findViewById(R.id.cardView);
        mScreenEditText = (EditText) findViewById(R.id.Screen_editText);
        mTotalTextView = (TextView) findViewById(R.id.totalTextView);
        mCalculator = new Calculator();
        setAnimation();
    }

    public void onOperandClick(View v){
        Button view = (Button)v;
        StringBuilder stringBuilder = new StringBuilder(mScreenEditText.getText());
        if(mArgumentSwitcher){
            mFirstArgument = Integer.parseInt(view.getText().toString());
            stringBuilder.append(mFirstArgument);
        }else{
            mSecondArgument = Integer.parseInt(view.getText().toString());
            stringBuilder.append(mSecondArgument);
        }
        mScreenEditText.setText(stringBuilder.toString());
        mArgumentSwitcher = !mArgumentSwitcher;
    }

    public void onOperatorClick(View v){
        Button view = (Button)v;
        mOperator = view.getText().charAt(0);
        StringBuilder stringBuilder = new StringBuilder(mScreenEditText.getText());
        stringBuilder.append(mOperator);
        mScreenEditText.setText(stringBuilder.toString());
    }

    public void onReset(View view){
        mFirstArgument = 0;
        mSecondArgument = 0;
        mOperator = '+';
        mScreenEditText.setText("");
    }

    public void onEqualClick(View v){
        Button view = (Button)v;
        int answer = 0;
        switch (mOperator){
            case '+':
                answer = mCalculator.add(mFirstArgument, mSecondArgument);
                break;
            case '-':
                answer = mCalculator.subtract(mFirstArgument, mSecondArgument);
                break;
            case '*':
                answer = mCalculator.multiply(mFirstArgument, mSecondArgument);
                break;
            case '/':
                answer = mCalculator.divide(mFirstArgument, mSecondArgument);
                break;
        }
        onReset(null);
        mTotalTextView.setText("Answer: "+answer);
    }

    private void setAnimation() {
        mHandler = new Handler();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCardView.setVisibility(VISIBLE);
                mCardView.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_to_bottom));
            }
        }, 500);
    }

}
