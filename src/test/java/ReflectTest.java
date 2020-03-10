import com.niki.designPattern.singleton.Singleton01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射调用私有构造方法生成实例
 * @author niki-lauda
 * @create 2020-03-10 22:21
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("com.niki.designPattern.singleton.Singleton01");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton01 singleton01 = (Singleton01) constructor.newInstance();

        System.out.println(singleton01.work("niki"));
        Singleton01 singleton02 = Singleton01.getInstance();

        System.out.println(singleton01 == singleton02);
    }
}
