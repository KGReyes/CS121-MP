package com.example.CS121_MP.members;

import com.example.CS121_MP.hobbies.Hobbies;
import com.example.CS121_MP.music.Music;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table
public class Members {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )

    private long id;
    private String name;
    private String username;
    private LocalDate dob;

    @Transient
    private int age;

    //Map to the other categories here
    @OneToMany (mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Hobbies> hobbies;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Music> music;

    //NoArg Constructor
    public Members() {
    }


    //Database Constructor
    public Members(String name, String username, LocalDate dob) {
        this.name = name;
        this.username = username;
        this.dob = dob;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
