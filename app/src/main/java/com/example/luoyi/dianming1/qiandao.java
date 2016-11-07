package com.example.luoyi.dianming1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by luoyi on 2016/10/23.
 */
public class qiandao extends Activity{
    public  DBManager mgr=new DBManager(this);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qiandao);
        Button button2=(Button)findViewById(R.id.button22);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setClass(qiandao.this,OpenDoorActivity.class);
                startActivity(intent);
            }
        });
        if(Student.name=="罗艺")
        {
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            final Button button23=(Button)findViewById(R.id.button23);
            Student s1=mgr.getStudentById("罗艺");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("罗艺");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("罗艺");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("李杰");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("李杰");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("李杰");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("杨林");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("杨林");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("杨林");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("莫天金");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("莫天金");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("莫天金");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("吴国平");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("吴国平");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("吴国平");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("孙文斌");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("孙文斌");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("孙文斌");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("潘俊旭");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("潘俊旭");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("潘俊旭");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("赵权");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("赵权");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("赵权");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("石佳磊");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("石佳磊");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("石佳磊");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("马鹏");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("马鹏");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("马鹏");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
            TextView test1=(TextView)findViewById(R.id.textView10);
            TextView test2=(TextView)findViewById(R.id.textView11);
            TextView test3=(TextView)findViewById(R.id.textView12);
            Student s1=mgr.getStudentById("郭文浩");
            test1.setText(s1.sno);
            test2.setText(s1.sname);
            test3.setText(s1.sclass);
            final Button button23=(Button)findViewById(R.id.button23);
            Spinner mySpinner = (Spinner)findViewById(R.id.spinner2);
            String[] mItems = getResources().getStringArray(R.array.lan);
// 建立Adapter并且绑定数据源
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,mItems);
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//绑定 Adapter到控件
            mySpinner.setAdapter(adapter);
            mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,View view,int pos,long id) {
                    if(pos==0)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("郭文浩");
                            @Override
                            public void onClick(View v) {
                                click(s2);
                            }
                        });
                    }
                    if(pos==1)
                    {
                        button23.setOnClickListener(new View.OnClickListener() {
                            Student s2=mgr.getStudentById("郭文浩");
                            @Override
                            public void onClick(View v) {
                                click1(s2);
                            }
                        });
                    }


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
    }
    public void click(Student s2)
    {
        RadioGroup rp=(RadioGroup)findViewById(R.id.radioGroup1);
        for(int i=0;i<rp.getChildCount();i++)
        {
            RadioButton r=(RadioButton)rp.getChildAt(i);
            if(r.isChecked())
            {
                if(i==0)
                {
                    s2.sign1=30;
                    mgr.update(s2);
                    Toast.makeText(qiandao.this,"您选择了：迟到！",Toast.LENGTH_SHORT).show();
                }
                if(i==1)
                {
                    s2.sign1=40;
                    mgr.update(s2);
                    Toast.makeText(qiandao.this,"您选择了：请假！",Toast.LENGTH_SHORT).show();
                }
                if(i==2)
                {
                    s2.sign1=0;
                    mgr.update(s2);
                    Toast.makeText(qiandao.this,"您选择了：旷课！",Toast.LENGTH_SHORT).show();
                }
                if(i==3)
                {
                    s2.sign1=50;
                    mgr.update(s2);
                    Toast.makeText(qiandao.this,"您选择了：全勤！",Toast.LENGTH_SHORT).show();
                }
                if(i==4)
                {
                    s2.sign1=30;
                    mgr.update(s2);
                    Toast.makeText(qiandao.this,"您选择了：早退！",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    public void click1(Student s2)
    {
        RadioGroup rp=(RadioGroup)findViewById(R.id.radioGroup1);
        for(int i=0;i<rp.getChildCount();i++)
        {
            RadioButton r=(RadioButton)rp.getChildAt(i);
            if(r.isChecked())
            {
                if(i==0)
                {
                    s2.sign2=30;
                    mgr.updateSign2(s2);
                    Toast.makeText(qiandao.this,"您选择了：迟到！",Toast.LENGTH_SHORT).show();
                }
                if(i==1)
                {
                    s2.sign2=40;
                    mgr.updateSign2(s2);
                    Toast.makeText(qiandao.this,"您选择了：请假！",Toast.LENGTH_SHORT).show();
                }
                if(i==2)
                {
                    s2.sign2=0;
                    mgr.updateSign2(s2);
                    Toast.makeText(qiandao.this,"您选择了：旷课！",Toast.LENGTH_SHORT).show();
                }
                if(i==3)
                {
                    s2.sign2=50;
                    mgr.updateSign2(s2);
                    Toast.makeText(qiandao.this,"您选择了：全勤！",Toast.LENGTH_SHORT).show();
                }
                if(i==4)
                {
                    s2.sign2=30;
                    mgr.updateSign2(s2);
                    Toast.makeText(qiandao.this,"您选择了：早退！",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
