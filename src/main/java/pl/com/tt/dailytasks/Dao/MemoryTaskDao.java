package pl.com.tt.dailytasks.Dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pl.com.tt.dailytasks.Entity.Task;
import pl.com.tt.dailytasks.Entity.Urgency;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("MemoryData")
public class MemoryTaskDao implements TaskDao {

    private static Map<Integer,Task> tasks;

    static{
        tasks = new HashMap<Integer,Task>(){
            {
                put(1,new Task(1,"Go to Dentist","At 6 PM, Piotrkowska Street, 156",Urgency.HIGH));
                put(2,new Task(2,"Pay bills for energy","At 1 PM, do in work, 156",Urgency.HIGH));
                put(3,new Task(3,"Call to Ann","At 8 PM",Urgency.LOW));
                put(4,new Task(4,"Buy bread","At 7 AM, Shop near, 156",Urgency.MEDIUM));
                put(5,new Task(5,"Wash Car","At 9 AM, Piotrkowska Street, 260 - Do before work",Urgency.HIGH));
            }
        };
    }
    @Override
    public Collection<Task> getAllTasks() {
        return this.tasks.values();
    }

    @Override
    public void insertTask(Task task) {
        Task t = new Task();
        t.setId(task.getId());
        t.setName(task.getName());
        t.setDescription(task.getDescription());
        t.setUrgency(task.getUrgency());
        this.tasks.put(t.getId(),t);
    }

    @Override
    public void updateTask(Task task) {
        Task t = tasks.get(task.getId());
        t.setName(t.getName());
        t.setDescription(t.getDescription());
        t.setUrgency(task.getUrgency());
        /*t.setCreateStamp(t.getCreateStamp());*/
        tasks.put(t.getId(),task);
    }

    @Override
    public Task getTaskById(int id) {
        return this.tasks.get(id);
    }

    @Override
    public void removeTaskById(int id) {
        this.tasks.remove(id);
    }
}
