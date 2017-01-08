package pl.com.tt.dailytasks.Exceptions;

public class TaskExistException extends RuntimeException {
    public String getMessage(){
        return "Task exist in database";
    }
}
