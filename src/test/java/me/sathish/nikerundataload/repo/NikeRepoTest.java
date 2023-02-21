package me.sathish.nikerundataload.repo;

import me.sathish.nikerundataload.loader.NikeRunsData;
import me.sathish.nikerundataload.loader.NikeRunsRepo;
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
    private NikeRunsRepo nikeRunsRepo;
    @Test
    public void testFindAll(){
        List<NikeRunsData> nikeRunsDataList= nikeRunsRepo.findAll();
        assert nikeRunsDataList.size()>0;
    }
    @Test
    public void saveOneRecord(){
        NikeRunsData runsData= new NikeRunsData();
        runsData.setId(1L);
        runsData.setName("74f017af-83b1-41fd-92f2-095bb130f8e3");
        nikeRunsRepo.save(runsData);
    }
}
