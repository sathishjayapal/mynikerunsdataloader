package me.sathish.nikerundataload.loader;

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
public class NikeRunsData {

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

    public NikeRunsData() {
    }
}
