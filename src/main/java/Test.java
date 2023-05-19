import lombok.Getter;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Test {
    public static void main(String[] args) throws ParseException {
        TaskOperationsHelper helper = new TaskOperationsHelper();
        TaskOperations taskOperations = new TaskOperations(helper);

        TaskDTO newTask = createNewTask("fresh task created");
        String taskId = taskOperations.addTask(newTask);
        System.out.println("Task created successfully with taskId::" + taskId);

        Task task = taskOperations.getTask(taskId);
        System.out.println("Task details::"+task);

        Task modifiedTask = taskOperations.modifyTask(taskId, createNewTask("modifying task"));
        System.out.println("Modified Task details::"+modifiedTask);

        Map<String, String> taskActivityMap = taskOperations.activityLog("26/04/2023", "26/04/2023");
        System.out.println("task activity map::"+taskActivityMap);
        taskOperations.removeTask(taskId);

        System.out.println("Task removed successfully with taskId::"+taskId);

        Task deletedTask = taskOperations.getTask(taskId);
        System.out.println("Deleted task details::"+deletedTask);
    }

    private static TaskDTO createNewTask(String description){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription(description);
        taskDTO.setName("task"+Math.random());
        taskDTO.setTags(new String[]{"test", "assessment"});
        taskDTO.setStartTime(new Date());
        taskDTO.setEndTime(new Date());

        return taskDTO;
    }
}

class TaskDTO{
    private String name;
    private String description;
    private String[] tags;
    private Date startTime;
    private Date endTime;

    public String getDescription() {
        return description;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class Task{
    private String id;
    private String name;
    private String description;
    private String[] tags;
    private TaskStatus status;
    private Boolean activeStatus;
    private Date startTime;
    private Date endTime;
    private Date createdTime;
    private Date updatedTime;

    public Task(){}
    public Task(String id, String name, String description, String[] tags, TaskStatus status, Date startTime, Date endTime,
                Date createdTime, Date updatedTime, Boolean activeStatus){
        this.id = id;
        this.name = name;
        this.tags = tags;
        this.description = description;
        this.status = status;
        this.activeStatus = activeStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setActiveStatus(Boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getDescription() {
        return description;
    }

    public String[] getTags() {
        return tags;
    }

    public Date getStartTime() {
        return startTime;
    }

    public String getName() {
        return name;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Boolean getActiveStatus() {
        return activeStatus;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return "id:"+id+" name: "+name+" description: "+description+" startTime: "+startTime
                +" endTime: "+endTime+" createdTime: "+createdTime+" status: "+activeStatus;
    }
}

enum TaskStatus{
    ADDED,
    STARTED,
    COMPLETED,
    FAILED;
}

class TaskOperations{
    private static final Map<String, Task> TASK_MAP = new ConcurrentHashMap<>();
    private TaskOperationsHelper helper;
    public TaskOperations(TaskOperationsHelper helper){
        this.helper = helper;
    }
    public String addTask(TaskDTO taskDTO){
        Task task = helper.taskDtoToTask(taskDTO);

        String taskId = task.getId();
        TASK_MAP.put(taskId, task);

        return taskId;
    }

    public Task getTask(String taskId){
        if(!TASK_MAP.containsKey(taskId)){
            throw new TaskNotFoundException(MessageFormat.format("Task with taskId::{0} not found",taskId));
        }
        return TASK_MAP.get(taskId);
    }

    public Task modifyTask(String taskId, TaskDTO taskDTO){
        Task oldTask = getTask(taskId);
        Task task = helper.updateTaskWithTaskDTO(taskDTO, oldTask);
        TASK_MAP.put(taskId, task);
        return task;
    }

    public void removeTask(String taskId){
        Task task = getTask(taskId);
    }

    public Map<String, String> activityLog(String startTime, String endTime) throws ParseException {
        long startDate=new SimpleDateFormat("dd/MM/yyyy").parse(startTime).getTime();
        long endDate=new SimpleDateFormat("dd/MM/yyyy").parse(endTime).getTime();
        StringBuilder addedTask = new StringBuilder();
        StringBuilder modifiedTask = new StringBuilder();
        for(Task task : TASK_MAP.values()){
            long createdTime = task.getCreatedTime().getTime();
            long updateTime = task.getUpdatedTime().getTime();
            if(createdTime>=startDate && createdTime<=endDate){
                addedTask.append(task.getId());
                addedTask.append(", ");
            }
            if(updateTime>=startDate && updateTime<=endDate){
                modifiedTask.append(task.getId());
                modifiedTask.append(", ");
            }
        }
        Map<String, String> taskActivityMap = new HashMap<>();
        taskActivityMap.put("added task", addedTask.toString());
        taskActivityMap.put("modified task", modifiedTask.toString());

        return taskActivityMap;
    }
}


class TaskNotFoundException extends RuntimeException{
    private String message;
    public TaskNotFoundException(String message){
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

class TaskOperationsHelper{
    private static AtomicLong id = new AtomicLong();

    public Task updateTaskWithTaskDTO(TaskDTO taskDTO, Task task) {
        Task newTask = new Task();
        newTask.setId(task.getId());
        newTask.setCreatedTime(task.getCreatedTime());
        newTask.setUpdatedTime(new Date());
        
        if(taskDTO.getDescription() != null){
            newTask.setDescription(taskDTO.getDescription());
        }
        else{
            newTask.setDescription(task.getDescription());
        }
        if(taskDTO.getName()!=null){
            newTask.setName(taskDTO.getName());
        }
        else{
            newTask.setName(task.getName());
        }
        if(taskDTO.getTags() != null){
            newTask.setTags(taskDTO.getTags());
        }
        else{
            newTask.setTags(task.getTags());
        }
        if(taskDTO.getStartTime()!=null){
            newTask.setStartTime(taskDTO.getStartTime());
        }
        else{
            newTask.setStartTime(task.getStartTime());
        }
        if(taskDTO.getEndTime()!=null){
            newTask.setEndTime(taskDTO.getEndTime());
        }
        else{
            newTask.setEndTime(task.getEndTime());
        }
        newTask.setActiveStatus(getActiveStatus(taskDTO, task));
        newTask.setStatus(task.getStatus());

        return newTask;
    }

    private boolean getActiveStatus(TaskDTO taskDTO, Task task) {
        if(taskDTO.getStartTime() == null || taskDTO.getEndTime() == null 
                || task.getStatus() == TaskStatus.COMPLETED || task.getStatus() == TaskStatus.FAILED || task.getStatus() == TaskStatus.STARTED){
            return task.getActiveStatus();
        }
        long currTime = new Date().getTime();
        return currTime >= taskDTO.getStartTime().getTime() && currTime <= taskDTO.getEndTime().getTime();
    }

    public Task taskDtoToTask(TaskDTO taskDTO){
        String taskId = createID();
        Date currDate = new Date();
        long currTime = currDate.getTime();
        boolean active = true;
        if(taskDTO.getStartTime() != null && taskDTO.getEndTime() != null){
            active = currTime >= taskDTO.getStartTime().getTime() && currTime <= taskDTO.getEndTime().getTime();
        }

        return new Task(taskId, taskDTO.getName(), taskDTO.getDescription(), taskDTO.getTags(), TaskStatus.ADDED,
                taskDTO.getStartTime(), taskDTO.getEndTime(), currDate, currDate, active);

    }

    private static String createID()
    {
        return String.valueOf(id.getAndIncrement());
    }

}

