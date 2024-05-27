package Server;

import Data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static final String SIGNIN = "1";
    public static final String SIGNUP = "2";
    public static final String FORGETKEY = "3";
    public static final String EXIT = "4";

    public static void main(String[] args) {
        loginMenu();
    }

    /*登录菜单*/
    public static void loginMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~欢迎来到学生管理系统~~~~~~~~~~~~");
        System.out.println("请选择操作");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.忘记密码");
        System.out.println("4.退出");

        String choice = sc.nextLine();
        switch (choice) {
            case SIGNIN -> {
                boolean flag = signIn(User.usersList);
                if (flag) {
                    Menu.manipulate();
                } else {
                    System.out.println("登录失败");
                }
            }
            case SIGNUP -> {

            }
            case FORGETKEY -> {

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

    /*登录*/
    public static boolean signIn(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);

        //输入用户名
        System.out.println("请输入用户名");
        String userName = sc.nextLine();
        User loginUser = null;
        for (User user : list) {
            if (userName.equals(user.getUserName())) {
                loginUser = user;
                break;
            }
        }
        if (loginUser == null) {
            System.out.println("当前用户名未注册，请先注册");
            return false;
        }

        //输入密码,验证码
        String key;
        String test;
        int cnt = 0;
        return  true;
    }

    /*注册*/
    public static void signUp() {
    }

    /*忘记密码*/
    public static void forgetKey() {
    }
}
