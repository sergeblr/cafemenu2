package com.cafemenu.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data     // @Data = @ToString, @EqualsAndHashCode, @Getter / @Setter and @RequiredArgsConstructor together.
@Table(name = "order_d")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", updatable = false, nullable = false)
    private Integer orderId;

    @Column(name = "order_employee_id", updatable = true, nullable = false)
    private Integer orderEmployeeId;

    @CreationTimestamp
    @Column(name = "order_date_time", updatable = false, nullable = false)
    private LocalDateTime orderDateTime;

    @OneToMany(mappedBy = "iio_order_id", fetch = FetchType.LAZY)        // cascade = CascadeType.ALL -> ALL operations will be on related entities, by default - no any operations will be...
    private List<ItemInOrder> iio;


}
