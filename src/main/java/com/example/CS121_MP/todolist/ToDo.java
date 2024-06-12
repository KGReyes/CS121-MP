package com.example.CS121_MP.todolist;

import jakarta.persistence.*;

@Entity
@Table
public class ToDo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )

    private long id;
    private String category;
    private String job;
    private String description;
    private boolean done;

    public ToDo() {
    }

    public ToDo(String category, String job, String description) {
        this.category = category;
        this.job = job;
        this.description = description;
        //this.members = members;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", job='" + job + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                //", members=" + members +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

//    public Members getMembers() {
//        return members;
//    }
//
//    public void setMembers(Members members) {
//        this.members = members;
//    }
}
