package com.apms.topic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.apms.thematicUnit.ThematicUnit;
import com.apms.topicHour.TopicHour;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Topic{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
	@Column(nullable = false)
    private String name;
	@Column(nullable = false)
    private String number;
    @ManyToOne
    @JoinColumn(nullable=false)
    private ThematicUnit thematicUnit;
    @OneToOne
    @JoinColumn(nullable=false)
    private TopicHour topicHour;
    
    public Topic(){
    
    }
}
