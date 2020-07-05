package com.example.fontsizeset.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fontsizeset.R;
import com.example.fontsizeset.spf.FontSizeSPF;
import com.example.fontsizeset.view.ChangeImpl;
import com.example.fontsizeset.view.ChangeWordTextView;
import com.example.fontsizeset.view.CircleImageView;
import com.example.fontsizeset.view.SetTextSizeView;

/**
 * Created by jiangmeng on 2018/5/21.
 */
public class SetTextSizeActivity extends BaseActivity {
    private SetTextSizeView setTextFont;
    private TextView textStandard, textMid, textBig,tvRight;
    private int setTextType=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_font_size);
        initView();
        initListener();
    }

    private void initView(){
        setTitle("字体大小");
        ChangeWordTextView otherText = (ChangeWordTextView) findViewById(R.id.message_content_other);
        ChangeWordTextView mineText = (ChangeWordTextView) findViewById(R.id.message_content);
        addChangeView(otherText, mineText);
        CircleImageView avatar = (CircleImageView) findViewById(R.id.user_avatar);
//        IMUIHelper.display(IMLoginManager.instance().getLoginInfo().getAvatar(), avatar, R.mipmap.default_head);
        setTextFont = (SetTextSizeView) findViewById(R.id.set_text_font);
        textStandard = (TextView) findViewById(R.id.text_standard);
        textMid = (TextView) findViewById(R.id.text_mid);
        textBig = (TextView) findViewById(R.id.text_big);
        tvRight = (TextView) findViewById(R.id.tvRight);
        float appSize= FontSizeSPF.getFontSize(SetTextSizeActivity.this);
        if (appSize==1f)
            setTextType=0;
        else if(appSize==1.12f)
            setTextType=1;
        else if(appSize==1.25f)
            setTextType=2;
        setTextFont.setIndex(setTextType);
        setPointText(setTextType);
    }


    private void initListener(){
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (setTextType){
                    case 0:
                        FontSizeSPF.writeFontSize(SetTextSizeActivity.this,1.0f);
                        finish();
                        break;
                    case 1:
                        FontSizeSPF.writeFontSize(SetTextSizeActivity.this,1.12f);
                        finish();
                        break;
                    case 2:
                        FontSizeSPF.writeFontSize(SetTextSizeActivity.this,1.25f);
                        finish();
                        break;
                }
            }
        });
        setTextFont.setOnPointResultListener(new SetTextSizeView.OnPointResultListener() {
            @Override
            public void onPointResult(int position) {
                setPointText(position);
            }
        });
    }

    private void setPointText(int position){
        textStandard.setTextColor(Color.parseColor("#969696"));
        textMid.setTextColor(Color.parseColor("#969696"));
        textBig.setTextColor(Color.parseColor("#969696"));
        float oldSize = 0, newSize = 0;
        switch (setTextType){
            case 0:
                oldSize = 1.0f;
                break;
            case 1:
                oldSize = 1.12f;
                break;
            case 2:
                oldSize = 1.25f;
                break;
        }
        setTextType=position;
        switch (position) {
            case 0:
                newSize = 1.0f;
                textStandard.setTextColor(Color.parseColor("#2c2c2c"));
                break;
            case 1:
                newSize = 1.12f;
                textMid.setTextColor(Color.parseColor("#2c2c2c"));
                break;
            case 2:
                newSize = 1.25f;
                textBig.setTextColor(Color.parseColor("#2c2c2c"));
                break;
        }
        for(ChangeImpl changeView:changeViews){
            changeView.onChange(oldSize, newSize);
        }
    }
}

