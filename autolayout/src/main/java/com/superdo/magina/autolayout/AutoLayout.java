package com.superdo.magina.autolayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.superdo.magina.autolayout.util.NotichUtil;

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

    private static int baseHeight, baseWidth; // 基础宽高所占单位数
    private static int unitHeightExtra, unitWidthExtra; // 额外宽高所占单位数
    private static int unitHeight, unitWidth; // 总宽高所占单位数
    private static int height, width; // 手机屏幕宽高
    private static int heightExtra, widthExtra; // 额外的宽高像素
    private static float unitSize; // 一个单位所占像素

    private static ScreenOrientation screenOrientation = ScreenOrientation.PORTRAIT;

    /**
     * 初始化
     *
     * @param context 上下文环境
     * @param width   宽
     * @param height  高
     */
    public static void init(Context context, int width, int height) {
        mContext = context;
        baseHeight = height;
        baseWidth = width;

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

        // fix:1 华为手机有刘海的情况下宽高只能获取刘海以外大小
        height = height + NotichUtil.getHwNotchSize(mContext)[1];
    }

    private static void countUnits() {
        unitSize = Math.min(height * 1f / baseHeight, width * 1f / baseWidth);
        int standardWidth = (int) ((unitSize * baseWidth) + .5f);
        int standardHeight = (int) ((unitSize * baseHeight) + .5f);
        heightExtra = (height - standardHeight);
        widthExtra = (width - standardWidth);

        unitHeight = (int) (height / unitSize + .5f);
        unitWidth = (int) (width / unitSize + .5f);

        unitHeightExtra = unitHeight - baseHeight;
        unitWidthExtra = unitWidth - baseWidth;
    }

    /**
     * 获取上下文环境
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 获取基准高度
     */
    public static int getBaseHeight() {
        return baseHeight;
    }

    /**
     * 获取基准宽度
     */
    public static int getBaseWidth() {
        return baseWidth;
    }

    /**
     * 获取额外高度所占单元
     */
    public static int getUnitHeightExtra() {
        return unitHeightExtra;
    }

    /**
     * 获取额外宽度所占单元
     */
    public static int getUnitWidthExtra() {
        return unitWidthExtra;
    }

    /**
     * 获取设备高度所占单元
     */
    public static int getUnitHeight() {
        return unitHeight;
    }

    /**
     * 获取设备宽度所占单元
     */
    public static int getUnitWidth() {
        return unitWidth;
    }

    /**
     * 获取设备高度值
     */
    public static int getHeight() {
        return height;
    }

    /**
     * 获取设备宽度值
     */
    public static int getWidth() {
        return width;
    }

    /**
     * 获取额外高度值
     */
    public static int getHeightExtra() {
        return heightExtra;
    }

    /**
     * 获取额外宽度值
     */
    public static int getWidthExtra() {
        return widthExtra;
    }

    /**
     * 获取一个单元大小
     */
    public static float getUnitSize() {
        return unitSize;
    }

    /**
     * 获取屏幕方向(水平/竖直)
     */
    public static ScreenOrientation getScreenOrientation() {
        return screenOrientation;
    }

    public static boolean isPortrait() {
        return screenOrientation == ScreenOrientation.PORTRAIT;
    }

    public static float getWidthHeightRatio() {
        return isPortrait() ? width * 1f / height : height * 1f / width;
    }

    /**
     * 设置屏幕方向
     */
    public static void setScreenOrientation(ScreenOrientation screenOrientation) {
        AutoLayout.screenOrientation = screenOrientation;
    }

    public enum ScreenOrientation {
        PORTRAIT, LANDSCAPE
    }

}
