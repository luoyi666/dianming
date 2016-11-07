package com.example.luoyi.dianming1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoyi on 2016/10/25.
 */
public class chengji extends Activity {
    public  DBManager mgr=new DBManager(this);
    private ViewPager viewPager1;
    private PagerTabStrip pagerTabStrip;
    private List<View> list;
    private List<String> titleList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chengji);
        viewPager1=(ViewPager)this.findViewById(R.id.viewPager1);
        pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
        pagerTabStrip.setTabIndicatorColorResource(R.color.colorAccent);
        final View view1=getLayoutInflater().from(chengji.this).inflate(R.layout.shiyan,null);//定义各个布局界面
        final View view2=getLayoutInflater().from(chengji.this).inflate(R.layout.qimo,null);
        View view3=getLayoutInflater().from(chengji.this).inflate(R.layout.zongchengji,null);

        Button button23=(Button)view3.findViewById(R.id.button23);

        Button button27=(Button)view1.findViewById(R.id.button27);
        TextView test1=(TextView)view1.findViewById(R.id.textView10);//实验栏显示学生基本信息
        TextView test2=(TextView)view1.findViewById(R.id.textView11);
        TextView test3=(TextView)view1.findViewById(R.id.textView12);
        TextView test4=(TextView)view2.findViewById(R.id.textView4);//期末栏显示学生基本信息
        TextView test5=(TextView)view2.findViewById(R.id.textView5);
        TextView test6=(TextView)view2.findViewById(R.id.textView6);
        final TextView test7=(TextView)view3.findViewById(R.id.textView13); //显示期末总成绩
        Button button24=(Button)view2.findViewById(R.id.button24);
        if(Student.name=="罗艺")
        {
            Student s1=mgr.getStudentById("罗艺");
            test1.setText(s1.sno);//实验栏显示学生基本信息
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);//期末栏显示学生基本信息
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("罗艺");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("罗艺");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {  //录入期末考试成绩
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("罗艺");
                @Override
                public void onClick(View v) {
                        int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                        s2.score=b;
                        mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("罗艺");
                            public void onClick(View v) {
                                    int a=Integer.valueOf(edit.getText().toString());
                                    s2.test1=a;
                                    mgr.update1(s2);
                                    Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("罗艺");
                            public void onClick(View v) {
                                    int a = Integer.valueOf(edit.getText().toString());
                                    s2.test2 = a;
                                    mgr.update2(s2);
                                    Toast.makeText(chengji.this, "第二次实验成绩：" + a, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("罗艺");
                            public void onClick(View v) {
                                    int a = Integer.valueOf(edit.getText().toString());
                                    s2.test3 = a;
                                    mgr.update3(s2);
                                    Toast.makeText(chengji.this, "第三次实验成绩：" + a, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("罗艺");
                            public void onClick(View v) {
                                    int a = Integer.valueOf(edit.getText().toString());
                                    s2.test4 = a;
                                    mgr.update4(s2);
                                    Toast.makeText(chengji.this, "第四次实验成绩：" + a, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("罗艺");
                            public void onClick(View v) {
                                    int a = Integer.valueOf(edit.getText().toString());
                                    s2.test5 = a;
                                    mgr.update5(s2);
                                    Toast.makeText(chengji.this, "第五次实验成绩：" + a, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });

        }
        if(Student.name=="李杰")
        {
            Student s1=mgr.getStudentById("李杰");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("李杰");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                Student s4=mgr.getStudentById("李杰");
                @Override
                public void onClick(View v) {
                    int a=Integer.valueOf(test7.getText().toString());
                    s4.grade=a;
                    mgr.updateGrade(s4);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {  //点击事件，提交期末考试成绩
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("李杰");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("李杰");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("李杰");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("李杰");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("李杰");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("李杰");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="杨林")
        {
            Student s1=mgr.getStudentById("杨林");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("杨林");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("杨林");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("杨林");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("杨林");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("杨林");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("杨林");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("杨林");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("杨林");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="莫天金")
        {
            Student s1=mgr.getStudentById("莫天金");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("莫天金");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("莫天金");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("莫天金");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("莫天金");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("莫天金");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("莫天金");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("莫天金");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("莫天金");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="吴国平")
        {
            Student s1=mgr.getStudentById("吴国平");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("吴国平");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("吴国平");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("吴国平");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("吴国平");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("吴国平");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("吴国平");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("吴国平");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("吴国平");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="孙文斌")
        {
            Student s1=mgr.getStudentById("孙文斌");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("孙文斌");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("孙文斌");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("孙文斌");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("孙文斌");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("孙文斌");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("孙文斌");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("孙文斌");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("孙文斌");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="潘俊旭")
        {
            Student s1=mgr.getStudentById("潘俊旭");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("潘俊旭");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("潘俊旭");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("潘俊旭");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("潘俊旭");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("潘俊旭");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("潘俊旭");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("潘俊旭");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("潘俊旭");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="石佳磊")
        {
            Student s1=mgr.getStudentById("石佳磊");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("石佳磊");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("石佳磊");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("石佳磊");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("石佳磊");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("石佳磊");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("石佳磊");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("石佳磊");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("石佳磊");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="赵权")
        {
            Student s1=mgr.getStudentById("赵权");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("赵权");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("赵权");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("赵权");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("赵权");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("赵权");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("赵权");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("赵权");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("赵权");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="马鹏")
        {
            Student s1=mgr.getStudentById("马鹏");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("马鹏");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("马鹏");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("马鹏");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("马鹏");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("马鹏");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("马鹏");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("马鹏");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("马鹏");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        if(Student.name=="郭文浩")
        {
            Student s1=mgr.getStudentById("郭文浩");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            test4.setText(s1.sno);
            test5.setText(s1.sname);
            test6.setText(s1.sclass);
            Student s3=mgr.getGradeById("郭文浩");
            int sum=(int)((s3.sign1+s3.sign2)*0.1+(s3.test1+s3.test2+s3.test3+s3.test4+s3.test5)/5*0.3+s3.score*0.6);//计算期末总成绩
            test7.setText(String.valueOf(sum));//计算期末总成绩
            button23.setOnClickListener(new View.OnClickListener() {  //点击确定事件，跳转界面并录入数据库
                @Override
                public void onClick(View v) {
                    Student s3=mgr.getStudentById("郭文浩");
                    s3.grade=Integer.valueOf(test7.getText().toString());
                    mgr.updateGrade(s3);//录入期末总成绩
                    Intent intent=new Intent();
                    intent.setClass(chengji.this,OpenDoorActivity.class);
                    startActivity(intent);
                }
            });
            button24.setOnClickListener(new View.OnClickListener() {
                EditText edit2=(EditText)view2.findViewById(R.id.editText1);
                Student s2=mgr.getStudentById("郭文浩");
                @Override
                public void onClick(View v) {
                    int b=Integer.valueOf(edit2.getText().toString());
                    Toast.makeText(chengji.this,"您的期末成绩："+edit2.getText().toString(),Toast.LENGTH_SHORT).show();
                    s2.score=b;
                    mgr.updateScore(s2);
                }
            });
            Spinner mySpinner = (Spinner)view1.findViewById(R.id.spinner1);
            String[] mItems = getResources().getStringArray(R.array.languages);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    Button button26=(Button)findViewById(R.id.button26);
                    if(pos==0)
                    {

                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("郭文浩");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test1=a;
                                mgr.update1(s2);
                                Toast.makeText(chengji.this,"第一次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==1)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("郭文浩");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test2=a;
                                mgr.update2(s2);
                                Toast.makeText(chengji.this,"第二次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==2)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("郭文浩");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test3=a;
                                mgr.update3(s2);
                                Toast.makeText(chengji.this,"第三次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==3)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("郭文浩");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test4=a;
                                mgr.update4(s2);
                                Toast.makeText(chengji.this,"第四次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(pos==4)
                    {
                        Student.t1=1;
                        button26.setOnClickListener(new View.OnClickListener() {
                            EditText edit=(EditText)view1.findViewById(R.id.editText);
                            Student s2=mgr.getStudentById("郭文浩");
                            public void onClick(View v) {
                                int a=Integer.valueOf(edit.getText().toString());
                                s2.test5=a;
                                mgr.update5(s2);
                                Toast.makeText(chengji.this,"第五次实验成绩："+a,Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    String[] languages = getResources().getStringArray(R.array.languages);
                    Toast.makeText(chengji.this, "你选择了:"+languages[pos], Toast.LENGTH_SHORT).show();

                }
                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                }
            });
        /*下拉菜单弹出的内容选项触屏事件处理*/
            mySpinner.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event)
                {
                    // TODO Auto-generated method stub    
                    return false;
                }
            });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
            mySpinner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // TODO Auto-generated method stub    
                }
            });
        }
        button27.setOnClickListener(new View.OnClickListener() {  //返回主界面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(chengji.this,OpenDoorActivity.class);
                startActivity(intent);
            }
        });
        Button button25=(Button)view2.findViewById(R.id.button25); //返回主界面
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(chengji.this,OpenDoorActivity.class);
                startActivity(intent);
            }
        });
        list =new ArrayList<View>();
        list.add(view1);
        list.add(view2);
        list.add(view3);
        titleList=new ArrayList<String>();
        titleList.add("实验成绩");
        titleList.add("期末成绩");
        titleList.add("本学期总成绩");

        viewPager1.setAdapter(new MyAdapter());
    }
    public class MyAdapter extends PagerAdapter
    {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            ((ViewPager)container).removeView(list.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {

            SpannableStringBuilder ssb = new SpannableStringBuilder("  "+titleList.get(position));// space added before text  
            //  for  
            ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLACK);// 字体颜色设置为绿色  
            ssb.setSpan(fcs, 1, ssb.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);// 设置字体颜色  
            ssb.setSpan(new RelativeSizeSpan(1.2f), 1, ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            return ssb;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager)container).addView(list.get(position));
            return list.get(position);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

}
