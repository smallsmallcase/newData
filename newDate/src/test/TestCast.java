package test;

/**
 * Created by huhui on 2017/12/4.
 */
public class TestCast {
    public static void main(String[] args) {
        Object a = (Object) "123";
        Class c = Integer.class;

        c.cast(a);
    }
}
