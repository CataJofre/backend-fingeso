package com.example.demo.rest;

import com.example.demo.models.Ticket;
import com.example.demo.models.Usuario;
import com.example.demo.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Ticket/")
public class TicketRest {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    private ResponseEntity<List<Ticket>> getAllTicket() {
        return ResponseEntity.ok(ticketService.findAll());
    }

    @PostMapping("/saveTicket")
    private ResponseEntity<Ticket> saveTicket(@RequestBody Ticket ticket){
        try {
            Ticket ticketGuardado = ticketService.save(ticket);
            return ResponseEntity.created(new URI("/Ticket/"+ticketGuardado.getIdTicket())).body(ticketGuardado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/asignarAnalista")
    public void asignarAnalista(@RequestParam("idAnalista") Long idAnalista, @RequestBody Ticket ticket) {
        ticketService.asignarAnalista((long) ticket.getIdTicket(), idAnalista);
    }

    @GetMapping("/Id/{id}")
    private ResponseEntity<List<Ticket>> getAllTicketsById(@PathVariable("id") Long id_usuario) {
        return ResponseEntity.ok(ticketService.findAllById(id_usuario));
    }

    @GetMapping("/Priority/{priority}")
    private ResponseEntity<List<Ticket>> getAllTicketsByPriority(@PathVariable("priority") String priority) {
        return ResponseEntity.ok(ticketService.findAllByPriority(priority));
    }

    @GetMapping("/Estado/{estado}")
    private ResponseEntity<List<Ticket>> getAllTicketsByEstado(@PathVariable("estado") String estado) {
        return ResponseEntity.ok(ticketService.findAllByEstado(estado));
    }

    @PostMapping("/Responder/{idTicket}")
    public ResponseEntity<String> responderTicket(@PathVariable Long idTicket, @RequestBody String respuesta, @RequestBody String estado) {
        ticketService.responderTicket(idTicket, respuesta, estado);
        return ResponseEntity.ok("Ticket respondido exitosamente");
    }
    @PostMapping("/Apelar/{idTicket}")
    public ResponseEntity<String> apelarRespuestaTicket(@PathVariable Long idTicket, @RequestBody String descripcion) {
        ticketService.apelarRespuestaTicket(idTicket, descripcion);
        return ResponseEntity.ok("Apelación realizada con éxito");
    }

    @PostMapping("/CambiarPrioridad/{ticketId}")
    public ResponseEntity<String> cambiarPrioridad(@PathVariable Long ticketId, @RequestBody String nuevaPrioridad) {
        ticketService.cambiarPrioridad(ticketId, nuevaPrioridad);
        return ResponseEntity.ok("Prioridad del ticket cambiada exitosamente");
    }
    @PostMapping("/ActualizarEstado/{idTicket}")
    public ResponseEntity<String> actualizarEstadoTicket(@PathVariable Long idTicket, @RequestBody String estado) {
        ticketService.actualizarEstadoTicket(idTicket, estado);
        return ResponseEntity.ok("Estado del ticket actualizado correctamente");
    }



}