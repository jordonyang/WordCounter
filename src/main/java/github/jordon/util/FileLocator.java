package github.jordon.util;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据命令中给定的最后一个参数，
 * 即文件名或者匹配模式获取所有待处理的文件
 * @author Jordon
 */
public class FileLocator {
    // 存放递归遍历中匹配到的文件
    private List<File> files = new ArrayList<>();

    /**
     * 获取待处理目标文件集
     * @param pattern 命令的最后一个参数，可为文件或者匹配模式
     * @param needRecursion 判断是否有-x参数， 有则需要递归查找
     * @return 待处理目标文件集
     */
    public List<File> locateTarget(String pattern, boolean needRecursion) {
        List<File> targets = new ArrayList<>();
        if (!needRecursion) { // 没哟-s 参数，不需要递归，只对单个文件进行处理
            File file = new File(pattern);
            // 判断是否有该文件
            if (file.exists()) {
                targets.add(file);
            }else {
                System.out.println("file " + pattern + " does not exist");
            }
        } else {
            // 递归查找与给定模式匹配的文件
            doRecursion(pattern);
            return files;
        }
        return targets;
    }

    /**
     * 递归查找与给定模式匹配的文件，如给定模式为：
     *    /usr/local/java/*.java   匹配/usr/local/java/下（包括子目录）所有的以.java结尾的文件
     *    *.java   匹配/usr/local/java/下（包括子目录）所有的以.java结尾的文件
     *    ?ps.c    ?处可以为任何单词字符
     *    [1-100]vm.c   所有第一位为1到100的文件名
     * @param pattern 模式
     */
    private void doRecursion(String pattern) {
        // 获取系统的分隔符
        char separator = File.separator.toCharArray()[0];
        int lastIndex = pattern.lastIndexOf(separator);
        String cwdPath = "";
        // 根据分隔符截取目录
        if (lastIndex != -1) {
            // 指定工作目录
            cwdPath = pattern.substring(0, lastIndex);
        }else {
            // 没有则为.
            cwdPath =  new File(cwdPath).getAbsoluteFile().
                    getParentFile().getAbsolutePath();
        }

        File cwd = new File(cwdPath);
        if (cwd.exists()){
            getFiles(cwd, pattern.substring(lastIndex + 1,
                    pattern.length()).replaceAll("\\*", "[A-Za-z0-9]+")
                    .replaceAll("\\?", "[A-Za-z0-9]"));
        }else {
            System.out.println("check your input");
        }
    }

    /**
     * 递归查找与给定模式匹配的文件
     * @param folder  目录
     * @param pattern   匹配模式
     */
    private void getFiles(File folder, String pattern) {
        File[] listFiles = folder.listFiles();
        for (File f : listFiles != null ? listFiles : new File[0]) {
            if (f.isFile() && f.getName().matches(pattern)) {
                files.add(new File(f.getAbsolutePath()));
            } else {
                // 递归
                getFiles(f, pattern);
            }
        }
    }

    /**
     * 选择文件
     * @return 选中的文件集
     */
    public List<File> chooseFiles() {
        // 设置父窗体
        JFrame frame = new JFrame("父窗体");
        frame.setSize(510, 350);
        frame.setLocation(200, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // 创建文件选择器
        JFileChooser fileChooser = new JFileChooser(".");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.showOpenDialog(frame);
        // 返回选中的文件集
        return Arrays.asList(fileChooser.getSelectedFiles());
    }

}
