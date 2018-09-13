package github.jordon.processor;

import github.jordon.args.Arguments;

/**
 * 统计文件中的总字符数
 * @author Jordon
 */
public class CharProcessor extends BaseProcessor {

    private int count;

    @Override
    public void process(String line) {
        count += line.toCharArray().length;
        super.process(line);
    }

    @Override
    public void printInfo() {
        System.out.println("\t" + Arguments.CHARS.getMsg() +": "+ count);
        super.printInfo();
    }

    @Override
    public void resetValues() {
        count = 0;
        super.resetValues();
    }
}
