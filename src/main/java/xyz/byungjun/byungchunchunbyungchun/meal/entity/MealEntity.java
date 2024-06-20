package xyz.byungjun.byungchunchunbyungchun.meal.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Primary;
import xyz.byungjun.byungchunchunbyungchun.core.entity.BaseEntity;
import xyz.byungjun.byungchunchunbyungchun.meal.dto.MealDTO;

import java.time.LocalDate;

@Entity
@Table(name = "meal")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MealEntity extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String time;
    @Column(nullable = false)
    private String meal;
    @Column(nullable = false)
    private Double calorie;

    public MealDTO toMealDTO() {
        return MealDTO.builder()
                .date(date)
                .time(time)
                .meal(meal)
                .calorie(calorie)
                .build();
    }
}
