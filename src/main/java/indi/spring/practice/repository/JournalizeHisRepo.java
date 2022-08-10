package indi.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import indi.spring.practice.entity.JournalizeHis;
import indi.spring.practice.entity.JournalizeHisPK;

@Repository
public interface JournalizeHisRepo extends JpaRepository<JournalizeHis, JournalizeHisPK>{

}
