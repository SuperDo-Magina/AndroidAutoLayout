package com.superdo.magina.autolayout.util;

import android.content.Context;

import java.lang.reflect.Method;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/7/16 下午3:36
 *      des    刘海工具
 *
 * </pre>
 */
public class NotichUtil {

    /**
     * 是否有华为刘海
     */
    public static boolean hasHwNotchInScreen(Context context) {

        try {

            ClassLoader cl = context.getClassLoader();

            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");

            Method get = HwNotchSizeUtil.getMethod("hasNotchInScreen");

            return (boolean) get.invoke(HwNotchSizeUtil);

        } catch (Exception e) {

            return false;
        }
    }

    /**
     * 获取华为刘海宽高
     */
    public static int[] getHwNotchSize(Context context) {

        int[] ret = new int[]{0, 0};

        try {

            ClassLoader cl = context.getClassLoader();

            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");

            Method get = HwNotchSizeUtil.getMethod("getNotchSize");

            return (int[]) get.invoke(HwNotchSizeUtil);

        } catch (Exception e) {

            return ret;
        }
    }
}
