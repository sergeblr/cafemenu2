package com.epam.summer19.webappvdn8.consumers;

import com.epam.summer19.dto.OrderDTO;
import com.epam.summer19.model.Order;
import com.epam.summer19.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Order Consumer (for REST)
 */

public class OrderRestConsumer implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRestConsumer.class);

    private String url;

    private RestTemplate restTemplate;

    /**
     * OrderRestConsumer constructor.
     * @param url
     * @param restTemplate
     */
    public OrderRestConsumer(String url, RestTemplate restTemplate) {
        this.url = url;
        this.restTemplate = restTemplate;
    }

    /**
     * findAll() - get all orders
     * @return
     */
    @Override
    public List<Order> findAll() {
        LOGGER.debug("OrderRestConsumer: findAll()");
        Order[] orders = restTemplate.getForEntity(url, Order[].class).getBody();
        return Arrays.asList(orders);
    }

    @Override
    public List<OrderDTO> findAllDTO() {
        LOGGER.debug("OrderRestConsumer: findAllDTO()");
        OrderDTO[] orderDTOs = restTemplate.getForEntity(url+"dto", OrderDTO[].class).getBody();
        return Arrays.asList(orderDTOs);
    }

    /**
     * add() new order.
     * @param
     */
    @Override
    public Order add(Order order) {
        LOGGER.debug("OrderRestConsumer: add({})", order);
        return restTemplate.postForEntity(url, order, Order.class).getBody();
    }

    /**
     * update() order
     * @param
     */
    @Override
    public void update(Order order) {
        LOGGER.debug("OrderRestConsumer: update({})", order);
        restTemplate.put(url, order);

    }

    /**
     * delete() order
     * @param
     */
    @Override
    public void delete(Integer orderId) {
        LOGGER.debug("OrderRestConsumer: delete({})", orderId);
        restTemplate.delete(url + "/" + orderId);
    }

    /**
     * findOrderById() order
     * @param orderId
     * @return
     */
    @Override
    public Order findOrderById(Integer orderId) {
        LOGGER.debug("OrderRestConsumer: findOrderById({})", orderId);
        return restTemplate.getForEntity(url + "/" + orderId, Order.class).getBody();
    }

    /**
     * findOrderByDateTime()
     * @param startDateTime
     * @param endDateTime
     * @return
     */
    @Override
    public List<OrderDTO> findOrdersDTOByDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        LOGGER.debug("OrderRestConsumer: findOrdersDTOByDateTime({},{})", startDateTime, endDateTime);
        OrderDTO[] orderDTOs = restTemplate.getForEntity(
                url + "dto/" + startDateTime + ":00/" + endDateTime + ":00", OrderDTO[].class).getBody();
        return Arrays.asList(orderDTOs);
    }

}