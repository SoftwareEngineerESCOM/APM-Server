package com.apms.authorizations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.apms.humanResource.HumanResource;
import com.apms.academy.Academy;
import com.apms.syntheticProgram.SyntheticProgram;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Authorizations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(nullable = false)
    private Academy elaboratedBy;
    @OneToOne
    @JoinColumn(nullable = false)
	private HumanResource revisedBy;
	@OneToOne
	@JoinColumn(nullable = false)
	private HumanResource authorizedBy;
	@OneToOne
	@JoinColumn(nullable = false)
	private HumanResource approvedBy;
    
    @OneToOne
	@JoinColumn
	private SyntheticProgram syntheticProgram;

    public Authorizations() {
        
    }

	public Authorizations(Academy elaboratedBy, HumanResource revisedBy, HumanResource authorizedBy,
			HumanResource approvedBy, SyntheticProgram syntheticProgram) {
		super();
		this.elaboratedBy = elaboratedBy;
		this.revisedBy = revisedBy;
		this.authorizedBy = authorizedBy;
		this.approvedBy = approvedBy;
		this.syntheticProgram = syntheticProgram;
	}

	
}
