package com.example.hans.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Lenovo on 2018/9/6.
 */
public class TestActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        Intent intent = getIntent();
        String data = intent.getStringExtra("value");
        EditText editText = (EditText) findViewById(R.id.edit);
        editText.setText(data);

        Button button = (Button) findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.edit);
                String data = editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("value",data);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        EditText editText = (EditText) findViewById(R.id.edit);
        String data = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("value",data);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onClick(View v) {

    }
}
