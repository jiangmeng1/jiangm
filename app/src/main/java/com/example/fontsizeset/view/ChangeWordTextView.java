package com.example.fontsizeset.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.fontsizeset.spf.FontSizeSPF;


/**
 * Created by jiang on 2018-05-21.
 * TextView 有两种变化策略
 * 1、只变化字体#ChangeWordTextView
 * 2、变化字体及框#ChangeTextViewWhole
 */

public class ChangeWordTextView extends TextView implements ChangeImpl {

    private float sourceTextSize;
    private Context context;

    public ChangeWordTextView(Context context) {
        super(context);
        sourceTextSize = getTextSize();
        this.context=context;
    }

    public ChangeWordTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        sourceTextSize = getTextSize();
        this.context=context;
    }

    public ChangeWordTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        sourceTextSize = getTextSize();
        this.context=context;
    }

    @Override
    public void onChange(float oldMultiple,float newMultiple) {
        if(sourceTextSize <= 0){
            return;
        }
        super.setTextSize(TypedValue.COMPLEX_UNIT_PX, (int)(sourceTextSize * newMultiple + 0.5f));
    }

    @Override
    public void setTextSize(float size) {
        if(sourceTextSize <= 0){
            return;
        }
        super.setTextSize((int)(size * FontSizeSPF.getFontSize(context) + 0.5f));
    }

}
