package ArrayList;

public class illegalPosIndexException extends RuntimeException{
    public illegalPosIndexException(){

    }
    public illegalPosIndexException(String msg){
        super(msg);
    }
}
