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

	public Topic(Integer id, String name, String number, Double theoricHours, Double practicalHours,
			Double autonomousTheoreticalHours, Double autonomousPracticalHours, List<Subtopic> subtopics) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.theoricHours = theoricHours;
		this.practicalHours = practicalHours;
		this.subtopics = subtopics;
	}
}
