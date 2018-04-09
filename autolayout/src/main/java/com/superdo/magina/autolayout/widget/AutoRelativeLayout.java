package com.superdo.magina.autolayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/4/4 下午5:35
 *      des    自动适配相对布局
 *
 * </pre>
 */

public class AutoRelativeLayout extends RelativeLayout {

    public AutoRelativeLayout(Context context) {
        super(context);
    }

    public AutoRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public AutoRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public AutoRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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

    private static class AutoLayoutParams extends RelativeLayout.LayoutParams {

        private AutoLayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);

            AutoLayoutHelper.setLayoutParams(this, context, attrs);
        }
    }
}
