import java.util.ArrayList;

public class TaskManager {
    private int nextId = 1;
    ArrayList<Task> tasks = new ArrayList<Task>();

    public void addTask(String title) {
        Task newTask = new Task(nextId++, title);
        tasks.add(newTask);
    }

    public void listTasks() {
        if (tasks.isEmpty())
            System.out.println("There are no tasks.");
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public boolean markComplete(int taskId) {
        for (Task t : tasks) {
            if (t.getId() == taskId) {
                t.setComplete(true);
                return true;
            }
        }

        return false;
    }

    public boolean deleteTask(int taskId) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == taskId) {
                tasks.remove(i);
                return true; // successfully deleted task
            }
        }
        return false;
    }

}
