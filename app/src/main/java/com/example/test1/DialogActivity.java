package com.example.test1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {
    private Button mBtnbDLG;    //声明按钮变量
    private static final String TAGD = "Activity DLG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAGD, "onCreate()");
        setContentView(R.layout.activity_dialog);
        Log.d(TAGD, "Task id: " + getTaskId());    //获得当前Activity所在的任务栈ID并通过Log显示

        //找到对应的控件并为其设置点击事件
        mBtnbDLG = (Button) findViewById(R.id.mBtnbDLG);
        mBtnbDLG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); //等价于点击手机上的返回键，旨在返回调用DialogActivity的Activity
            }
        });
    }
}
