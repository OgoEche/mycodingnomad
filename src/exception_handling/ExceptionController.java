package exception_handling;

//Create a custom exception.
//Demonstrate throwing an exception in one method and catching it in another method.
public class ExceptionController {
    public static void main(String[] args) {
        new ExceptionController().validateFunc();
    }

    public void customVal() throws CustomException {
        throw new CustomException();
    }

    public void validateFunc () {
        try {
            customVal();
        } catch (CustomException e) {
            throw new RuntimeException(e);
        }
    }

}
