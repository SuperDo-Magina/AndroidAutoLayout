package com.superdo.magina.autolayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/4/4 下午5:35
 *      des    自动适配线性布局
 *
 * </pre>
 */

public class AutoLinearLayout extends LinearLayout {

    public AutoLinearLayout(Context context) {
        super(context);
    }

    public AutoLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AutoLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        AutoLayoutHelper.setLayoutAttrs(this, context, attrs);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new AutoLayoutParams(getContext(), attrs);
    }

    private static class AutoLayoutParams extends LayoutParams {

        private AutoLayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);

            AutoLayoutHelper.setLayoutParams(this, context, attrs);
        }
    }
}
