package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//导入MainActivity中声明的public static类型的变量以及函数，以便数据在各个Activity中共享
//其余功能模块与MainActivity基本相同
import static com.example.test1.MainActivity.mTVas;
import static com.example.test1.MainActivity.mTVlml;
import static com.example.test1.MainActivity.cycleList;
import static com.example.test1.MainActivity.update_activity_status;
import static com.example.test1.MainActivity.activity_Status;

public class ActivityC extends AppCompatActivity {

    private Button mBtnCAS;
    private Button mBtnCBS;
    private Button mBtnCF;
    private Button mBtnCDlg;

    private static final String TAGC = "Activity C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAGC, "onCreate()");
        setContentView(R.layout.activity_c);
        Log.d(TAGC, "Task id: " + getTaskId());

        mTVlml = (TextView) findViewById(R.id.mTVlml);
        mTVas = (TextView) findViewById(R.id.mTVas);

        mTVas.setMovementMethod(new ScrollingMovementMethod());
        mTVlml.setMovementMethod(new ScrollingMovementMethod());

        cycleList += "Activity C.onCreate()\n";
        mTVlml.setText(cycleList);

        mBtnCAS = (Button) findViewById(R.id.mBtnCAS);
        mBtnCAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityC.this, MainActivity.class);
                startActivity(i);
            }
        });

        mBtnCBS = (Button) findViewById(R.id.mBtnCBS);
        mBtnCBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityC.this, ActivityB.class);
                startActivity(i);
            }
        });

        mBtnCF = (Button) findViewById(R.id.mBtnCF);
        mBtnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityC.this.finish();
            }
        });

        mBtnCDlg = (Button) findViewById(R.id.mBtnCDlg);
        mBtnCDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityC.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAGC, "onStart()");
        cycleList += "Activity C.onStart()\n";
        mTVlml.setText(cycleList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAGC, "onResume()");
        cycleList += "Activity C.onResume()\n";
        mTVlml.setText(cycleList);
        activity_Status[2] = "Activity C: Resumed\n";
        update_activity_status();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAGC, "onPause()");
        cycleList += "Activity C.onPause()\n";
        mTVlml.setText(cycleList);
        activity_Status[2] = "Activity C: Paused\n";
        update_activity_status();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAGC, "onStop()");
        cycleList += "Activity C.onStop()\n";
        mTVlml.setText(cycleList);
        activity_Status[2] = "Activity C: Stopped\n";
        update_activity_status();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAGC, "onDestroy()");
        cycleList += "Activity C.onDestroy()\n";
        mTVlml.setText(cycleList);
        activity_Status[2] = "";
        update_activity_status();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAGC, "onRestart()");
        setContentView(R.layout.activity_c);

        mTVlml = (TextView) findViewById(R.id.mTVlml);
        mTVas = (TextView) findViewById(R.id.mTVas);

        mTVas.setMovementMethod(new ScrollingMovementMethod());
        mTVlml.setMovementMethod(new ScrollingMovementMethod());

        cycleList += "Activity C.onCreate()\n";
        mTVlml.setText(cycleList);

        mBtnCAS = (Button) findViewById(R.id.mBtnCAS);
        mBtnCAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityC.this, MainActivity.class);
                startActivity(i);
            }
        });

        mBtnCBS = (Button) findViewById(R.id.mBtnCBS);
        mBtnCBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityC.this, ActivityB.class);
                startActivity(i);
            }
        });

        mBtnCF = (Button) findViewById(R.id.mBtnCF);
        mBtnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityC.this.finish();
            }
        });

        mBtnCDlg = (Button) findViewById(R.id.mBtnCDlg);
        mBtnCDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityC.this, DialogActivity.class);
                startActivity(i);
            }
        });
    }
}
