package com.demo.personmanager.persistence.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.personmanager.dto.SearchUsersElementsResponseDTO;
import com.demo.personmanager.dto.SearchUsersRequestDTO;
import com.demo.personmanager.dto.SearchUsersResponseDTO;
import com.demo.personmanager.dto.UserDTO;
import com.demo.personmanager.entity.UserEntity;
import com.demo.personmanager.persistence.IUserPersistence;
import com.demo.personmanager.persistence.IUserPredicate;
import com.demo.personmanager.persistence.utility.UserPersistenceUtility;
import com.demo.personmanager.repository.IUserRepository;

/**
 * Implementation of {@link IUserPersistence}
 *  
 * @author Wahid Gazzah
 * @since 15/04/2016
 * 
 */

@Component
public class UserPersistenceImpl implements IUserPersistence{
	
	private static final Logger logger = LoggerFactory.getLogger(UserPersistenceImpl.class);

	@Autowired
	private IUserRepository userRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public Long create(UserDTO dto) {
		
		UserEntity entity = userRepository.save(UserPersistenceUtility.toUserEntity(dto));
		
		if(entity != null)
			return entity.getId();
		else return null;
	}

	public UserDTO getById(Long id) {
		
		UserEntity entity = userRepository.findOne(id);
		
		if(entity != null)
			return UserPersistenceUtility.toUserDTO(entity);
		else return null;
	}

	public Long update(UserDTO dto) {
		
		UserEntity entity = userRepository.save(UserPersistenceUtility.toUserEntity(dto));
		
		if(entity != null)
			return entity.getId();
		else return null;
	}

	public void delete(Long id) {
		
		userRepository.delete(id);
		
	}

	public List<UserDTO> getAll() {
		
		List<UserEntity> listEntity = userRepository.findAll();
		
		List<UserDTO> listDTO = new ArrayList<UserDTO>();
		
		if(listEntity != null){
			
			for(UserEntity entity : listEntity){
				
				listDTO.add(UserPersistenceUtility.toUserDTO(entity));
			}
		}
		
		return listDTO;
	}

	public SearchUsersResponseDTO searchUsers(SearchUsersRequestDTO request) {
		
		SearchUsersResponseDTO result = new SearchUsersResponseDTO();
		
		CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
		List<Predicate> whereClause = new ArrayList<Predicate>();
		
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		
		// Set filter.firstName on whereClause if not empty or null
		if (isNotEmpty(request.getFirstName())) {
			Expression<String> path = root.get(IUserPredicate.PREDICATE_FIRST_NAMME);
			Expression<String> upper = criteriaBuilder.upper(path);
			Predicate predicate = criteriaBuilder.like(
					upper, 
					IUserPredicate.PERCENT + request.getFirstName().toUpperCase() + IUserPredicate.PERCENT);
			whereClause.add(criteriaBuilder.and(predicate));
		}		
		
		criteriaQuery.select(root).where(whereClause.toArray(new Predicate[] {}));
		
		TypedQuery<UserEntity> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setFirstResult(request.getPageNum());
		typedQuery.setMaxResults(request.getPageSize());
	    List <UserEntity> entityResultList = typedQuery.getResultList();
	    
	    
	    // Count
	    CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
	    countQuery.select(criteriaBuilder.count(countQuery.from(UserEntity.class)));
	    Long count = entityManager.createQuery(countQuery).getSingleResult();

	    List<SearchUsersElementsResponseDTO> list = new ArrayList<SearchUsersElementsResponseDTO>();
	    
	    for (UserEntity entity : entityResultList) {
	    	SearchUsersElementsResponseDTO dto = UserPersistenceUtility.toSearchUsersElementsResponseDTO(entity);
	    	list.add(dto);
	    }

	    Collections.sort(list);
	    result.setNombreResults(Long.valueOf(list.size()));
	    result.setElements(new TreeSet<SearchUsersElementsResponseDTO>(list));
	    
	    result.setNumberElements(count);


	    return result;
	}
	
	private boolean isNotEmpty(String value) {
		return value != null && ! IUserPredicate.EMPTY_STRING.equals(value);
	}
}
