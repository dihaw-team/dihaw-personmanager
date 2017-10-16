package com.demo.personmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.personmanager.entity.UserEntity;
import com.demo.personmanager.persistence.IUserPersistence;

/**
 * IUserRepository
 *  
 * @author Wahid Gazzah
 * @since 15/04/2016
 * 
 */

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {

}
