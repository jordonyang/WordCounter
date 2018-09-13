package github.jordon.args;

import github.jordon.processor.*;

/**
 * 参数枚举类
 * 可通过参数获取相应的处理器（单例）和提示信息
 * @author Jordon
 */
public enum Arguments {

    CHARS("-c", new CharProcessor(), "char count"),
    WORDS("-w", new WordProcessor(), "word count"),
    LINES("-l", new LineProcessor(), "line count"),
    ANNOTATION("-a", new AnnotationAndCodeProcessor(), "annotation and code count"),
    SEARCH_RECURSION("-s", null, "recursive search"),
    CHOOSE_FILES("-x", null, "choose files");

    private final String arg;

    private final BaseProcessor processor;

    private final String msg;

    Arguments(String arg, BaseProcessor processor, String msg) {
        this.arg = arg;
        this.processor = processor;
        this.msg = msg;
    }

    public String getArg() {
        return arg;
    }

    public BaseProcessor getProcessor() {
        return processor;
    }

    public String getMsg() {
        return msg;
    }
}
