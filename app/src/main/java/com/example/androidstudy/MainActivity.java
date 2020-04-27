package com.example.androidstudy;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment("Fragment" + i,Color.WHITE);
                i++;
            }
        });


    }

    private void addFragment(String name, @ColorInt int color){
        // https://qiita.com/Reyurnible/items/dffd70144da213e1208b
        //FragmentTransactionでFragmentを動的に追加することができる
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,MainFragment.createInstance(name, color));
        // commitすることで反映される
        transaction.commit();
    }
}
