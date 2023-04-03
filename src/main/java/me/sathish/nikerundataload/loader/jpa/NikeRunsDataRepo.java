package me.sathish.nikerundataload.loader.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NikeRunsDataRepo extends JpaRepository<NikeRunsDBData, Long> {
}
