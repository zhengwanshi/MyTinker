package com.example.mytinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.mytinker.tinker.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apk";
    private String mPatchDir;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mPatchDir = getExternalCacheDir().getAbsolutePath()+"/tpatch/";
        //创建文件夹
        File file = new File(mPatchDir);
        if (file == null ||file.exists()){
            file.mkdir();
        }
        
    }
    public void loadPatch(View view){
        TinkerManager.loadPatch(getPatchName());
    }

    private String getPatchName() {
        Log.e(TAG, "getPatchName: "+mPatchDir.concat("zhengwanshi").concat(FILE_END));
        return mPatchDir.concat("zhengwanshi").concat(FILE_END);
    }
}
