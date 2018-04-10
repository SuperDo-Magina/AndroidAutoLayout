package com.superdo.magina.autolayout.util;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
            params = new RelativeLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = (int) (w * unit);
        }

        if (h != 0) {
            params.height = (int) (h * unit);
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
            params = new RelativeLayout.LayoutParams(0, 0);
        }

        float unit = AutoLayout.getUnitSize();
        if (w != 0) {
            params.width = (int) (w * unit);
        }

        if (h != 0) {
            params.height = (int) (h * unit);
        }
        params.setMargins((int) (ml * unit), (int) (mt * unit), (int) (mr * unit), (int) (mb * unit));
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
            params.width = (int) (w * unit);
        }

        if (h != 0) {
            params.height = (int) (h * unit);
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
            params.width = (int) (w * unit);
        }

        if (h != 0) {
            params.height = (int) (h * unit);
        }
        params.setMargins((int) (ml * unit), (int) (mt * unit), (int) (mr * unit), (int) (mb * unit));
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
            params.width = (int) (w * unit);
        }

        if (h != 0) {
            params.height = (int) (h * unit);
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
            params.width = (int) (w * unit);
        }

        if (h != 0) {
            params.height = (int) (h * unit);
        }
        params.setMargins((int) (ml * unit), (int) (mt * unit), (int) (mr * unit), (int) (mb * unit));
        v.setLayoutParams(params);
    }

    public static float getUnitSize(int i) {
        return i * AutoLayout.getUnitSize();
    }

    public static float getUnitSize(float i) {
        return i * AutoLayout.getUnitSize();
    }
}
