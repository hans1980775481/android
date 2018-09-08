package com.example.hans.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewTest extends BaseActivity {
    private String[] data = {"c语言","c++语言","c#语言","java语言","php语言","python语言","ruby语言","GO语言"
    ,"swift语言","javascript语言","html语言","shell命令语言","ssh框架","ssm框架","laravel框架"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_listview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(ListViewTest.this,android.R.layout.simple_list_item_1,data);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);
    }
}
