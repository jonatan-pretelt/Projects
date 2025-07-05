class Task{
    private int id;
    private String title;
    private boolean isCompleted;

    public Task(int id, String title, boolean isCompleted){
        this.id = id;
        this.title = title;
        this.isCompleted =isCompleted;
    }
    public Task(int id, String title){
        this(id, title, false);
    }

    public String toString(){
        String isCompletedStr = isCompleted ? "Complete" : "Incomplete";
        return "[" + id + "]" + " " + title + " - " + isCompletedStr;
    }

    public void setComplete(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean isCompleted(){
        return isCompleted;
    }
    
}