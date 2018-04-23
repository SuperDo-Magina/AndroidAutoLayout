package com.superdo.magina.autolayout.widget;

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

class AutoLayoutHelper {

    private final static int REFER_TO_WIDTH = 1;
    private final static int REFER_TO_HEIGHT = 2;

    private final static int GRAVITY_DEFAULT = 1;
    private final static int GRAVITY_CENTER = 2;

    static void setLayoutAttrs(View v, Context context, AttributeSet attrs) {
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

            v.setPadding(float2Int(pl * AutoLayout.getUnitSize() + ple * getWidthExtra()),
                    float2Int(pt * AutoLayout.getUnitSize() + pte * getHeightExtra()),
                    float2Int(pr * AutoLayout.getUnitSize() + pre * getWidthExtra()),
                    float2Int(pb * AutoLayout.getUnitSize() + pbe * getHeightExtra()));
        }
        a.recycle();
    }

    static void setLayoutParams(ViewGroup.LayoutParams params, Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AutoView);

        int width = 0, height = 0;

        float ratio = a.getFloat(R.styleable.AutoView_auto_width_height_ratio, 0);

        boolean fullScreen = a.getBoolean(R.styleable.AutoView_auto_full_screen, false);

        if (fullScreen) {//全屏

            if (ratio <= 0) { // 未设置宽高比

                width = getWidth();
                height = getHeight();

            } else {

                int gravity = a.getInt(R.styleable.AutoView_auto_gravity, GRAVITY_DEFAULT);

                if (ratio == AutoLayout.getWidthHeightRatio()) {

                    height = getHeight();

                    width = getWidth();

                } else if (ratio > AutoLayout.getWidthHeightRatio()) {
                    height = getHeight();

                    width = float2Int(getHeight() * ratio);

                    if (gravity == GRAVITY_CENTER) {

                        int margin = (getWidth() - width) / 2;
                        setMargins(params, margin, 0, margin, 0);
                    }

                } else {
                    width = getWidth();

                    height = float2Int(getWidth() / ratio);

                    if (gravity == GRAVITY_CENTER) {

                        int margin = (getHeight() - height) / 2;
                        setMargins(params, 0, margin, 0, margin);
                    }

                }

            }

            params.width = width;
            params.height = height;

        } else {

            int w = a.getInt(R.styleable.AutoView_auto_width, 0);
            int h = a.getInt(R.styleable.AutoView_auto_height, 0);
            float we = a.getFloat(R.styleable.AutoView_auto_width_extra, 0);
            float he = a.getFloat(R.styleable.AutoView_auto_height_extra, 0);

            if (ratio > 0) { // 有设置宽高比

                int ratioRefer = a.getInt(R.styleable.AutoView_auto_ratio_refer_to, 1);

                if (ratioRefer == REFER_TO_WIDTH) { // 基于宽

                    width = float2Int(w * AutoLayout.getUnitSize() + we * getWidthExtra());
                    height = float2Int(width / ratio);

                } else { // 基于高

                    height = float2Int(h * AutoLayout.getUnitSize() + he * getHeightExtra());
                    width = float2Int(height * ratio);

                }

            } else { // 未设置宽高比
                if (w > 0 || we > 0) {
                    width = float2Int(w * AutoLayout.getUnitSize() + we * getWidthExtra());
                }

                if (h > 0 || he > 0) {
                    height = float2Int(h * AutoLayout.getUnitSize() + he * getHeightExtra());
                }
            }

            if (width > 0) {
                params.width = width;
            }

            if (height > 0) {
                params.height = height;
            }

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

                int marginLeft = float2Int(ml * AutoLayout.getUnitSize() + mle * getWidthExtra());
                int marginTop = float2Int(mt * AutoLayout.getUnitSize() + mte * getHeightExtra());
                int marginRight = float2Int(mr * AutoLayout.getUnitSize() + mre * getWidthExtra());
                int marginBottom = float2Int(mb * AutoLayout.getUnitSize() + mbe * getHeightExtra());

                setMargins(params, marginLeft, marginTop, marginRight, marginBottom);
            }
        }

        a.recycle();
    }

    private static void setMargins(ViewGroup.LayoutParams params, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        if (params instanceof RelativeLayout.LayoutParams) {

            ((RelativeLayout.LayoutParams) params).setMargins(
                    marginLeft,
                    marginTop,
                    marginRight,
                    marginBottom);

        } else if (params instanceof LinearLayout.LayoutParams) {

            ((LinearLayout.LayoutParams) params).setMargins(
                    marginLeft,
                    marginTop,
                    marginRight,
                    marginBottom);

        } else if (params instanceof FrameLayout.LayoutParams) {

            ((FrameLayout.LayoutParams) params).setMargins(
                    marginLeft,
                    marginTop,
                    marginRight,
                    marginBottom);
        }
    }

    private static int getWidth() {
        return AutoLayout.isPortrait() ? AutoLayout.getWidth() : AutoLayout.getHeight();
    }

    private static int getHeight() {
        return AutoLayout.isPortrait() ? AutoLayout.getHeight() : AutoLayout.getWidth();
    }

    private static int getHeightExtra() {

        return AutoLayout.isPortrait() ?
                AutoLayout.getHeightExtra() : AutoLayout.getWidthExtra();
    }

    private static int getWidthExtra() {

        return AutoLayout.isPortrait() ?
                AutoLayout.getWidthExtra() : AutoLayout.getHeightExtra();
    }

    private static int float2Int(float f) {
        return (int) (f + .5f);
    }
}
