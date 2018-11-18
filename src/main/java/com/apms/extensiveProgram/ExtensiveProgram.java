package com.apms.extensiveProgram;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.apms.assignedTime.AssignedTime;
import com.apms.modality.Modality;
import com.apms.teaching.Teaching;
import com.apms.teachingProfile.TeachingProfile;
import com.apms.type.Type;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class ExtensiveProgram{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;    
    @ManyToMany
    @JoinColumn(nullable=false)
    private List<Type> types;
    @OneToOne
	@JoinColumn(nullable = false)
    private AssignedTime assignedTime;
    @OneToOne
	@JoinColumn(nullable = false)
    private TeachingProfile teachingProfile;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Modality modality;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Teaching teaching;
    
    public ExtensiveProgram(){
    }
}
