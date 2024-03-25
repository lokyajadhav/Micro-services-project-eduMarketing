package com.marketing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marketing.models.MarketingManager;
@Repository
public interface ManagerRepo extends JpaRepository<MarketingManager, Long> {

}
