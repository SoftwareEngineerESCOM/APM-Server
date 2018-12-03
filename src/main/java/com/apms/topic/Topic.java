package com.apms.topic;

import javax.persistence.*;

import com.apms.subtopic.Subtopic;
import com.apms.thematicUnit.ThematicUnit;
import com.apms.topicHour.TopicHour;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private Double theoricHours;
    @Column(nullable = false)
    private Double practicalHours;
    @Column(nullable = false)
    private Double autonomousHours;
    @OneToMany
    @JoinColumn
    private List<Subtopic> subtopics;


    public Topic() {

    }
}
