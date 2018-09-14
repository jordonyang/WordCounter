package github.jordon.processor;

/**
 * 统计某代码文件中的注释行数、代码行数和空白行
 *
 * @author Jordon
 */
public class AnnotationAndCodeProcessor extends BaseProcessor {

    // 注释行数
    private int annotationCount;
    // 代码行数
    private int codeLineCount;
    // 空白行
    private int blankLineCount;
    // 注释块开始标记
    private boolean annotationOn;

    @Override
    public void process(String line) {
        if (line.trim().equals("")) {
            blankLineCount++;
        }else if (line.trim().endsWith("*/")) { //注意此处的顺序
            annotationOn = false;
            annotationCount++;
        }else if (annotationOn || line.trim().contains("//")) {
            // 有可能存在 }// 的情况
            annotationCount++;
        }else if (line.trim().startsWith("/*")) {
            annotationOn = true;
            annotationCount++;
        }else {
            codeLineCount++;
        }
        super.process(line);
    }

    @Override
    public void printInfo() {
        System.out.println("\tannotation lines: " + annotationCount + "\r\n" +
                "\tcode lines: " + codeLineCount + "\r\n" + "\tblank lines: "
                + blankLineCount);
        super.printInfo();
    }

    @Override
    public void resetValues() {
        annotationCount = 0;
        codeLineCount = 0;
        blankLineCount = 0;
        annotationOn = false;
        super.resetValues();
    }
}
