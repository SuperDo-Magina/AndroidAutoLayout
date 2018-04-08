package com.superdo.magina.autolayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * <pre>
 *
 *           ~●█〓██▄▄▄▄▄▄▄▄▄▄▄ ●　●　●
 *          ▄▅█████████████▅▄▃▂
 *          ██████████████████████
 *          ◥⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲⊙▲◤
 *
 *          author LYB
 *          time   18/4/4 下午5:47
 *          des    自动适配布局
 *
 * </pre>
 */

public class AutoLayout {

    private AutoLayout() {
    }

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    private static int unitHeight, unitWidth; // 基础宽高所占单位数
    private static int unitHeightExtra, unitWidthExtra; // 额外宽高所占单位数
    private static int unitHeightTotal, unitWidthTotal; // 总宽高所占单位数
    private static int height, width; // 手机屏幕宽高
    private static int heightExtra, widthExtra; // 额外的宽高像素
    private static float unitSize; // 一个单位所占像素

    private static ScreenOrientation screenOrientation = ScreenOrientation.PORTRAIT;

    public static void init(Context context, int width, int height) {
        mContext = context;
        unitHeight = height;
        unitWidth = width;

        countHighWidth();
        countUnits();
    }

    private static void countHighWidth() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics metric = new DisplayMetrics();
            ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(metric);

            height = metric.heightPixels;
            width = metric.widthPixels;
        } else {
            Point p = new Point();
            ((WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(p);

            height = p.y;
            width = p.x;
        }

        if (height < width) {
            int temp = height;
            height = width;
            width = temp;
        }
    }

    private static void countUnits() {
        unitSize = Math.min(height * 1f / unitHeight, width * 1f / unitWidth);
//        textPxUnit = unitSize * 3;
        int standardWidth = (int) ((unitSize * unitWidth) + .5f);
        int standardHeight = (int) ((unitSize * unitHeight) + .5f);
        heightExtra = (height - standardHeight);
        widthExtra = (width - standardWidth);

        unitHeightTotal = (int) (height / unitSize + .5f);
        unitWidthTotal = (int) (width / unitSize + .5f);

        unitHeightExtra = unitHeightTotal - unitHeight;
        unitWidthExtra = unitWidthTotal - unitWidth;
    }

    public static Context getContext() {
        return mContext;
    }

    public static int getUnitHeight() {
        return unitHeight;
    }

    public static int getUnitWidth() {
        return unitWidth;
    }

    public static int getUnitHeightExtra() {
        return unitHeightExtra;
    }

    public static int getUnitWidthExtra() {
        return unitWidthExtra;
    }

    public static int getUnitHeightTotal() {
        return unitHeightTotal;
    }

    public static int getUnitWidthTotal() {
        return unitWidthTotal;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeightExtra() {
        return heightExtra;
    }

    public static int getWidthExtra() {
        return widthExtra;
    }

    public static float getUnitSize() {
        return unitSize;
    }

    public static ScreenOrientation getScreenOrientation() {
        return screenOrientation;
    }

    public static void setScreenOrientation(ScreenOrientation screenOrientation) {
        AutoLayout.screenOrientation = screenOrientation;
    }

    public enum ScreenOrientation {
        PORTRAIT, LANDSCAPE
    }
}
