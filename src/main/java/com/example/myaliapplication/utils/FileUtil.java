package com.example.myaliapplication.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 文件工具类，读取assets目录下的jason文件，转化为String
 */

public class FileUtil {

    public static String readFile(String fileName, Context context) {
        String jsonString = "";
        try {
            InputStreamReader isr = new InputStreamReader(context.getAssets().open(fileName), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            isr.close();
            jsonString = builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return jsonString;
    }
}
