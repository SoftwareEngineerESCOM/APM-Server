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
@IdClass(LearningUnitTaskPK.class)
public class LearningUnitTask {

    @Id
    @JoinColumn
    @ManyToOne
    private LearningUnit learningUnit;
    @Id
    @JoinColumn
    @ManyToOne
    private User user;
    
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String deadLine;
    
    

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
    
    public String getDeadLine(){
        return deadLine;
    }
    
    public void setDeadLine(String deadLine){
        this.deadLine = deadLine;
    }
}
