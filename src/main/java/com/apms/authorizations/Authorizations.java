package com.apms.authorizations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.apms.humanResource.HumanResource;
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
    private HumanResource elaboratedBy;
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
	@JoinColumn(nullable = false)
	private SyntheticProgram syntheticProgram;

    public Authorizations() {
        
    }
}
