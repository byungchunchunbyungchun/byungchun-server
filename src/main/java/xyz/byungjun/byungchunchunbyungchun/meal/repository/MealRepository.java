package xyz.byungjun.byungchunchunbyungchun.meal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.byungjun.byungchunchunbyungchun.meal.entity.MealEntity;

import java.time.LocalDate;
import java.util.List;

public interface MealRepository  extends JpaRepository<MealEntity, Long> {

    List<MealEntity> findAllByDate(LocalDate date);
}
