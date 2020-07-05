package com.example.fontsizeset.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.fontsizeset.R;
import com.example.fontsizeset.view.ChangeWordTextView;
/**
 * Created by jiangmeng on 2018/5/21.
 */
public class MainActivity extends BaseActivity {

    private ChangeWordTextView name;
    private TextView tvRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        addChangeView(name);
        tvRight = findViewById(R.id.tvRight);
        setlistener();
    }

    private void setlistener() {
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SetTextSizeActivity.class));

            }
        });
    }

}
