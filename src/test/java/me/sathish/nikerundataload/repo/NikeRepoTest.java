package me.sathish.nikerundataload.repo;

import me.sathish.nikerundataload.loader.cassandra.NikeRunsQueryData;
import me.sathish.nikerundataload.loader.cassandra.NikeRunsReadRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataCassandraTest
public class NikeRepoTest {
    @Autowired
    private NikeRunsReadRepo nikeRunsRepo;
    @Test
    public void testFindAll(){
        List<NikeRunsQueryData> nikeRunsDataList = nikeRunsRepo.findAll();
        assert nikeRunsDataList.size()>0;
    }
    @Test
    public void saveOneRecord(){
        NikeRunsQueryData runsData = new NikeRunsQueryData();
        runsData.setId(1L);
        runsData.setName("74f017af-83b1-41fd-92f2-095bb130f8e3");
        nikeRunsRepo.save(runsData);
    }
}
