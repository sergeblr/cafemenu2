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

@PropertySource("classpath:sql.properties")
@Repository
public interface OrderDRepository extends JpaRepository<OrderD, Integer> {

    @Value("${order.findOrdersDTOByDateTime}")
    private String findOrdersDTOByDateTimeSql;

    @Value("${orderDTO.findAllWithSum}")
    private String findAllDTOSql;

    // Implemented: findById(id), findAll, deleteById(id), save(Item)

    // Additive to basic CRUD:
    Optional<OrderD> findOrderDByOrderId(Integer orderId);

    @Query(findAllDTOSql)
    List<OrderDTO> findAllDTO();

    @Query(findOrdersDTOByDateTimeSql)

    List<OrderDTO> findOrdersDTOByDateTime(
            @Param("orderDateTimeStart") LocalDateTime startDateTime,
            @Param("orderDateTimeEnd") LocalDateTime endDateTime);

}
