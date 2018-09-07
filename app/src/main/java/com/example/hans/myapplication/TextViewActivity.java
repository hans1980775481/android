package com.example.hans.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TextViewActivity extends BaseActivity {

    private TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_textview01);

    }

    public void changeTextView(View view) {
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText("我变了");
    }

}
