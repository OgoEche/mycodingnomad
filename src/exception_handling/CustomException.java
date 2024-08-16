package exception_handling;

public class CustomException extends Exception {
    public CustomException() {}

    @Override
    public String toString() {
        return "CustomException{}";
    }
}
