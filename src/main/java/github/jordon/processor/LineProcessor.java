package github.jordon.processor;

import github.jordon.args.Arguments;

/**
 * 统计某代码文件中总行数
 *
 * @author Jordon
 */
public class LineProcessor extends BaseProcessor {

    private int count;

    @Override
    public void process(String line) {
        count++;
        super.process(line);
    }

    @Override
    public void printInfo() {
        System.out.println("\t" + Arguments.LINES.getMsg() + ": " + count);
        super.printInfo();
    }

    public void resetValues() {
        count = 0;
        super.resetValues();
    }
}
