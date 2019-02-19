package com.idemia.HiringProject.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idemia.HiringProject.Entity.Candidate;
import com.idemia.HiringProject.Entity.Interview;
import com.idemia.HiringProject.Entity.Requirement;
import com.idemia.HiringProject.form.CandidateForm;

@Transactional
@Repository

public class CandidateDAO implements ICandidateDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Candidate getCandidateById(int id) {
		return entityManager.find(Candidate.class, id);
	}

	public List<Candidate> getCandidateByPanNumber(String panCard) {
		String hql = "FROM Candidate as can WHERE can.candidate_id= ?";
		List<Candidate> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).setParameter(1, panCard).getResultList();
		// Query data = entityManager.createQuery(hql).setParameter(1, panCard);
		// System.out.println(data);
		return ls;
	}

	public List<Candidate> getCandidateByEmailID(String candidateemailID) {
		String hql = "FROM Candidate as can WHERE can.candidateEmailID= ? ";
		List<Candidate> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).setParameter(1, candidateemailID).getResultList();

		return ls;
	}

	public List<CandidateForm> getAllCandidate() {
		String hql = "FROM Candidate as can";
		List<CandidateForm> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).getResultList();
		return ls;
	}

	public String addCandidate(Candidate candidate) throws SQLException {
		try {
			entityManager.persist(candidate);

		} catch (Exception e) {
			// TODO Log the database Exception
			e.printStackTrace();
		}
		return null;
	}

	public void updateCandidate(CandidateForm candidate) {
		List<Candidate> can = getCandidateByPanNumber(candidate.getPanCardNumber());
		Candidate c = can.get(0);
		c.setFirstName(candidate.getFirstName());
		c.setLastName(candidate.getLastName());
		c.setCandidateEmailID(candidate.getMailId());
		c.setMobileNumber(candidate.getMobileNumber());
		entityManager.flush();
	}

	public void deleteCandidate(String panCard) {
		entityManager.remove(getCandidateByPanNumber(panCard));
	}

	@Override
	public List<String> getRequirementID() {
		String hql = "SELECT R.id FROM Requirement R where R.status like 'Open'";
		// List<String> ls=new ArrayList<>();
		List<String> ls = entityManager.createQuery(hql).getResultList();
		// System.out.println("Hello");
		// System.out.println(entityManager.createQuery(hql).getResultList());
		
		for(String s: ls)
		{
			System.out.println(s);
		}
		
		return ls;
	}

	@Override
	public void addDetails(Candidate candidate) {

		Interview interview=new Interview();
		interview.setCandidate(candidate);
		//interview.setStatus(candidate.getStatus());
		
		candidate.setInterview(interview);
		
		entityManager.persist(candidate);
		
	}
	private CriteriaBuilder buildCriteriaQuery(){
		return entityManager.getCriteriaBuilder();
	}

	@Override
	public List<Candidate> searchCandidate(String panCard, String emailID, String status, String roundNumber, String roundStatus,String startDate,String endDate) {
		
		CriteriaBuilder cb=buildCriteriaQuery();
		CriteriaQuery<Candidate> criteria = cb.createQuery(Candidate.class);
		Root<Candidate>root = criteria.from(Candidate.class);
		criteria.select(root);
		List<Predicate> predicates=buildPredicate(cb,root,panCard,emailID,status,roundNumber, roundStatus,startDate,endDate);
		Predicate[] arrPredicate=new Predicate[predicates.size()];
		predicates.toArray(arrPredicate);
		criteria.where(arrPredicate);
		criteria.isDistinct();
		TypedQuery<Candidate> query=entityManager.createQuery(criteria);
		return query.getResultList();
	}
	
	private List<Predicate> buildPredicate(CriteriaBuilder cb,Root<Candidate>root,
			String panCard,String emailID,String status,String roundNumber,String roundStatus,String startDate,String endDate){
		  List<Predicate> predicates=new ArrayList<Predicate>();
		  
			Predicate datePredicate=null;
			
			if( startDate == "" && endDate == "" && panCard == "" && emailID == "" && status == "" && roundNumber == "" && roundStatus == "") {
				return null;
			}
			
			else {
				
			if( startDate!=null && endDate!=null && startDate!="" && endDate!="" ){
				datePredicate=cb.and(
						cb.between(root.<String>get("dateOfEntry"), startDate, endDate)
						);
				predicates.add(datePredicate);
			}
			    if(panCard!=null && panCard!=""){
				Predicate panCardPredicate=cb.and(
				cb.equal(root.<String>get("candidate_id"),panCard)
				);
				predicates.add(panCardPredicate);
			}
			    
			 if(emailID!=null && emailID!="") {
				 Predicate   emailIDCardPredicate=cb.and(
							cb.equal(root.<String>get("candidateEmailID"),emailID)
							);
							predicates.add(emailIDCardPredicate);
			 }

			 if(status!=null && status!="") {
				 Predicate statusCardPredicate=cb.and(
						 cb.equal(root.<String>get("status"),status)
						 );
				 predicates.add(statusCardPredicate);
			 }
			 Join<Candidate,Interview> interview=null;
			 
			 if("1".equals(roundNumber)) {
				interview=root.join("interview",JoinType.INNER);
				 Predicate roundNumberPredicate=cb.and(
						 cb.isNotNull(interview.<String>get("firstLevelName")),
						 cb.isNull(interview.<String>get("secondLevelName")),
						 cb.isNull(interview.<String>get("thirdLevelName"))
						 );
				 predicates.add(roundNumberPredicate);
				   if(roundStatus!=null ) {
					   Predicate roundStatusPredicate=cb.and(
								 cb.equal(interview.<String>get("firstLevelFeedback"),roundStatus)
						 );
					   predicates.add(roundStatusPredicate);
				   }
			 }
			 
			 
			 if("2".equals(roundNumber)) {
				interview=root.join("interview",JoinType.INNER);
				 Predicate roundNumberPredicate=cb.and(
						 cb.isNotNull(interview.<String>get("firstLevelName")),
						 cb.isNotNull(interview.<String>get("secondLevelName")),
						 cb.isNull(interview.<String>get("thirdLevelName"))
						 );
				 predicates.add(roundNumberPredicate);
				  if(roundStatus!=null ) {
					   Predicate roundStatusPredicate=cb.and(
								 cb.equal(interview.<String>get("secondLevelFeedback"),roundStatus)
						 );
					   predicates.add(roundStatusPredicate);
				   }
			 }
			 
			 
			 if("3".equals(roundNumber)) {
				 interview=root.join("interview",JoinType.INNER);
				 Predicate roundNumberPredicate=cb.and(
						 cb.isNotNull(interview.<String>get("firstLevelName")),
						 cb.isNotNull(interview.<String>get("secondLevelName")),
						 cb.isNotNull(interview.<String>get("thirdLevelName"))
						 );
				 predicates.add(roundNumberPredicate);
				  if(roundStatus!=null ) {
					   Predicate roundStatusPredicate=cb.and(
								 cb.equal(interview.<String>get("thirdLevelFeedback"),roundStatus)
						 );
					   predicates.add(roundStatusPredicate);
				   }
			 }
			
			return predicates;
			}
	}

	@Override
	public List<Requirement> getAllRequirement() {
		String hql = "FROM Requirement as req";
		List<Requirement> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).getResultList();
		return ls;
	}

	@Override
	public void addRequirement(Requirement requirement) {
		
		requirement.setStatus("Open");
		
		entityManager.persist(requirement);
		
		
	}

	@Override
	public List<Requirement> getRequirementById(String id) {
		String hql = "FROM Requirement as req WHERE req.id= ?";
		List<Requirement> ls = new ArrayList<>();
		ls = entityManager.createQuery(hql).setParameter(1, id).getResultList();
		// Query data = entityManager.createQuery(hql).setParameter(1, panCard);
		// System.out.println(data);
		return ls;
	}


}