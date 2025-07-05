public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();


        taskManager.addTask("Test");
        taskManager.listTasks();
        taskManager.deleteTask(1);

        taskManager.listTasks();
        
    }
}
