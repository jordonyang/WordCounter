package github.jordon.util;

import github.jordon.processor.BaseProcessor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileLiner {

    /**
     * 以行为单位请求责任链处理文件
     * @param file  待处理的文件
     * @param processors  责任链头结点
     * @throws Exception 抛出异常
     */
    public void line(File file, BaseProcessor processors) throws Exception {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        System.out.println("processing " + file.getAbsolutePath());

        while ((line = bufferedReader.readLine()) != null) {
            processors.process(line);
        }
        processors.printInfo();
        processors.resetValues();
    }
}
