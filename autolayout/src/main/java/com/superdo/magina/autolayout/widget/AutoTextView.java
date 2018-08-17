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
import com.superdo.magina.autolayout.util.LayoutUtil;

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

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            float spacingExtra = a.getFloat(R.styleable.AutoTextView_auto_line_spacing_extra, -1);

            if (spacingExtra > 0) {
                setLineSpacing(spacingExtra * AutoLayout.getUnitSize(), getLineSpacingMultiplier());
            }
        }

        int pl = a.getInt(R.styleable.AutoTextView_auto_padding_left, 0);
        int pt = a.getInt(R.styleable.AutoTextView_auto_padding_top, 0);
        int pr = a.getInt(R.styleable.AutoTextView_auto_padding_right, 0);
        int pb = a.getInt(R.styleable.AutoTextView_auto_padding_bottom, 0);
        float ple = a.getFloat(R.styleable.AutoTextView_auto_padding_left_extra, 0);
        float pte = a.getFloat(R.styleable.AutoTextView_auto_padding_top_extra, 0);
        float pre = a.getFloat(R.styleable.AutoTextView_auto_padding_right_extra, 0);
        float pbe = a.getFloat(R.styleable.AutoTextView_auto_padding_bottom_extra, 0);

        if (pl > 0 || pt > 0 || pr > 0 || pb > 0 ||
                ple > 0 || pte > 0 || pre > 0 || pbe > 0) {

            setPadding(LayoutUtil.float2Int(pl * AutoLayout.getUnitSize() + ple * getWidthExtra()),
                    LayoutUtil.float2Int(pt * AutoLayout.getUnitSize() + pte * getHeightExtra()),
                    LayoutUtil.float2Int(pr * AutoLayout.getUnitSize() + pre * getWidthExtra()),
                    LayoutUtil.float2Int(pb * AutoLayout.getUnitSize() + pbe * getHeightExtra()));
        }

        a.recycle();
    }

    public void setAutoLineSpacing(float add, float mult) {
        setLineSpacing(add * AutoLayout.getUnitSize(), mult);
    }

    private static int getHeightExtra() {

        return AutoLayout.isPortrait() ?
                AutoLayout.getHeightExtra() : AutoLayout.getWidthExtra();
    }

    private static int getWidthExtra() {

        return AutoLayout.isPortrait() ?
                AutoLayout.getWidthExtra() : AutoLayout.getHeightExtra();
    }
}
