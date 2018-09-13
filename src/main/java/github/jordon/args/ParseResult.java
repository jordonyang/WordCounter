package github.jordon.args;

import github.jordon.processor.BaseProcessor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;

/**
 * @author Jordon
 * 参数解析的结果没包括处理器链和待处理对象
 */
@Setter
@Getter
public class ParseResult {

    private List<File> targets;

    private BaseProcessor processor;
}
