package StackAndQueue;

/**
 * @author 方锐
 * @since 2023/3/18 11:12
 */
public class EmptyStackException extends RuntimeException{
    public EmptyStackException(){}
    public EmptyStackException(String msg){
        super(msg);
    }
}
