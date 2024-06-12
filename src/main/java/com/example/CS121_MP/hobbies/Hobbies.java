package com.example.CS121_MP.hobbies;


import com.example.CS121_MP.members.Members;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table
public class Hobbies {

    @Id
    @SequenceGenerator(
            name = "hobbies_sequence",
            sequenceName = "hobbies_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hobbies_sequence"
    )

    private long id;
    private String name;
    private String description;
    private String media;

    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    @JsonBackReference
    private Members members;

    public Hobbies() {
    }

    public Hobbies(String name, String description, String media, Members members) {
        this.name = name;
        this.description = description;
        this.media = media;
        this.members = members;
    }

    @Override
    public String toString() {
        return "Hobbies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", media='" + media + '\'' +
                ", members=" + members +
                '}';
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }
}
