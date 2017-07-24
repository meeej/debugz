package com.jimdoesnotgym.ms076.logs_android;

import android.util.Log;

import com.jimdoesnotgym.ms076.logs_android.Exception.InvalidLogTypeException;

public class Debugz {

    private static boolean mIsEnable;

    public static void setEnable(boolean isEnable){
        mIsEnable = isEnable;
    }

    public enum Type{
        V, E, I, W, D
    }

    public static void out(String tag, String message){
        if(mIsEnable){
            Log.d(tag, message);
        }
    }

    public static void out(String tag, String message, boolean showStackTrace){
        if(mIsEnable){
            Log.d(tag, message);
        }
        if(showStackTrace){
            new Exception().printStackTrace();
        }
    }

    public static void out(String tag, String message, boolean showStackTrace, Type type) throws InvalidLogTypeException {
        if(mIsEnable){
            switch (type){
                case V:
                    Log.v(tag, message);
                    break;

                case E:
                    Log.e(tag, message);
                    break;

                case I:
                    Log.i(tag, message);
                    break;

                case W:
                    Log.w(tag, message);
                    break;

                case D:
                    Log.d(tag, message);
                    break;

                default:
                    throw new InvalidLogTypeException("Invalid Log Type");
            }

        }
        if(showStackTrace){
            new Exception().printStackTrace();
        }
    }

    public static StackTraceElement[] getStackTraceElements(){
        return Thread.currentThread().getStackTrace();
    }
}
