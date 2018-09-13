package github.jordon;

import github.jordon.args.ArgsParser;
import github.jordon.args.Arguments;
import github.jordon.args.ParseResult;
import github.jordon.util.FileLiner;

import java.io.File;

/**
 * 入口程序
 */
public class AppEntry {

    public static void main(String[] args) throws Exception {
        ArgsParser parser = new ArgsParser();

        ParseResult result = parser.parse(args);
        if (result != null) {
            if (result.getTargets().size() > 0) {
                if (result.getProcessor() != null) {
                    for (File file : result.getTargets()) {
                        new FileLiner().line(file, result.getProcessor());
                    }
                }else {
                    System.out.println("check your parameters");
                }
            }else {
                System.out.println("check your file_name");
            }
        }else {
            System.out.println(getUsage());
        }
    }

    /**
     * 获取使用说明
     * @return 使用说明
     */
    private static String getUsage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Usage:" + "\t wc.exe [parameter] [file_name]\r\n"+ "parameters:\n");
        for (Arguments arguments : Arguments.values()) {
            stringBuilder.append("\t\t").append(arguments.getArg()).append("\t").append(arguments.getMsg()).append("\r\n");
        }
        return stringBuilder.toString();
    }
}
