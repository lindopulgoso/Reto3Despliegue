package com.JACardonaJ.reto_3.Repository.RepositoryCrudRepository;

import com.JACardonaJ.reto_3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
    @Query("SELECT  c.client, COUNT (c.client) FROM  Reservation  AS c group by  c.client order by  COUNT(c.client) DESC ")
    public List<Object[]> countTotalReservationsByClient();
    public List<Reservation> findAllByStatus(String status);
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateone, Date datetwo);
}
