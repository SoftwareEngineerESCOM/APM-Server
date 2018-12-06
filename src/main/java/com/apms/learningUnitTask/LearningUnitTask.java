package com.apms.learningUnitTask;

import com.apms.learningUnit.LearningUnit;
import com.apms.user.User;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class LearningUnitTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @JoinColumn
    @ManyToOne
    private LearningUnit learningUnit;
    @JoinColumn
    @ManyToOne
    private User user;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = true)
    private String deadline;
    
    

    public LearningUnitTask() {
        
    }
    
    public LearningUnit getLearningUnit(){
        return learningUnit;
    }
    
    public void setLearningUnit(LearningUnit learningUnit){
        this.learningUnit = learningUnit;
    }
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    public String getStartDate(){
        return startDate;
    }
    
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    public String getDeadline(){
        return deadline;
    }
    
    public void setDeadLine(String deadLine){
        this.deadline = deadline;
    }
}
