package com.example.demo.rest;

import com.example.demo.models.Ticket;
import com.example.demo.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Ticket/")
public class TicketRest {
    private TicketService ticketService;

    @GetMapping
    private ResponseEntity<List<Ticket>>getAllTicket(){
        return ResponseEntity.ok(ticketService.findAll());
    }
}