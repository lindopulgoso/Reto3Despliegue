package com.JACardonaJ.reto_3.Service;

import com.JACardonaJ.reto_3.Model.Reservation;
import com.JACardonaJ.reto_3.Model.personalizado.CountClient;
import com.JACardonaJ.reto_3.Model.personalizado.StatusAmount;
import com.JACardonaJ.reto_3.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return  reservationRepository.getAll();

    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }
    public  Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return  reservationRepository.save(reservation);
        }else{
            Optional<Reservation> ReservationEncontrado=getReservation(reservation.getIdReservation());
            if(ReservationEncontrado.isPresent()){
                return  reservationRepository.save(reservation);
            } else {
                return reservation;

            }
        }
    }

    public  Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> ReservationEncontrado=getReservation(reservation.getIdReservation());
            if(!ReservationEncontrado.isPresent()){
                if(reservation.getStartDate()!=null){
                    ReservationEncontrado.get().setStartDate(reservation.getStartDate());
                }        if(reservation.getDevolutionDate()!=null){
                    ReservationEncontrado.get().setDevolutionDate(reservation.getDevolutionDate());
                } if(reservation.getStatus()!=null){
                    ReservationEncontrado.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(ReservationEncontrado.get());

            }
        }
        return reservation;
    }

    public  boolean delete(int id){
        boolean respuesta=getReservation(id).map(elemento -> {
            reservationRepository.delete(elemento);
            return true;
        }).orElse(false);
        return  respuesta;

    }

    public  List<CountClient> getTopClients(){

        return  reservationRepository.getTopClients();
    }
    public StatusAmount getReservationStatusReport(){
        List<Reservation> completed= reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled= reservationRepository.getReservationByStatus("cancelled");
        return  new StatusAmount(completed.size(),cancelled.size());
    }
    public  List<Reservation> getReservationPeriod(String dateA,String dateB){
        SimpleDateFormat parser= new SimpleDateFormat("yyyy-MM-dd");
        Date a=new Date();
        Date b=new Date();
        try {
            a=parser.parse(dateA);
            b=parser.parse(dateA);


        }catch (ParseException e){
            e.setStackTrace(e.getStackTrace());
        } if(a.before(b)){
            return  reservationRepository.getReservationPeriod(a,b);
        }else {
            return  new ArrayList<>();
        }


    }
}
