package com.idemia.HiringProject.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idemia.HiringProject.DAO.ICandidateDAO;
import com.idemia.HiringProject.Entity.Candidate;
import com.idemia.HiringProject.Entity.Requirement;
import com.idemia.HiringProject.form.CandidateForm;

/**
 * 
 * @author G521742
 *
 */

@Service
public class CandidateService implements ICandidateService{
	
	@Autowired
	private ICandidateDAO candidateDAO;
	
	public List<CandidateForm> getAllCandidate() {
		return candidateDAO.getAllCandidate();
	}


	public boolean addCandidate(CandidateForm candidateForm) throws SQLException {
	     
		candidateDAO.addCandidate(populateDAOObject(candidateForm));
	    return true;
     }


	private Candidate populateDAOObject(CandidateForm candidateForm) {
		Candidate candidateObj = new Candidate();
		candidateObj.setFirstName(candidateForm.getFirstName());
		candidateObj.setLastName(candidateForm.getLastName());
		candidateObj.setMobileNumber(candidateForm.getMobileNumber());
		candidateObj.setCandidate_id(candidateForm.getPanCardNumber());
		candidateObj.setCandidateEmailID(candidateForm.getMailId());
		return candidateObj;
	}

	@Override
	public List<Candidate> getCandidateByEmailID(String candidateemailID) {
		List<Candidate> obj = candidateDAO.getCandidateByEmailID(candidateemailID);
		return obj;
	}

	@Override
	public List<Candidate> getCandidateByPanNumber(String panCard) {
		List<Candidate> obj = candidateDAO.getCandidateByPanNumber(panCard);
		return obj;
	}
	
	public void updateCandidate(CandidateForm candidate) {
		candidateDAO.updateCandidate(candidate);
		
	}
	
	public void deleteCandidate(String panCard) {
		candidateDAO.deleteCandidate(panCard);
	}
	
	@Override
	public List<String> getRequirementID() {
		 return candidateDAO.getRequirementID();
		
	}

	@Override
	public void addDetails(Candidate candidate) {
		candidateDAO.addDetails(candidate);
		
	}

	@Override
	public List<Candidate> searchCandidate(String panCard, String emailID, String status, String roundNumber, String roundStatus, String startDate, String endDate) {
		
		return candidateDAO.searchCandidate(panCard,emailID, status, roundNumber, roundStatus, startDate, endDate);
	}


	@Override
	public List<Requirement> getAllRequirement() {
		return candidateDAO.getAllRequirement();
	}


	@Override
	public void addRequirement(Requirement requirement) {
		candidateDAO.addRequirement(requirement);
		
	}


	@Override
	public List<Requirement> getRequirementById(String id) {
		System.out.println("\n\n\nid is " + id);
		List<Requirement> obj = candidateDAO.getRequirementById(id);
		return obj;
	}
	
}
