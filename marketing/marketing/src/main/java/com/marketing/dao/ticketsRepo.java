package com.marketing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marketing.models.Tickets;

import jakarta.transaction.Transactional;
@Repository
public interface ticketsRepo extends JpaRepository<Tickets, Long> {

	@Modifying
	@Transactional
	@Query(value="Update tickets set marketing_manager_id=:marketing_manager_id where ticket_id=:ticket_id", nativeQuery = true)
	Object assignTicket(long ticket_id, long marketing_manager_id);

}
