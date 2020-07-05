package com.example.fontsizeset.activity;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fontsizeset.spf.FontSizeSPF;
import com.example.fontsizeset.view.ChangeImpl;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by jiangmeng on 2018/5/21.
 */
public class BaseActivity extends AppCompatActivity {
    protected List<ChangeImpl> changeViews = new ArrayList<>();
    private float AppSizeMultiple = 1.0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        onChange();
    }

    public void onChange() {
        if(FontSizeSPF.getFontSize(BaseActivity.this) != AppSizeMultiple){
            for(ChangeImpl changeView:changeViews){
                changeView.onChange(AppSizeMultiple, FontSizeSPF.getFontSize(BaseActivity.this));
            }
            AppSizeMultiple = FontSizeSPF.getFontSize(BaseActivity.this);
        }
    }

    public void addChangeView(ChangeImpl... changeView) {
        for(ChangeImpl change:changeView){
            if (!changeViews.contains(change)) {
                changeViews.add(change);
            }
        }
    }
}
