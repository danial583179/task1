package Lessons.Task4.Task2.Exception;

public class FunctionException extends RuntimeException {
    FunctionExceptionCode functionExceptionCode;

    public FunctionException(FunctionExceptionCode functionExceptionCode) {
        super(functionExceptionCode.getMessage());
        this.functionExceptionCode = functionExceptionCode;
    }

    public FunctionExceptionCode getFunctionExceptionCode() {
        return functionExceptionCode;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
