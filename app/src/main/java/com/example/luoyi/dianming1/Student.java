package com.example.luoyi.dianming1;

/**
 * Created by luoyi on 2016/10/26.
 */
public class Student {
    public String sno;
    public String sname=null;
    public String sclass=null;
    public int sign1=0;
    public int sign2=0;
    public int test1=0;
    public int test2=0;
    public int test3=0;
    public int test4=0;
    public int test5=0;
    public int score=0;
    public int grade=0;
    public static String name;
    public static int t1;

    public Student(String sno, String sname, String sclass, int sign1, int sign2, int test1, int test2, int test3, int test4, int test5, int score, int grade) {
        this.sno = sno;
        this.sname = sname;
        this.sclass = sclass;
        this.sign1 = sign1;
        this.sign2 = sign2;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.test4 = test4;
        this.test5 = test5;
        this.score = score;
        this.grade = grade;
    }
    public Student()
    {}
}
