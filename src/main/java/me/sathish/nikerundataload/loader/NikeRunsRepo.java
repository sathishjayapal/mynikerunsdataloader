package me.sathish.nikerundataload.loader;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NikeRunsRepo extends CassandraRepository<NikeRunsData, String> {
}
