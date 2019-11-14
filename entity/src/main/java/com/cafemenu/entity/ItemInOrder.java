package com.cafemenu.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * DROP TABLE IF EXISTS order_d;
 * CREATE TABLE order_d (
 *   order_id INT NOT NULL AUTO_INCREMENT,
 *   employee_id INT NOT NULL,
 *   order_date_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
 *   PRIMARY KEY (order_id)
 * );
 *
 * DROP TABLE IF EXISTS item_in_order;
 * CREATE TABLE item_in_order (
 *   iio_order_id INT NOT NULL,
 *   iio_item_id INT NOT NULL,
 *   iio_item_name VARCHAR(255) NOT NULL,
 *   iio_item_price DECIMAL NOT NULL,
 *   iio_item_count INT NOT NULL,
 *   PRIMARY KEY (iio_order_id, iio_item_id),
 *   FOREIGN KEY (iio_order_id) REFERENCES order_d(order_id) ON DELETE CASCADE
 * );
 */

@Entity
@IdClass(IioKey.class)      // Link to CompositeKey class
@Data                   // @Data = @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
@Table(name = "item_in_order")
public class ItemInOrder {

    //@Column(name = "iio_order_id", updatable = true, nullable = false)
    @ManyToOne(targetEntity = OrderD.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "iio_order_id", referencedColumnName = "order_id")
    private OrderD order_iio;

    @Id
    @Column(name = "iio_order_id", updatable=false, insertable=false, nullable = false)
    private Integer iioOrderId;

    @Id
    @Column(name = "iio_item_id", updatable = true, nullable = false)
    private Integer iioItemId;

    @Column(name = "iio_item_name", updatable = true, nullable = false)
    private String iioItemName;

    @Column(name = "iio_item_price", updatable = true, nullable = false)
    private BigDecimal iioItemPrice;

    @Column(name = "iio_item_count", updatable = true, nullable = false)
    private Integer iioItemCount;


}
