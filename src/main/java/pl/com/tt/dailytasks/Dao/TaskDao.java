package pl.com.tt.dailytasks.Dao;

import pl.com.tt.dailytasks.Entity.Task;

import java.util.Collection;

public interface TaskDao {
    Collection<Task> getAllTasks();

    void insertTask(Task task);

    void updateTask(Task task);

    Task getTaskById(int id);

    void removeTaskById(int id);
}
