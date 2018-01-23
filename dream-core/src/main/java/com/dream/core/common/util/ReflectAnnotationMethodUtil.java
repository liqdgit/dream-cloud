package com.dream.core.common.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * <p>Title:      ReflectAnnotationMethodUtil. </p>
 * <p>Description 反射查找某一个方法注解所注释的方法 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/2 17:52
 */
public class ReflectAnnotationMethodUtil {

    /**
     * <p>Title:      获取某一方法注解注释的方法. </p>
     * <p>Description </p>
     *
     * @param         pkgName 包
     * @param         isRecursive 是否遍历子包
     * @param         annotation 注解
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/2 17:48
     * @return
     */
    public static ArrayList<Method> getClassList(String pkgName, boolean isRecursive, Class<? extends Annotation> annotation) {
        ArrayList<Method> classList = new ArrayList<>();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try {
            // 按文件的形式去查找
            String strFile = pkgName.replaceAll("\\.", "/");
            Enumeration<URL> urls = loader.getResources(strFile);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    String pkgPath = url.getPath();
                    if ("file".equals(protocol)) {
                        // 本地自己可见的代码
                        findClassName(classList, pkgName, pkgPath, isRecursive, annotation);
                    } else if ("jar".equals(protocol)) {
                        // 引用第三方jar的代码
                        findClassName(classList, pkgName, url, isRecursive, annotation);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classList;
    }

    /**
     * <p>Title:      递归查找自有文件. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/2 17:50
     * @return
     */
    public static void findClassName(List<Method> clazzList, String pkgName, String pkgPath, boolean isRecursive, Class<? extends Annotation> annotation) {
        if (clazzList == null) {
            return;
        }
        // 过滤出.class文件及文件夹
        File[] files = filterClassFiles(pkgPath);
        if (files != null) {
            for (File f : files) {
                String fileName = f.getName();
                if (f.isFile()) {
                    // .class 文件的情况
                    String clazzName = getClassName(pkgName, fileName);
                    addClassName(clazzList, clazzName, annotation);
                } else {
                    // 文件夹的情况
                    if (isRecursive) {
                        // 需要继续查找该文件夹/包名下的类
                        String subPkgName = pkgName + "." + fileName;
                        String subPkgPath = pkgPath + "/" + fileName;
                        findClassName(clazzList, subPkgName, subPkgPath, true, annotation);
                    }
                }
            }
        }
    }

    /**
     * <p>Title:      递归查找jar包中文件. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/2 17:50
     * @return
     */
    public static void findClassName(List<Method> clazzList, String pkgName, URL url, boolean isRecursive, Class<? extends Annotation> annotation) throws IOException {
        JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> jarEntries = jarFile.entries();
        while (jarEntries.hasMoreElements()) {
            JarEntry jarEntry = jarEntries.nextElement();
            // 类似：sun/security/internal/interfaces/TlsMasterSecret.class
            String jarEntryName = jarEntry.getName();
            String clazzName = jarEntryName.replace("/", ".");
            int endIndex = clazzName.lastIndexOf(".");
            String prefix = null;
            if (endIndex > 0) {
                String prefix_name = clazzName.substring(0, endIndex);
                endIndex = prefix_name.lastIndexOf(".");
                if (endIndex > 0) {
                    prefix = prefix_name.substring(0, endIndex);
                }
            }
            if (prefix != null && jarEntryName.endsWith(".class")) {
                if (prefix.equals(pkgName)) {
                    addClassName(clazzList, clazzName, annotation);
                } else if (isRecursive && prefix.startsWith(pkgName)) {
                    // 遍历子包名：子类
                    addClassName(clazzList, clazzName, annotation);
                }
            }
        }
    }

    private static File[] filterClassFiles(String pkgPath) {
        if (pkgPath == null) {
            return null;
        }
        // 接收 .class 文件 或 类文件夹
        return new File(pkgPath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
    }

    private static String getClassName(String pkgName, String fileName) {
        int endIndex = fileName.lastIndexOf(".");
        String clazz = null;
        if (endIndex >= 0) {
            clazz = fileName.substring(0, endIndex);
        }
        String clazzName = null;
        if (clazz != null) {
            clazzName = pkgName + "." + clazz;
        }
        return clazzName;
    }

    /**
     * <p>Title:      添加. </p>
     * <p>Description </p>
     *
     * @param
     * @author        <a href="liqd163@163.com"/>李清栋</a>
     * @CreateDate    2018/1/2 17:50
     * @return
     */
    private static void addClassName(List<Method> clazzList, String clazzName, Class<? extends Annotation> annotation) {
        if (clazzList != null && clazzName != null) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(clazzName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (clazz != null) {
                if (annotation != null) {
                    Method[] methods = clazz.getMethods();
                    if (methods != null) {
                        for (Method method : methods) {
                            Annotation a = method.getAnnotation(annotation);
                            if (a != null) {
                                clazzList.add(method);
                            }
                        }
                    }
                }
            }
        }
    }
}
