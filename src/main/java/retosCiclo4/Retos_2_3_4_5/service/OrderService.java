/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retosCiclo4.Retos_2_3_4_5.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retosCiclo4.Retos_2_3_4_5.model.Orders;
import retosCiclo4.Retos_2_3_4_5.repository.OrderRepository;

/**
 *
 * @author USUARIO
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Orders> getAll(){
        return orderRepository.getAll();
    }

    public Optional<Orders> getOrder(Integer id){
        return orderRepository.getOrder(id);
    }

    public Orders create(Orders order){
        if (order.getId() == null){
            return order;
        } else {
            return orderRepository.create(order);
        }
    }

    public Orders update(Orders order){
        if (order.getId() != null){
            Optional<Orders> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()) {

                if (order.getId() != null) {
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null) {
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null) {
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null) {
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null) {
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null) {
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id){
        return getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
    }

    public List<Orders> getOrderByZone(String zone){
        return orderRepository.getOrderByZone(zone);
    }

    public List<Orders> getBySalesManId(Integer id){
        return  orderRepository.getBySalesManId(id);
    }

    public List<Orders> getBySalesManIdAndStatus(Integer id, String status){
        return orderRepository.getBySalesManIdAndStatus(id, status);
    }

    public List<Orders> getRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay,id);
    }

}
