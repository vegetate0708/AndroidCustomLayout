package com.zxf.androidcustomlayout.Animator;

/**
 * Created by Administrator on 2016/9/1.
 */
public class CharecterEvaluator implements android.animation.TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt  = (int)startValue;
        int endInt = (int)endValue;
        int curInt = (int)(startInt + fraction *(endInt - startInt));
        char result = (char)curInt;
        return result;
    }
}
