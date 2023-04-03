package me.sathish.nikerundataload.loader.jpa;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "nikerundata")
@Data

public class NikeRunsDBData {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;
    @Column(name = "run_name")
    private String name;
    @Column(name = "run_start_time")
    private Long start_time;
    @Column(name = "run_end_time")
    private Long end_time;
    @Column(name = "run_active_duration")
    private Integer activeDurationMS;
    @Column(name = "run_total_steps")
    private Integer totalSteps;
    @Column(name = "run_total_distance")
    private Double totalDistance;
    @Column(name = "run_average_pace")
    private Double averagePace;
    @Column(name = "run_average_heart_rate")
    private Double averageHeartRate;
    @Column(name = "run_total_calories")
    private Double totalCalories;
}
