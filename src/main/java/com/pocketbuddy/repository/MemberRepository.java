package com.pocketbuddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pocketbuddy.entity.MemberEntity;

@Repository

public interface MemberRepository extends JpaRepository<MemberEntity, Integer>{

}
