package jvm.log;

/**
 * GC日志测试
 * -XX:+PrintGCDetails
 */
public class GCLogCase {

    public static void main(String[] args) {
        int _1m = 1024 * 1024;
        byte[] data = new byte[_1m];
        // 将data置为null即让它成为垃圾
        data = null;
        // 通知垃圾回收器回收垃圾
        System.gc();
    }
}