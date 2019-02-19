package com.idemia.HiringProject.DAO;
import java.sql.SQLException;
import java.util.List;

import com.idemia.HiringProject.Entity.Candidate;
import com.idemia.HiringProject.Entity.Requirement;
import com.idemia.HiringProject.form.CandidateForm;

public interface ICandidateDAO {
	
    List<CandidateForm> getAllCandidate();
    
    Candidate getCandidateById(int candidateId);
    
    public String addCandidate(Candidate candidate) throws SQLException;
    
    
    public List<Candidate> getCandidateByEmailID(String candidateemailID);
    
    public List<Candidate> getCandidateByPanNumber(String panCard);

    public void updateCandidate(CandidateForm candidate);

	void deleteCandidate(String panCard);

	public List<String> getRequirementID();

	void addDetails(Candidate candidate);
	
	//interview
	//public List<Candidate> getCandidateByRoundNumber(String roundNumber);

	List<Candidate> searchCandidate(String panCard, String emailID, String status, String roundNumber, String roundStatus,String startDate, String endDate);

	List<Requirement> getAllRequirement();

	void addRequirement(Requirement requirement);

	List<Requirement> getRequirementById(String id);



    
} 