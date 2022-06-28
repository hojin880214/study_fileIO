package com.fileIO.shj;

import com.fileIO.shj.annotation.FileAnnotation;
import com.fileIO.shj.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.reflect.Method;

public class Main {

    private static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        String packageName = "com.fileIO.shj";
        String packageNameSlash = "./" + packageName.replace(".", "/");
        URL directoryURL = Thread.currentThread().getContextClassLoader().getResource(packageNameSlash);
        if (directoryURL == null) {
            System.err.println("Could not retrive URL resource : " + packageNameSlash);
        }

        String directoryString = directoryURL.getFile();
        if (directoryString == null) {
            System.err.println("Could not find directory for URL resource : "
                    + packageNameSlash);
        }

        File directory = new File(directoryString);

        if (directory.exists()) {
            String[] files = directory.list();
            for (String fileName : files) {
                if (fileName.endsWith(".class")) {
                    fileName = fileName.replace(".class", "");
                    try {

                        Class temp = Class.forName(packageName + '.' + fileName);

                        Annotation[] annotations = temp.getAnnotations();

                        Constructor con = temp.getConstructor();

                        for (Annotation annotation : annotations) {
                            if (annotation instanceof Controller) {
                                Controller myAnnotation  = (Controller) annotation;
                                for (Method method : temp.getDeclaredMethods()) {

                                    if (method.isAnnotationPresent(Mapping.class)) {

                                        method.invoke(con.newInstance());

                                    }


                                }


                            }

                        }

                    } catch (Exception e) {

                        // TODO Auto-generated catch block

                        e.printStackTrace();

                    }

                }

            }

        }

//        Method[] methodList=MyService.class.getMethods();
//
//        for(Method m : methodList) {
//            if(m.isAnnotationPresent(FileAnnotation.class)) {
//                System.out.println(m.getName());
//                FileAnnotation annotation=m.getDeclaredAnnotation(FileAnnotation.class);
//
//                String value=annotation.value();
//                int number=annotation.number();
//                for(int i=0;i<number;i++) {
//                    System.out.print(value);
//                }
//                System.out.println();
//            }
//        }

//        /* Class path를 한줄로 확인 가능 */
//        System.out.println(System.getProperty("java.class.path"));
//
//        /* Class path를 여러 줄로 나누어 확인 가능 (Windows)*/
//        for(String element : System.getProperty("java.class.path").split(";")) {
//            System.out.println(element);
//        }
//
//        /* Class path를 여러 줄로 나누어 확인 가능 (Linux)*/
//        for(String element : System.getProperty("java.class.path").split(":")) {
//            System.out.println(element);
//        }
//
//        LOGGER.debug("[debug] log!");
//        LOGGER.info("[info] log!");
//        LOGGER.warn("[warn] log!");
//        LOGGER.error("[error] log!");


//        Menu menu = new Menu();
//
//        while (true) {
//            menu.printMenu();
//            try {
//                Scanner sc = new Scanner(System.in);
//                int selectedNumber = sc.nextInt();
//                if (menu.selectMenu(selectedNumber)) return;
//            } catch (InputMismatchException E) {
//                LOGGER.error("잘못 입력하셨습니다. 아라비안 숫자를 올바르게 입력해주세요.");
//            }
//        }

    }
}
