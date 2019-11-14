package com.cafemenu.repository;

import com.cafemenu.DTO.OrderDTO;
import com.cafemenu.entity.OrderD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDRepository extends JpaRepository<OrderD, Integer> {

    // Implemented: findById(id), findAll, deleteById(id), save(Item)

    // Additive to basic CRUD:
    Optional<OrderD> findOrderDByOrderId(Integer orderId);

    @Query(value = "select o.order_id as orderId, o.employee_id as employeeId," +
            " o.order_date_time as orderDateTime, sum(iio.iio_item_count) as itemsQuantity," +
            " sum(iio.iio_item_price * iio.iio_item_count) as summaryPrice from order_d o" +
            " left join item_in_order iio on o.order_id = iio.iio_order_id group by o.order_id order by o.order_id",
            nativeQuery = true)
    List<OrderDTO> findAllDTO();

    @Query(value = "select o.order_id as orderId, o.employee_id as employeeId," +
            " o.order_date_time as orderDateTime, sum(iio.iio_item_count) as itemsQuantity," +
            " sum(iio.iio_item_price * iio.iio_item_count) as summaryPrice from order_d o" +
            " left join item_in_order iio on o.order_id = iio.iio_order_id" +
            " where order_date_time between :orderDateTimeStart AND :orderDateTimeEnd" +
            " group by o.order_id order by o.order_id",
            nativeQuery = true)
    List<OrderDTO> findOrdersDTOByDateTime(
            @Param("orderDateTimeStart") LocalDateTime startDateTime,
            @Param("orderDateTimeEnd") LocalDateTime endDateTime);

}
