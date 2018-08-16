package com.soz.speech.asr.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author: zhushaolong@baidu.com
 * Time: 16/08/2018 2:03 PM
 * Description: PropUtils
 */
public final class PropUtils {
    private final static String TAG = PropUtils.class.getSimpleName();

    private PropUtils() {
    }

    public String readProp(String param) {
        BufferedReader bufferedReader = null;
        try {
            Process proc = Runtime.getRuntime().exec("getprop " + param);
            InputStreamReader inputStreamReader = new InputStreamReader(proc.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
