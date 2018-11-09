package com.github.godndas2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.godndas2.Diary;
/**
 * 
 * JpaRepository Interface를 확장해서 JPA 기술 구현
 *
 */
public interface DiaryInterface extends JpaRepository<Diary,Long>{}
