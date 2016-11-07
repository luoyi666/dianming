package com.example.luoyi.dianming1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by luoyi on 2016/10/26.
 */
public class DBManager {
    private DBHelper dbHelper;

    public DBManager(Context context){
        dbHelper=new DBHelper(context);
    }

    public int insert(Student student){
        //打开连接，写入数据
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("sno",student.sno);
        values.put("sname",student.sname);
        values.put("sclass",student.sclass);
        values.put("sign1",student.sign1);
        values.put("sign2",student.sign2);
        values.put("test1",student.test1);
        values.put("test2",student.test2);
        values.put("test3",student.test3);
        values.put("test4",student.test4);
        values.put("test5",student.test5);
        values.put("score",student.score);
        values.put("grade",student.grade);
        long student_Id=db.insert("student",null,values);//**********student_Id出现的问题
        db.close();
        return (int)student_Id;
    }

    public void delete(int student_Id){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        db.delete("student","sno"+"=?", new String[]{String.valueOf(student_Id)});
        db.close();
    }
    public void update(Student student){//更新学生考勤1成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("sign1",student.sign1);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void updateSign2(Student student){//更新学生考勤2成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("sign2",student.sign2);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void update1(Student student){//更新学生实验1成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("test1",student.test1);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void update2(Student student){//更新学生实验2成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("test2",student.test2);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void update3(Student student){//更新学生实验3成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("test3",student.test3);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void update4(Student student){//更新学生实验4成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("test4",student.test4);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void update5(Student student){  //更新学生实验5成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("test5",student.test5);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void updateScore(Student student){//更新学生期末考试成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("score",student.score);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }
    public void updateGrade(Student student){ //更新学生总成绩
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("grade",student.grade);
        db.update("student",values,"sno"+"=?",new String[] { student.sno});
        db.close();
    }

    public ArrayList<HashMap<String, String>> getStudentList(){
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectQuery="SELECT "+
                "sno"+","+
                "sname"+","+
                "sclass"+","+" FROM "+"student";
        ArrayList<HashMap<String,String>> studentList=new ArrayList<HashMap<String, String>>();
        Cursor cursor=db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String,String> student=new HashMap<String,String>();
                student.put("sno",cursor.getString(cursor.getColumnIndex("sno")));
                student.put("sname",cursor.getString(cursor.getColumnIndex("sname")));
                studentList.add(student);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return studentList;
    }

    public Student getStudentById(String name){ // 通过姓名查询该学生基本信息
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectQuery="SELECT sno,sname,sclass FROM student WHERE sname=?";
        int iCount=0;
        Student student=new Student();
        Cursor cursor=db.rawQuery(selectQuery,new String[]{name});
        if(cursor.moveToFirst()){
            do{
                student.sno =cursor.getString(cursor.getColumnIndex("sno"));
                student.sname =cursor.getString(cursor.getColumnIndex("sname"));
                student.sclass  =cursor.getString(cursor.getColumnIndex("sclass"));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return student;
    }
    public Student getGradeById(String name){// 通过姓名查询该学生所有成绩
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String selectQuery="SELECT sign1,sign2,test1,test2,test3,test4,test5,score FROM student WHERE sname=?";
        int iCount=0;
        Student student=new Student();
        Cursor cursor=db.rawQuery(selectQuery,new String[]{name});
        if(cursor.moveToFirst()){
            do{
                student.sign1 =cursor.getInt(cursor.getColumnIndex("sign1"));
                student.sign2 =cursor.getInt(cursor.getColumnIndex("sign2"));
                student.test1 =cursor.getInt(cursor.getColumnIndex("test1"));
                student.test2 =cursor.getInt(cursor.getColumnIndex("test2"));
                student.test3 =cursor.getInt(cursor.getColumnIndex("test3"));
                student.test4 =cursor.getInt(cursor.getColumnIndex("test4"));
                student.test5 =cursor.getInt(cursor.getColumnIndex("test5"));
                student.score =cursor.getInt(cursor.getColumnIndex("score"));
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return student;
    }
}