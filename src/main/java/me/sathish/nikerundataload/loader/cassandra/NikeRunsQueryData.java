package me.sathish.nikerundataload.loader.cassandra;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

//@javax.persistence.Entity

@Data
@Table(value = "nikerunsloader")
public class NikeRunsQueryData {

    @Id
    @PrimaryKeyColumn(name = "run_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long id;
    @Column("run_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;
    @Column("start_time")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private Long start_time;
    @Column("end_time")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private Long end_time;
    private Integer activeDurationMS;
    private Integer totalSteps;
    private Double totalDistance;
    private Double averagePace;
    private Double averageHeartRate;
    private Double totalCalories;

    public NikeRunsQueryData() {
    }

    public Integer getActiveDurationMS() {
        return activeDurationMS;
    }

    public void setActiveDurationMS(Integer activeDurationMS) {
        this.activeDurationMS = activeDurationMS;
    }

    public Integer getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(Integer totalSteps) {
        this.totalSteps = totalSteps;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public Double getAveragePace() {
        return averagePace;
    }

    public void setAveragePace(Double averagePace) {
        this.averagePace = averagePace;
    }

    public Double getAverageHeartRate() {
        return averageHeartRate;
    }

    public void setAverageHeartRate(Double averageHeartRate) {
        this.averageHeartRate = averageHeartRate;
    }

    public Double getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(Double totalCalories) {
        this.totalCalories = totalCalories;
    }
}
