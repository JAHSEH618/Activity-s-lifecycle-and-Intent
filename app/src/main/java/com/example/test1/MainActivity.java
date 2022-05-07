package com.example.test1;

//库导入

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mBtnDlg;
    private Button mBtnAF;
    private Button mBtnStartB;
    private Button mBtnCS;

    public static TextView mTVas;
    public static TextView mTVlml;     //控件声明

    public static String cycleList = "";
    public static String status = "";
    public static String[] activity_Status = new String[3];      //三个Activity共有变量的声明

    private static final String TAG = "Activity A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Task id: " + getTaskId());             //获得当前Activity所在的任务栈ID并通过Log显示

        mTVas = (TextView) findViewById(R.id.mTVas);
        mTVlml = (TextView) findViewById(R.id.mTVlml);          //在控件库中通过ID找到对应控件

        mTVas.setMovementMethod(new ScrollingMovementMethod()); //设置滚动窗口
        mTVlml.setMovementMethod(new ScrollingMovementMethod());

        cycleList += "Activity A.onCreate()\n";
        mTVlml.setText(cycleList);                              //在TextView mTVlml中显示Activity的生命周期


        mBtnStartB = (Button) findViewById(R.id.mBtnBS);
        //设置按钮事件
        mBtnStartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置Activity转跳Intent并通过startActivity()函数开启Intent，实现转跳
                Intent data = new Intent(MainActivity.this, ActivityB.class);
                startActivity(data);
            }
        });

        mBtnCS = (Button) findViewById(R.id.mBtnCS);
        mBtnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityC.class);
                startActivity(i);
            }
        });

        mBtnAF = (Button) findViewById(R.id.mBtnAF);
        mBtnAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }   //调用this.finish()函数来实现Activity的结束
        });

        mBtnDlg = (Button) findViewById(R.id.mBtnDlg);
        mBtnDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }

    public static void update_activity_status() {
        //用于在每次Activity的当前状态改变后进行更新
        status = "";
        for (int i = 0; i < 3; i++) {
            if (activity_Status[i] != null)
                status += activity_Status[i];  //activity_Status[i]存储的是Activity A、B、C的当前生命状态
            mTVas.setText(status);
        }
    }

    @Override
    protected void onStart() {
        //Activity调用onStart()，将调用记录到mTVlml中，同时通过Log.d显示
        super.onStart();
        cycleList += "Activity A.onStart()\n";
        mTVlml.setText(cycleList);
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        //Activity调用onResume()，将调用记录到mTVlml中，同时通过Log.d显示
        //该函数被调用后，Activity的状态改变，需要调用update_activity_status()以更新并记录到mTVas中
        super.onResume();
        cycleList += "Activity A.onResume()\n";
        mTVlml.setText(cycleList);
        activity_Status[0] = "Activity A: Resumed\n";
        Log.d(TAG, "onResume()");
        update_activity_status();
    }

    @Override
    protected void onPause() {
        //Activity调用onPause()，将调用记录到mTVlml中，同时通过Log.d显示
        //该函数被调用后，Activity的状态改变，需要调用update_activity_status()以更新并记录到mTVas中
        super.onPause();
        cycleList += "Activity A.onPause()\n";
        mTVlml.setText(cycleList);
        activity_Status[0] = "Activity A: Paused\n";
        Log.d(TAG, "onPause()");
        update_activity_status();
    }

    @Override
    protected void onStop() {
        //Activity调用onStop()，将调用记录到mTVlml中，同时通过Log.d显示
        //该函数被调用后，Activity的状态改变，需要调用update_activity_status()以更新并记录到mTVas中
        super.onStop();
        cycleList += "Activity A.onStop()\n";
        mTVlml.setText(cycleList);
        activity_Status[0] = "Activity A: Stopped\n";
        Log.d(TAG, "onStop()");
        update_activity_status();
    }

    @Override
    protected void onDestroy() {
        //Activity调用onResume()，将调用记录到mTVlml中，同时通过Log.d显示
        //该函数被调用后，Activity的状态改变，需要调用update_activity_status()以更新并记录到mTVas中
        super.onDestroy();
        cycleList += "Activity A.onDestroy()\n";
        mTVlml.setText(cycleList);
        activity_Status[0] = "";
        Log.d(TAG, "onDestroy()");
        update_activity_status();
    }

    @Override
    protected void onRestart() {
        //Activity调用onRestart()，将调用记录到mTVlml中，同时通过Log.d显示
        //重新加载界面（类似onCreate()）
        super.onRestart();
        Log.d(TAG, "onRestart()");
        setContentView(R.layout.activity_main);

        mTVas = (TextView) findViewById(R.id.mTVas);
        mTVlml = (TextView) findViewById(R.id.mTVlml);

        mTVas.setMovementMethod(new ScrollingMovementMethod());
        mTVlml.setMovementMethod(new ScrollingMovementMethod());

        cycleList += "Activity A.onCreate()\n";
        mTVlml.setText(cycleList);

        mBtnStartB = (Button) findViewById(R.id.mBtnBS);
        mBtnStartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent(MainActivity.this, ActivityB.class);
                startActivity(data);
            }
        });

        mBtnCS = (Button) findViewById(R.id.mBtnCS);
        mBtnCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityC.class);
                startActivity(i);
            }
        });

        mBtnAF = (Button) findViewById(R.id.mBtnAF);
        mBtnAF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

        mBtnDlg = (Button) findViewById(R.id.mBtnDlg);
        mBtnDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }
}