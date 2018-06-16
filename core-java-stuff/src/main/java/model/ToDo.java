package model;

public class ToDo{
    private String task;
    private boolean done;

    public ToDo() {
    }

    public ToDo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ToDo{");
        sb.append("task='").append(task).append('\'');
        sb.append(", done=").append(done);
        sb.append('}');
        return sb.toString();
    }
}


