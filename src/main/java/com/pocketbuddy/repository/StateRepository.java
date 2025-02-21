package com.pocketbuddy.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.pocketbuddy.entity.StateEntity;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer>{

}
