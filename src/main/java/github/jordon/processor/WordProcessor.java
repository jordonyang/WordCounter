package github.jordon.processor;

import github.jordon.args.Arguments;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计某个代码文件中单词个数（没有高级的分词功能）
 * @author Jordon
 */
public class WordProcessor extends BaseProcessor {

    // 总词数
    private int count;
    // 用于记录单词出现的次数
    private Map<String, Integer> map = new HashMap<>();

    @Override
    public void process(String line) {
        // 去前后空格，将非单词字符用空格替换，以空格为基准切割
        String[] strings = line.replaceAll("[^A-Za-z0-9_]", " ").trim().
                replaceAll("\\s+"," ").split(" ");

        for (String s : strings) {
            // 防止空格过滤不全
            if (s.equals("")) {
                continue;
            }
            // 已出现过则更新
            else if (map.containsKey(s)) {
                Integer c = map.get(s);
                map.put(s, ++c);
            }else {
                map.put(s, 1);
            }
            count ++;
        }
        super.process(line);
    }

    @Override
    public void printInfo() {
        System.out.println("\t" + Arguments.WORDS.getMsg() + ": "+ count);
        System.out.println("\tconcrete word count:");
        // 打印具体的单词出现次数
        for (String s : map.keySet()) {
            System.out.println("\t\t\t" + s + ": " + map.get(s));
        }
        super.printInfo();
    }

    @Override
    public void resetValues() {
        count = 0;
        map.clear();
        super.resetValues();
    }
}
