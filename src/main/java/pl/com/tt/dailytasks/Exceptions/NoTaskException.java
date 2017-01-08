package pl.com.tt.dailytasks.Exceptions;

public class NoTaskException extends RuntimeException {
    public String getMessage(){
        return "No task in database";
    }
}
