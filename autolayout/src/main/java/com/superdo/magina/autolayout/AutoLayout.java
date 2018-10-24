package com.superdo.magina.autolayout;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
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

    private final static String TAG = "AutoLayout";

    private AutoLayout() {
    }

    private static int baseHeight, baseWidth; // 基础宽高所占单位数
    private static int unitHeightExtra, unitWidthExtra; // 额外宽高所占单位数
    private static int unitHeight, unitWidth; // 总宽高所占单位数
    private static int phoneHeight = -1, phoneWidth = -1; // 手机屏幕宽高
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
        baseHeight = height;
        baseWidth = width;

        countPhoneHighWidth(context);
        countUnits();
    }

    /**
     * 计算手机宽高
     *
     * @param context
     */
    private static void countPhoneHighWidth(Context context) {

        if (phoneHeight > 0 && phoneWidth > 0) return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            DisplayMetrics metric = new DisplayMetrics();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRealMetrics(metric);

            phoneHeight = metric.heightPixels;
            phoneWidth = metric.widthPixels;
        } else {
            Point p = new Point();
            ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(p);

            phoneHeight = p.y;
            phoneWidth = p.x;
        }

        if (phoneHeight < phoneWidth) {
            phoneHeight = phoneHeight + phoneWidth;
            phoneWidth = phoneHeight - phoneWidth;
            phoneHeight = phoneHeight - phoneWidth;
        }

        // fix:1 华为手机有刘海的情况下宽高只能获取刘海以外大小
        phoneHeight = phoneHeight + NotichUtil.getHwNotchSize(context)[1];
    }

    /**
     * 设置UI图宽高
     *
     * @param h 高
     * @param w 宽
     */
    public static void setUISize(int h, int w) {

        if (baseHeight != h || baseWidth != w) {
            baseWidth = h;
            baseWidth = w;
            countUnits();
        }
    }

    /**
     * 设置UI图宽高
     *
     * @param h 高
     * @param w 宽
     */
    public synchronized static void setUISizeAndScreenOrientation(int h, int w, ScreenOrientation screenOrientation) {

        if (baseHeight != h || baseWidth != w || AutoLayout.screenOrientation != screenOrientation) {
            baseWidth = h;
            baseWidth = w;
            AutoLayout.screenOrientation = screenOrientation;
            countUnits();
        }
    }

    /**
     * 设置手机宽高(单位像素,防止特殊机型特殊计算方法)
     *
     * @param h 高（像素）
     * @param w 宽（像素）
     */
    public static void setPhoneSize(int h, int w) {

        if (phoneHeight != h || phoneWidth != w) {
            phoneHeight = h;
            phoneWidth = w;
            countUnits();
        }
    }

    /**
     * 设置屏幕方向
     */
    public synchronized static void setScreenOrientation(ScreenOrientation screenOrientation) {
        if (AutoLayout.screenOrientation != screenOrientation) {
            AutoLayout.screenOrientation = screenOrientation;
            countUnits();
        }
    }

    private static void countUnits() {

        if (baseHeight <= 0 || baseWidth <= 0) return;

        int h, w;
        if (screenOrientation == ScreenOrientation.PORTRAIT) {
            h = phoneHeight;
            w = phoneWidth;
        } else {
            h = phoneWidth;
            w = phoneHeight;
        }

        unitSize = Math.min(h * 1f / baseHeight, w * 1f / baseWidth);
        int standardWidth = (int) ((unitSize * baseWidth) + .5f);
        int standardHeight = (int) ((unitSize * baseHeight) + .5f);

        heightExtra = (h - standardHeight);
        widthExtra = (w - standardWidth);

        unitHeight = (int) (h / unitSize + .5f);
        unitWidth = (int) (w / unitSize + .5f);

        unitHeightExtra = unitHeight - baseHeight;
        unitWidthExtra = unitWidth - baseWidth;

        Log.v(TAG, "phoneHeight:" + phoneHeight + "\n" +
                "phoneWidth:" + phoneWidth + "\n" +
                "unitSize:" + unitSize + "\n" +
                "baseHeight:" + baseHeight + "\n" +
                "baseWidth:" + baseWidth + "\n" +
                "unitHeight:" + unitHeight + "\n" +
                "unitWidth:" + unitWidth + "\n");
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
    public static int getPhoneHeight() {
        return phoneHeight;
    }

    /**
     * 获取设备宽度值
     */
    public static int getPhoneWidth() {
        return phoneWidth;
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
        return isPortrait() ? phoneWidth * 1f / phoneHeight : phoneHeight * 1f / phoneWidth;
    }

    public enum ScreenOrientation {
        PORTRAIT, LANDSCAPE
    }

}
