/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.interfaces;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import retosCiclo4.Retos_2_3_4_5.model.Orders;

/**
 *
 * @author USUARIO
 */
public interface OrderInterface extends MongoRepository<Orders, Integer>{
    //@Query("{'salesMan.zone': ?0}")
    //List<Orders> findByZone(final String zone);
    //@Query("{status: ?0}")
    //List<Orders> findByStatus(final String status);
    //Optional<Orders> findTopByOrderByIdDesc();
    List<Orders> findBySalesManZone(String zone);
    List<Orders> findBySalesManId(Integer id);
    List<Orders> findBySalesManIdAndStatus(Integer id, String status);
    List<Orders> findByRegisterDayAndSalesManId(Date registerDay, Integer id);
}
