package com.superdo.magina.autolayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

import com.superdo.magina.autolayout.AutoLayout;
import com.superdo.magina.autolayout.R;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/4/9 上午10:34
 *      des
 *
 * </pre>
 */

public class AutoTextView extends TextView {
    public AutoTextView(Context context) {
        super(context);
    }

    public AutoTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AutoTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoTextView);

        int textSize = a.getInt(R.styleable.AutoTextView_auto_text_size, -1);
        if (textSize >= 0) {
            setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize * AutoLayout.getUnitSize());
        }

        a.recycle();
    }
}
