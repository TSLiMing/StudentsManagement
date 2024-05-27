package Server;

import Data.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static final String ADDSTUDENT = "1";
    public static final String DELETESTUDENT = "2";
    public static final String MODIFYSTUDENT = "3";
    public static final String CHECKSTUDENT = "4";
    public static final String EXIT = "5";

    public static void manipulate() {
        Scanner sc = new Scanner(System.in);
        showMenu();
        String choice = sc.nextLine();
        switch (choice) {
            case ADDSTUDENT -> {
                addStudent(Student.studentsList);
            }
            case DELETESTUDENT -> {
                deleteStudent(Student.studentsList);
            }
            case MODIFYSTUDENT -> {
                modifyStudent(Student.studentsList);
            }
            case CHECKSTUDENT -> {
                checkStudent(Student.studentsList);
            }
            case EXIT -> {
                System.out.println("正在退出，欢迎下次使用~");
                System.exit(0);
            }
            default -> {
                System.out.println("输入错误！");
            }
        }
    }

    /*添加学生*/
    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);

        //输入ID
        String id;
        boolean flag = false;
        do {
            if (flag) {
                System.out.println("当前ID已存在，请重新输入");
            } else {
                System.out.println("请输入学生ID");
                flag = true;
            }
            id = sc.nextLine();

        } while (IDExisted(id, list) != null);

        //输入姓名
        System.out.println("请输入学生姓名");
        String name = sc.nextLine().trim();

        //输入年龄
        System.out.println("请输入学生年龄");
        int age = inputAge(sc);

        //输入家庭住址
        System.out.println("请输入家庭住址");
        String address = sc.nextLine().trim();

        list.add(new Student(id, name, age, address));
    }

    private static int inputAge(Scanner sc) {
        boolean flag = true;
        String ageString = null;
        while (flag) {
            flag = false;
            ageString = sc.nextLine();
            for (int i = 0, len = ageString.length(); i < len; i++) {
                if (!Character.isDigit(ageString.charAt(i))) {
                    System.out.println("请检查年龄格式！");
                    System.out.println("请重新输入");
                    flag = true;
                    break;
                }
            }
        }
        return Integer.parseInt(ageString);
    }

    private static Student IDExisted(String id, ArrayList<Student> list) {
        for (Student student : list) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    /*根据键入id删除学生*/
    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生ID");
        String id = sc.nextLine();

        Student removeStudent = IDExisted(id, list);

        if (removeStudent == null) {
            System.out.println("ID不存在，正在返回菜单");
            return;
        }
        System.out.println("ID存在，正在删除");
        list.remove(removeStudent);
        System.out.println("删除成功！");
    }

    /*根据键入id修改学生信息*/
    public static void modifyStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生ID");
        String id = sc.nextLine();

        Student modifyStudent = IDExisted(id, list);

        if (modifyStudent == null) {
            System.out.println("ID不存在，正在返回菜单");
            return;
        }

        System.out.println("存在该名学生，请进行修改");

        //输入姓名
        System.out.println("请输入学生姓名");
        modifyStudent.setName(sc.nextLine().trim());

        //输入年龄
        System.out.println("请输入学生年龄");
        modifyStudent.setAge(inputAge(sc));

        //输入家庭住址
        System.out.println("请输入家庭住址");
        modifyStudent.setAddress(sc.nextLine().trim());

        System.out.println("修改完成！");
    }

    /*查询*/
    public static void checkStudent(ArrayList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("当前无学生信息，请添加后再查询");
            return;
        }

        System.out.println("id\t\t姓名\t\t年龄\t\t家庭住址");
        for (Student student : list) {
            System.out.println(student);
        }
    }

    /*显示菜单*/
    public static void showMenu() {
        System.out.println("~~~~~~~~~~~~~~~欢迎来到学生管理系统~~~~~~~~~~~~~~~");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查询学生");
        System.out.println("5.退出");
        System.out.println("请输入您的选择");
    }
}