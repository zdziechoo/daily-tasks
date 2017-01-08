package pl.com.tt.dailytasks.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.com.tt.dailytasks.Dao.TaskDao;
import pl.com.tt.dailytasks.Entity.Task;
import pl.com.tt.dailytasks.Exceptions.TaskExistException;
import pl.com.tt.dailytasks.Exceptions.NoTaskException;

import java.util.Collection;

@Service
public class TaskService {

    @Autowired
    @Qualifier("MemoryData")
    private TaskDao taskDao;

    public Collection<Task> getAllTasks(){
        return taskDao.getAllTasks();
    }

    public Task getTaskById(int id) throws NoTaskException {
        if(this.taskDao.getTaskById(id) instanceof Task)
            return this.taskDao.getTaskById(id);
        else
            throw new NoTaskException();
    }

    public void removeTaskById(int id) throws NoTaskException{
        if(this.taskDao.getTaskById(id) instanceof Task)
            this.taskDao.removeTaskById(id);
        else
            throw new NoTaskException();
    }

    public void updateTask(Task task)throws NoTaskException{
        if(this.taskDao.getTaskById(task.getId()) instanceof Task)
            this.taskDao.updateTask(task);
        else
            throw new NoTaskException();
    }

    public void insertTask(Task task) throws TaskExistException{
        if(! (this.taskDao.getTaskById(task.getId()) instanceof Task))
            this.taskDao.insertTask(task);
        else
            throw new TaskExistException();
    }

}
