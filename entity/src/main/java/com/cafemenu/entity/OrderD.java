package com.cafemenu.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data     // @Data = @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
@Table(name = "order_d")
public class OrderD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", updatable = false, nullable = false)
    private Integer orderId;

    @Column(name = "order_employee_id", updatable = true, nullable = false)
    private Integer orderEmployeeId;

    @Column(name = "order_date_time", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime orderDateTime;

    @OneToMany(mappedBy = "order_iio", fetch = FetchType.LAZY)      // fetch = FetchType.LAZY -> List IIO loads only by demand
    private List<ItemInOrder> itemInOrders;                            // cascade = CascadeType.ALL -> ALL operations will be on related entities, by default - no any operations will be...


}
