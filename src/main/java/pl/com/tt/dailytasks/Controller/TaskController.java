package pl.com.tt.dailytasks.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.com.tt.dailytasks.Entity.Task;
import pl.com.tt.dailytasks.Service.TaskService;

import java.util.Collection;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public Task getTaskById(@PathVariable("id") int id){
        return taskService.getTaskById(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void removeTaskById(@PathVariable("id") int id){taskService.removeTaskById(id);}

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTask(@RequestBody Task task){
        taskService.updateTask(task);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertTask(@RequestBody Task task){
        taskService.insertTask(task);
    }
}

