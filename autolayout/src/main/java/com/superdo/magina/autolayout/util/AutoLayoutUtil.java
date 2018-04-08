package com.superdo.magina.autolayout.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.superdo.magina.autolayout.AutoLayout;
import com.superdo.magina.autolayout.R;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/4/8 上午11:16
 *      des
 *
 * </pre>
 */

public class AutoLayoutUtil {

    public static void setLayoutAttrs(View v, Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoView);
        int pl = a.getInt(R.styleable.AutoView_auto_padding_left, 0);
        int pt = a.getInt(R.styleable.AutoView_auto_padding_top, 0);
        int pr = a.getInt(R.styleable.AutoView_auto_padding_right, 0);
        int pb = a.getInt(R.styleable.AutoView_auto_padding_bottom, 0);
        float ple = a.getFloat(R.styleable.AutoView_auto_padding_left_extra, 0);
        float pte = a.getFloat(R.styleable.AutoView_auto_padding_top_extra, 0);
        float pre = a.getFloat(R.styleable.AutoView_auto_padding_right_extra, 0);
        float pbe = a.getFloat(R.styleable.AutoView_auto_padding_bottom_extra, 0);

        if (pl > 0 || pt > 0 || pr > 0 || pb > 0 ||
                ple > 0 || pte > 0 || pre > 0 || pbe > 0) {

            v.setPadding((int) (pl * AutoLayout.getUnitSize() + ple * getWidthExtra()),
                    (int) (pt * AutoLayout.getUnitSize() + pte * getHeightExtra()),
                    (int) (pr * AutoLayout.getUnitSize() + pre * getWidthExtra()),
                    (int) (pb * AutoLayout.getUnitSize() + pbe * getHeightExtra()));
        }
        a.recycle();
    }

    public static void setLayoutParams(ViewGroup.LayoutParams params, Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoView);

        int w = a.getInt(R.styleable.AutoView_auto_width, 0);
        int h = a.getInt(R.styleable.AutoView_auto_height, 0);
        int we = a.getInt(R.styleable.AutoView_auto_width_extra, 0);
        int he = a.getInt(R.styleable.AutoView_auto_height_extra, 0);

        if (w > 0 || we > 0)
            params.width = (int) (w * AutoLayout.getUnitSize() + we * getWidthExtra());
        if (h > 0 || he > 0)
            params.height = (int) (h * AutoLayout.getUnitSize() + he * getHeightExtra());

        int ml = a.getInt(R.styleable.AutoView_auto_margin_left, 0);
        int mt = a.getInt(R.styleable.AutoView_auto_margin_top, 0);
        int mr = a.getInt(R.styleable.AutoView_auto_margin_right, 0);
        int mb = a.getInt(R.styleable.AutoView_auto_margin_bottom, 0);
        float mle = a.getFloat(R.styleable.AutoView_auto_margin_left_extra, 0);
        float mte = a.getFloat(R.styleable.AutoView_auto_margin_top_extra, 0);
        float mre = a.getFloat(R.styleable.AutoView_auto_margin_right_extra, 0);
        float mbe = a.getFloat(R.styleable.AutoView_auto_margin_bottom_extra, 0);

        if (ml > 0 || mt > 0 || mr > 0 || mb > 0 ||
                mle > 0 || mte > 0 || mre > 0 || mbe > 0) {

            if (params instanceof RelativeLayout.LayoutParams) {

                ((RelativeLayout.LayoutParams) params).setMargins((int) (ml * AutoLayout.getUnitSize() + mle * getWidthExtra()),
                        (int) (mt * AutoLayout.getUnitSize() + mte * getHeightExtra()),
                        (int) (mr * AutoLayout.getUnitSize() + mre * getWidthExtra()),
                        (int) (mb * AutoLayout.getUnitSize() + mbe * getHeightExtra()));

            } else if (params instanceof LinearLayout.LayoutParams) {

                ((LinearLayout.LayoutParams) params).setMargins((int) (ml * AutoLayout.getUnitSize() + mle * getWidthExtra()),
                        (int) (mt * AutoLayout.getUnitSize() + mte * getHeightExtra()),
                        (int) (mr * AutoLayout.getUnitSize() + mre * getWidthExtra()),
                        (int) (mb * AutoLayout.getUnitSize() + mbe * getHeightExtra()));

            } else if (params instanceof FrameLayout.LayoutParams) {

                ((FrameLayout.LayoutParams) params).setMargins((int) (ml * AutoLayout.getUnitSize() + mle * getWidthExtra()),
                        (int) (mt * AutoLayout.getUnitSize() + mte * getHeightExtra()),
                        (int) (mr * AutoLayout.getUnitSize() + mre * getWidthExtra()),
                        (int) (mb * AutoLayout.getUnitSize() + mbe * getHeightExtra()));
            }
        }

        a.recycle();
    }

    private static int getHeightExtra() {

        return AutoLayout.getScreenOrientation() == AutoLayout.ScreenOrientation.PORTRAIT ?
                AutoLayout.getHeightExtra() : AutoLayout.getWidthExtra();
    }

    private static int getWidthExtra() {

        return AutoLayout.getScreenOrientation() == AutoLayout.ScreenOrientation.PORTRAIT ?
                AutoLayout.getWidthExtra() : AutoLayout.getHeightExtra();
    }
}
