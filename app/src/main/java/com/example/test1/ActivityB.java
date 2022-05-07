package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//导入MainActivity中声明的public static类型的变量以及函数，以便数据在各个Activity中共享
//其余功能模块与MainActivity基本相同
import static com.example.test1.MainActivity.mTVas;
import static com.example.test1.MainActivity.mTVlml;
import static com.example.test1.MainActivity.cycleList;
import static com.example.test1.MainActivity.update_activity_status;
import static com.example.test1.MainActivity.activity_Status;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity{

    private Button mBtnBAS;
    private Button mBtnBCS;
    private Button mBtnBF;
    private Button mBtnBDlg;

    private static final String TAGB = "Activity B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAGB, "onCreate()");
        setContentView(R.layout.activity_b);
        Log.d(TAGB, "Task id: " + getTaskId());

        mTVlml = (TextView) findViewById(R.id.mTVlml);
        mTVas = (TextView) findViewById(R.id.mTVas);

        mTVas.setMovementMethod(new ScrollingMovementMethod());
        mTVlml.setMovementMethod(new ScrollingMovementMethod());

        cycleList += "Activity B.onCreate()\n";
        mTVlml.setText(cycleList);

        mBtnBAS = (Button) findViewById(R.id.mBtnBAS);
        mBtnBAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityB.this, MainActivity.class);
                startActivity(i);
            }
        });

        mBtnBCS = (Button) findViewById(R.id.mBtnBCS);
        mBtnBCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityB.this, ActivityC.class);
                startActivity(i);
            }
        });

        mBtnBF = (Button) findViewById(R.id.mBtnBF);
        mBtnBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityB.this.finish();
            }
        });

        mBtnBDlg = (Button) findViewById(R.id.mBtnBDlg);
        mBtnBDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityB.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        cycleList += "Activity B.onStart()\n";
        Log.d(TAGB, "onStart()");
        mTVlml.setText(cycleList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        cycleList += "Activity B.onResume()\n";
        mTVlml.setText(cycleList);
        activity_Status[1] = "Activity B: Resumed\n";
        Log.d(TAGB, "onResume()");
        update_activity_status();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cycleList += "Activity B.onPause()\n";
        mTVlml.setText(cycleList);
        activity_Status[1] = "Activity B: Paused\n";
        Log.d(TAGB, "onPause()");
        update_activity_status();
    }

    @Override
    protected void onStop() {
        super.onStop();
        cycleList += "Activity B.onStop()\n";
        mTVlml.setText(cycleList);
        activity_Status[1] = "Activity B: Stopped\n";
        Log.d(TAGB, "onStop()");
        update_activity_status();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cycleList += "Activity B.onDestroy()\n";
        mTVlml.setText(cycleList);
        activity_Status[1] = "";
        Log.d(TAGB, "onDestroy()");
        update_activity_status();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAGB, "onRestart()");
        setContentView(R.layout.activity_b);

        mTVlml = (TextView) findViewById(R.id.mTVlml);
        mTVas = (TextView) findViewById(R.id.mTVas);

        mTVas.setMovementMethod(new ScrollingMovementMethod());
        mTVlml.setMovementMethod(new ScrollingMovementMethod());

        mBtnBAS = (Button) findViewById(R.id.mBtnBAS);
        mBtnBAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityB.this, MainActivity.class);
                startActivity(i);
            }
        });

        mBtnBCS = (Button) findViewById(R.id.mBtnBCS);
        mBtnBCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityB.this, ActivityC.class);
                startActivity(i);
            }
        });

        mBtnBF = (Button) findViewById(R.id.mBtnBF);
        mBtnBF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityB.this.finish();
            }
        });

        mBtnBDlg = (Button) findViewById(R.id.mBtnBDlg);
        mBtnBDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityB.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }
}
