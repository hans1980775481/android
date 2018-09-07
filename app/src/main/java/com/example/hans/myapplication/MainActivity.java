package com.example.hans.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button  = (Button) findViewById(R.id.baidu);
        button.setOnClickListener(this);
        Button button2  = (Button) findViewById(R.id.test);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "123";
                Intent intent = new Intent("com.example.hans.myapplication.TestActivity");
                intent.putExtra("value",data);
//                startActivity(intent);
                startActivityForResult(intent,1);
            }
        });

        Button button3 = (Button) findViewById(R.id.testFragment);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.hans.myapplication.TestFragment");
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 1: {
                if (resultCode == RESULT_OK) {
                    String resultData = data.getStringExtra("value");
                    Toast.makeText(this,resultData,Toast.LENGTH_SHORT).show();

                }
                break;
            }
            default:
        }
    }


    public void showTextView(View view) {
        Intent intent = new Intent(MainActivity.this,TextViewActivity.class);

        startActivity(intent);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.testmMenu) {
            finish();

            return true;
        }
        if (id == R.id.stop) {
            stop();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    public void stop() {
        ActivityCollector.finshAll();
    }
}
