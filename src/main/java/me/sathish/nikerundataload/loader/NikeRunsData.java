package me.sathish.nikerundataload.loader;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

//@javax.persistence.Entity
@Table(value = "nikerunsloader")
public class NikeRunsData {

    @Id
    @PrimaryKeyColumn(name = "run_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long id;
    @Column("run_name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;

    public NikeRunsData() {
    }

    public NikeRunsData(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NikeRunsData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
