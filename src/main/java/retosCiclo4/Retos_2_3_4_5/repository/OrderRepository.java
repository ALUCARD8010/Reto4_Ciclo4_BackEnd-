/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import retosCiclo4.Retos_2_3_4_5.interfaces.OrderInterface;
import retosCiclo4.Retos_2_3_4_5.model.Orders;

/**
 *
 * @author USUARIO
 */

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderInterface orderCrudRepository;

    public List<Orders> getAll(){
        return orderCrudRepository.findAll();
    }

    public Optional<Orders> getOrder(Integer id){
        return orderCrudRepository.findById(id);
    }

    public Orders create(Orders order){
        return orderCrudRepository.save(order);
    }

    public void update(Orders order){
        orderCrudRepository.save(order);
    }

    public void delete(Orders order){
        orderCrudRepository.delete(order);
    }

    public List<Orders> getOrderByZone(String zone){
        return orderCrudRepository.findBySalesManZone(zone);
    }

    public List<Orders> getBySalesManId(Integer id){
        return orderCrudRepository.findBySalesManId(id);
    }

    public List<Orders> getBySalesManIdAndStatus(Integer id, String status){
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Orders> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return orderCrudRepository.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
