package com.example.demo.services;

import com.example.demo.models.Ticket;
import com.example.demo.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TicketService implements TicketRepository{
    @Autowired
    private TicketRepository ticketRepository;

    public List<Ticket> findAllById(Long id_usuario) {
        List<Ticket> listaTickets=new ArrayList<>();
        List<Ticket> tickets=ticketRepository.findAll();
        for(int i=0; i<tickets.size();i++){
            if(tickets.get(i).getUsuario().getIdUsuario()==id_usuario){
                listaTickets.add(tickets.get(i));
            }
        }
        return listaTickets;
    }

    public List<Ticket> findAllByPriority(String prioridad) {
        List<Ticket> listaTickets = new ArrayList<>();
        List<Ticket> tickets = ticketRepository.findAll();
        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).getPrioridad().equals(prioridad)) {
                listaTickets.add(tickets.get(i));
            }
        }
        return listaTickets;
    }


    public List<Ticket> findAllByEstado(String estado) {
        List<Ticket> listaTickets=new ArrayList<>();
        List<Ticket> tickets=ticketRepository.findAll();
        for(int i=0; i<tickets.size();i++){
            if(tickets.get(i).getEstado().equals(estado)){
                listaTickets.add(tickets.get(i));
            }
        }
        return listaTickets;
    }


    public void actualizarIdAnalista(Long idTicket, Long idAnalista) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(idTicket);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setIdAnalista(Math.toIntExact(idAnalista));
            ticketRepository.save(ticket);
        }
    }

    public void responderTicket(Long idTicket, String respuesta) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(idTicket);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setRespuesta(respuesta);
            ticket.setEstado("Cerrado");
            ticketRepository.save(ticket);
        }
    }
    public void apelarRespuestaTicket(Long idTicket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(idTicket);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            // Comprobar si ya hay una apelación, si no la hay, proceder a apelar
            if (!ticket.isApelacion()) {
                ticket.setApelacion(true);
                ticketRepository.save(ticket);
            }
        }
    }

    @Override
    public void flush() {
    }

    @Override
    public <S extends Ticket> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Ticket> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Ticket> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Ticket getOne(Long aLong) {
        return null;
    }

    @Override
    public Ticket getById(Long aLong) {
        return null;
    }

    @Override
    public Ticket getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Ticket> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Ticket> List<S> findAll(Example<S> example) {
        return ticketRepository.findAll(example);
    }

    @Override
    public <S extends Ticket> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Ticket> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Ticket> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Ticket> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Ticket, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Ticket> S save(S entity) {
        return ticketRepository.save(entity);
    }

    @Override
    public <S extends Ticket> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Ticket> findById(Long aLong) {
        return ticketRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<Ticket> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Ticket entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Ticket> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Ticket> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return null;
    }
}
