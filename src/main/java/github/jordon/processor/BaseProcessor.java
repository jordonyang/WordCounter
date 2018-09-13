package github.jordon.processor;

/**
 * 定义子类的接口规范和成员，作为子类的默认实现，可用于处理链的移动
 * @author Jordon
 */
public abstract class BaseProcessor {
    // 下一个处理器结点
    public BaseProcessor next;
    // 责任链的头结点
    public BaseProcessor head;
    // 责任链的尾结点
    public BaseProcessor tail;

    /**
     * 处理器逻辑
     * @param line  文件中的一行数据
     */
    public void process(String line) {
        if (this.next != null) {
            next.process(line);
        }
    }

    /**
     * 打印统计结果
     */
    public void printInfo(){
        if (this.next != null) {
            next.printInfo();
        }
    }

    /**
     * 为节省资源，使用枚举类Arguments获取单例的处理器对象
     * 所以在一个文件处理完之后，需要将处理器中的统计成员恢复最初值
     */
    public void resetValues() {
        if (this.next != null) {
            next.resetValues();
        }
    }
}

