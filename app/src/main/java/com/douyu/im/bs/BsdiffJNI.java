package com.douyu.im.bs;


public class BsdiffJNI {
    static {
        System.loadLibrary("BsdiffJNI");
    }

    public static native int applyPatchToOldApk(String oldapk_filepath, String newapk_savepath, String patchpath);

}
