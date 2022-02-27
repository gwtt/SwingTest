package org.calculator.util;

import java.awt.*;

public class Const {
    public static final int FRAME_W = 300;
    public static final int FRAME_H = 300;
    public static final int SCREEN_W = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_H = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final int FRAME_X = (SCREEN_W - FRAME_W)/2;
    public static final int FRAME_Y = (SCREEN_H - FRAME_H)/2;
    public static final String title = "计算器";
    public static final String[] btn_text = {"%","CE","C","回退","1/x","x^2","sqrt","/","7","8","9","*","4","5","6","-","1","2","3","+","取反","0",".","="};
}
