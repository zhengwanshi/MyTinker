package com.example.mytinker.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;


/**
 * Created by renzhiqiang on 17/4/27.
 *
 * @functon 对Tinker的所有api做一层封装
 */
public class TinkerManager {

    private static boolean isInstalled = false;

    private static ApplicationLike mAppLike;

   // private static CustomPatchListener mPatchListener;

    /**
     * 完成Tinker的初始化
     *
     * @param applicationLike
     */
    public static void installTinker(ApplicationLike applicationLike) {
        mAppLike = applicationLike;
        if (isInstalled) {
            return;
        }

//        mPatchListener = new CustomPatchListener(getApplicationContext());
//
//        LoadReporter loadReporter = new DefaultLoadReporter(getApplicationContext());
//        PatchReporter patchReporter = new DefaultPatchReporter(getApplicationContext());
//
//        AbstractPatch upgradePatchProcessor = new UpgradePatch();
//
//        TinkerInstaller.install(applicationLike,
//                loadReporter,
//                patchReporter,
//                mPatchListener,
//                CustomResultService.class,
//                upgradePatchProcessor); //完成Tinker初始化

        TinkerInstaller.install(mAppLike);
        isInstalled = true;
    }

    //完成Patch文件的加载
    public static void loadPatch(String path) {
        if (Tinker.isTinkerInstalled()) {
           // mPatchListener.setCurrentMD5(md5Value);
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), path);
        }
    }

    //通过ApplicationLike获取Context
    private static Context getApplicationContext() {
        if (mAppLike != null) {
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
