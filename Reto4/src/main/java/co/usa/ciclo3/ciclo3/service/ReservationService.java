package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Cloud;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    //Metodo GET
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    //Metdo GET por ID
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    //Metodo POST
    public Reservation save(Reservation r){
        if (r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> reaux=reservationRepository.getReservation(r.getIdReservation());
            if (reaux.isEmpty()){
                return reservationRepository.save(r);
            }else {
                return r;
            }
        }
    }
}
