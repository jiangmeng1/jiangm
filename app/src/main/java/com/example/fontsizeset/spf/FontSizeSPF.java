package com.example.fontsizeset.spf;

import android.content.Context;
import android.content.SharedPreferences;
/**
 * Created by jiangmeng on 2018/5/21.
 */
public class FontSizeSPF {

    public static void writeFontSize(Context context, float fontSize) {
        SharedPreferences sp = context.getSharedPreferences("fontsizeset", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putFloat("fontSize", fontSize);
        editor.apply();
    }

    public static float getFontSize(Context context) {
        SharedPreferences sp = context.getSharedPreferences("fontsizeset", Context.MODE_PRIVATE);
        return sp.getFloat("fontSize",1.0f);
//        SharedPreferences.Editor editor = sp.edit();
//        editor.putString("fontSize", fontSize);
//        editor.apply();
    }
}
