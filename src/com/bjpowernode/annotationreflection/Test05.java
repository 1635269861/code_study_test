package com.bjpowernode.annotationreflection;

/**
 * @李永琪
 * @create 2020-10-17 23:41
 */
public class Test05 {

    //获取类对象的四种方式
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();

        Class clazz1 = person.getClass();
        System.out.println(clazz1.hashCode());

        Class clazz2 = Class.forName("com.bjpowernode.annotationreflection.Student");
        System.out.println(clazz2.hashCode());

        Class clazz3 = Student.class;
        System.out.println(clazz3.hashCode());

        Class superclass = clazz1.getSuperclass();
        System.out.println(superclass);
    }

}
