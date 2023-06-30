package com.zerobase.fastlms.admin.repository;

import com.zerobase.fastlms.admin.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
//    List<LoginHistory> findByUserIdOrderByLoginDtDesc(String userId);

}
