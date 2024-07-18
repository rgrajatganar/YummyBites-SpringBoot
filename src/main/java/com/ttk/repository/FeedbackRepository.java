package com.ttk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttk.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
