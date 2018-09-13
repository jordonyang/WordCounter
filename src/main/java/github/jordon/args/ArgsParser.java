package github.jordon.args;

import github.jordon.processor.BaseProcessor;
import github.jordon.util.FileLocator;

import java.util.HashMap;
import java.util.Map;

/**
 * 参数解析器
 *  1. 获取参数中指定的所有处理器并按序排成链
 *  2. 获取所有待处理的文件
 *
 * @author Jordon
 */
public class ArgsParser {

    private static final Map<String, String> argsMatcher;

    /*
     * 当且仅当程序初次加载时指明参数与枚举类成员的关系
     */
    static {
        argsMatcher = new HashMap<>();
        argsMatcher.put("-l", "LINES");
        argsMatcher.put("-a", "ANNOTATION");
        argsMatcher.put("-w", "WORDS");
        argsMatcher.put("-c", "CHARS");
        argsMatcher.put("-s", "SEARCH_RECURSION");
        argsMatcher.put("-x", "CHOOSE_FILES");
    }

    /**
     * 解析参数
     * @param args 所有参数
     * @return  解析结果
     */
    public ParseResult parse(String[] args) {
        if (args.length > 0) {
            ParseResult result = new ParseResult();
            FileLocator fileLocator = new FileLocator();
            boolean needRecursion = false, chooseFiles = false;

            // 判断是否有 -s 和 -x 参数
            for (String arg : args) {
                if (arg.equals(Arguments.SEARCH_RECURSION.getArg())) {
                    needRecursion = true;
                    break;
                }
                if (arg.equals(Arguments.CHOOSE_FILES.getArg())) {
                    chooseFiles = true;
                }
            }

            // 获取所有待处理文件
            if (chooseFiles) { // 需要打开文件选择器选择文件
                result.setTargets(fileLocator.chooseFiles());
            }else { // 通过文件名或者模式匹配
                result.setTargets(fileLocator.locateTarget(args[args.length - 1], needRecursion));
            }

            // 获取处理链
            result.setProcessor(getProcessors(args, chooseFiles));
            return result;
        }else {
            System.out.println("please specify the args");
        }
        return null;
    }


    /**
     * 获取处理链
     * @param args  参数集
     * @param chooseFiles  是否通过文件选择器选择文件
     * @return 处理链的头结点
     */
    private BaseProcessor getProcessors(String[] args, boolean chooseFiles) {
        BaseProcessor result = null;
        // 如果选择文件的话，因为之给定惭怍参数，而不指定文件，所有的参数都会用到
        int length = chooseFiles ? args.length : args.length - 1;

        // 对比传入的参数和枚举类中定义的信息，获取相应的处理器对象并连接成链
        for (int i = 0; i < length; i++) {
            String value = argsMatcher.get(args[i]);
            if (value != null) {
                BaseProcessor processor = Arguments.valueOf(value).getProcessor();
                if (processor != null) {
                    if (result == null) {   // 首次插入
                        result = processor;
                        result.head = result.tail = result;
                    }else  {
                        result.tail.next = processor;
                        result.tail = processor;
                    }
                }
            }else {
                System.out.println("args " + args[i] + " does not exist");
            }
        }
//        if (result != null) {
//            BaseProcessor temp = result;
//            while (temp != null) {
//                System.out.println(temp);
//                temp = temp.next;
//            }
//        }
        return result;
    }
}

