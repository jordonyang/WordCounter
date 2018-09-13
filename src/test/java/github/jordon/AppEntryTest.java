package github.jordon;


import org.junit.Test;

public class AppEntryTest {

    private String path = "E:\\projects\\Example.java";

    /**
     * 空参测试
     */
    @Test
    public void testEmptyArgs() {
        String[] args = {};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 错误参数
     */
    @Test
    public void testWrongArgs() {
        String[] args = {"-p", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件不存在
     */
    @Test
    public void testFileDoesNotExist() {
        String[] args = {"-l", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单参单文件
     */
    @Test
    public void testWordCount() {
        String[] args = {"-w", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testCharCount() {
        String[] args = {"-c", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLineCount() {
        String[] args = {"-l", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testACCount() {
        String[] args = {"-a", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多参数单文件
     */
    @Test
    public void multiArgs() {
        String[] args = {"-c", "-a", "-l", "-w", path};
        try {
            AppEntry.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 多参数多文件
     */
    @Test
    public void test() throws Exception {
        String[] args1 = {"-l", "-c", "-w", "-a", "A*Test.java"};
        AppEntry.main(args1);
        String[] args2 = {"-s", "-l", "-c", "-w", "-a", "A*Test.java"};
        AppEntry.main(args2);
    }

    /**
     * 正则匹配
     */
    @Test
    public void testRegex() throws Exception {
        String[] args3 = {"-s", "-l", "-c", "-w", "-a", "E:\\projects\\java\\A*Test.java"};
        AppEntry.main(args3);
    }

    /**
     * 正则匹配
     */
    @Test
    public void testRegex1() throws Exception {
        String[] args3 = {"-s", "-l", "-c", "-w", "-a", "E:\\projects\\java1\\A*Test.java"};
        AppEntry.main(args3);
    }

    /**
     * 测试选择文件
     */
    @Test
    public void testX() {
        String[] args1 = {"-l", "-c", "-w", "-x", "-a"};
        try {
            AppEntry.main(args1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}