package com.example.demo.repositories;

import com.example.demo.models.Ticket;
import com.example.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
