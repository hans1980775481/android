package com.example.hans.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class TestFragment extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_fragment);

        Button button = (Button) findViewById(R.id.but_changeRight);

        button.setOnClickListener(this);

        replaceFragment(new RightFragment());

    }


    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_fragment,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        //实现Activity与Fragment的通信
        //        LeftFragment leftFragment = (LeftFragment) fragmentManager.findFragmentById(R.id.left_fragment);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.but_changeRight: {
                replaceFragment(new AnthorRightFragment());
                break;
            }
            default:

        }

    }
}
