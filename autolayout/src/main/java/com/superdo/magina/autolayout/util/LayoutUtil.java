package com.superdo.magina.autolayout.util;

import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.superdo.magina.autolayout.AutoLayout;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/4/8 上午11:16
 *      des    布局适配工具
 *
 * </pre>
 */

public class LayoutUtil {

    /**
     * 为 RelativeLayout 的子布局适配
     *
     * @param v 要适配的视图
     * @param w 宽度所占单元（0则不改变其原有大小）
     * @param h 高度所占单元（0则不改变其原有大小）
     */
    public static void adapterView4RL(View v, float w, float h) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            Log.e("auto", "adapterView4RL null");
            params = new RelativeLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = float2Int(w * unit);
        }

        if (h != 0) {
            params.height = float2Int(h * unit);
        }
        v.setLayoutParams(params);
    }

    /**
     * 为 RelativeLayout 的子布局适配
     *
     * @param v  要适配的视图
     * @param w  宽度所占单元（0则不改变其原有大小）
     * @param h  高度所占单元（0则不改变其原有大小）
     * @param ml 左边距所占单元
     * @param mt 上边距所占单元
     * @param mr 右边距所占单元
     * @param mb 下边距所占单元
     */
    public static void adapterView4RL(View v, float w, float h, float ml, float mt, float mr, float mb) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            Log.e("auto", "adapterView4RL null");
            params = new RelativeLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = float2Int(w * unit);
        }

        if (h != 0) {
            params.height = float2Int(h * unit);
        }
        params.setMargins(float2Int(ml * unit), float2Int(mt * unit), float2Int(mr * unit), float2Int(mb * unit));
        v.setLayoutParams(params);
    }

    /**
     * 为 LinearLayout 的子布局适配
     *
     * @param v 要适配的视图
     * @param w 宽度所占单元（0则不改变其原有大小）
     * @param h 高度所占单元（0则不改变其原有大小）
     */
    public static void adapterView4LL(View v, float w, float h) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            params = new LinearLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = float2Int(w * unit);
        }

        if (h != 0) {
            params.height = float2Int(h * unit);
        }
        v.setLayoutParams(params);
    }

    /**
     * 为 LinearLayout 的子布局适配
     *
     * @param v  要适配的视图
     * @param w  宽度所占单元（0则不改变其原有大小）
     * @param h  高度所占单元（0则不改变其原有大小）
     * @param ml 左边距所占单元
     * @param mt 上边距所占单元
     * @param mr 右边距所占单元
     * @param mb 下边距所占单元
     */
    public static void adapterView4LL(View v, float w, float h, float ml, float mt, float mr, float mb) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            params = new LinearLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = float2Int(w * unit);
        }

        if (h != 0) {
            params.height = float2Int(h * unit);
        }
        params.setMargins(float2Int(ml * unit), float2Int(mt * unit), float2Int(mr * unit), float2Int(mb * unit));
        v.setLayoutParams(params);
    }

    /**
     * 为 FrameLayout 的子布局适配
     *
     * @param v 要适配的视图
     * @param w 宽度所占单元（0则不改变其原有大小）
     * @param h 高度所占单元（0则不改变其原有大小）
     */
    public static void adapterView4FL(View v, float w, float h) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            params = new FrameLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = float2Int(w * unit);
        }

        if (h != 0) {
            params.height = float2Int(h * unit);
        }
        v.setLayoutParams(params);
    }

    /**
     * 为 RelativeLayout 的子布局适配
     *
     * @param v  要适配的视图
     * @param w  宽度所占单元（0则不改变其原有大小）
     * @param h  高度所占单元（0则不改变其原有大小）
     * @param ml 左边距所占单元
     * @param mt 上边距所占单元
     * @param mr 右边距所占单元
     * @param mb 下边距所占单元
     */
    public static void adapterView4FL(View v, float w, float h, float ml, float mt, float mr, float mb) {
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            params = new FrameLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = float2Int(w * unit);
        }

        if (h != 0) {
            params.height = float2Int(h * unit);
        }
        params.setMargins(float2Int(ml * unit), float2Int(mt * unit), float2Int(mr * unit), float2Int(mb * unit));
        v.setLayoutParams(params);
    }

    public static void adapterTextSize(TextView tv, int size) {
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                LayoutUtil.float2Int(size * AutoLayout.getUnitSize()));
    }

    /**
     * 设置view的padding值
     *
     * @param v 要适配的视图
     */
    public static void setViewPadding(View v, float left, float top, float right, float bottom) {
        v.setPadding(unit2Px(left), unit2Px(top), unit2Px(right), unit2Px(bottom));
    }

    public static void addRule4RL(View v, int verb) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) v.getLayoutParams();
        if (params == null) {
            params = new RelativeLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }

        params.addRule(verb, RelativeLayout.TRUE);
        v.setLayoutParams(params);
    }

    /**
     * 获取n个单元大小
     */
    public static float getUnitSize(int n) {
        return n * AutoLayout.getUnitSize();
    }

    /**
     * 获取n个单元大小
     */
    public static float getUnitSize(float n) {
        return n * AutoLayout.getUnitSize();
    }

    /**
     * float转int（四舍五入）
     *
     * @param f float值
     * @return int值
     */
    public static int float2Int(float f) {
        return (int) (f + .5f);
    }

    /**
     * unit值转px值
     *
     * @param unit unit值
     * @return px值
     */
    public static int unit2Px(float unit) {
        return float2Int(AutoLayout.getUnitSize() * unit);
    }
}
