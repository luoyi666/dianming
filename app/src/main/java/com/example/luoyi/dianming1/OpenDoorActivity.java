package com.example.luoyi.dianming1;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class OpenDoorActivity extends Activity {

    public  DBManager mgr;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        mgr=new DBManager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);
        Button button3=(Button)findViewById(R.id.button3);
        Button button4=(Button)findViewById(R.id.button4);
        Button button5=(Button)findViewById(R.id.button5);
        Button button6=(Button)findViewById(R.id.button6);
        Button button7=(Button)findViewById(R.id.button7);
        Button button8=(Button)findViewById(R.id.button8);
        Button button9=(Button)findViewById(R.id.button9);
        Button button10=(Button)findViewById(R.id.button10);
        Button button11=(Button)findViewById(R.id.button11);
        Button button=(Button)findViewById(R.id.button);
        Button button12=(Button)findViewById(R.id.button12);
        Button button13=(Button)findViewById(R.id.button13);
        Button button14=(Button)findViewById(R.id.button14);
        Button button15=(Button)findViewById(R.id.button15);
        Button button16=(Button)findViewById(R.id.button16);
        Button button17=(Button)findViewById(R.id.button17);
        Button button18=(Button)findViewById(R.id.button18);
        Button button19=(Button)findViewById(R.id.button19);
        Button button20=(Button)findViewById(R.id.button20);
        Button button21=(Button)findViewById(R.id.button21);
        Button button22=(Button)findViewById(R.id.button22);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="罗艺";
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="罗艺";

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="李杰";
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="李杰";

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="杨林";
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="杨林";

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="莫天金";
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="莫天金";

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="吴国平";
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="吴国平";

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="孙文斌";
            }
        });
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="孙文斌";

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="潘俊旭";
            }
        });
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="潘俊旭";

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="赵权";
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="赵权";

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="石佳磊";
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="石佳磊";

            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="马鹏";
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="马鹏";

            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,qiandao.class);
                startActivity(intent);
                Student.name="郭文浩";
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OpenDoorActivity.this,chengji.class);
                startActivity(intent);
                Student.name="郭文浩";

            }
        });
    }
}
