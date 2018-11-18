package com.apms.attitude;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import lombok.Getter;   
import lombok.Setter;

@Getter
@Setter
@Entity
public class Attitude{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    
    @Column(nullable = false)
    private String name;

    public Attitude(){
    
    }
}