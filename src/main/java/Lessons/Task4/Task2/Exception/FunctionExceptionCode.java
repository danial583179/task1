package Lessons.Task4.Task2.Exception;

public enum FunctionExceptionCode {
    ARGUMENT_OUT_OF_BOUNDS("Argument is out of segment"),
    ILLEGAL_SEGMENT("Entered segment does not contains Function segment"),
    ILLEGAL_METHOD("Method must return double and has 1 double parameter"),
    NULL_METHOD("Method should'nt be null"),
    ILLEGAL_BOUNDS("lower bound should be lower than upper bound");
    private String message;

    FunctionExceptionCode(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
