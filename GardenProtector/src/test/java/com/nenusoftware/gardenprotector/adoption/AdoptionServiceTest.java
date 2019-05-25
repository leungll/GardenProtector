package com.nenusoftware.gardenprotector.adoption;

import com.nenusoftware.gardenprotector.entity.adoption.Adoption;
import com.nenusoftware.gardenprotector.service.adoption.AdoptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdoptionServiceTest {

    @Autowired
    AdoptionService adoptionService;

    @Test
    public void testAddAdoption() throws Exception{
        Adoption adoption = new Adoption();
        adoption.setCity("北京");
        adoption.setUser_id(3);
        adoption.setTypes("植被");
        adoption.setDetail("aaaaa");
        adoption.setNote("aaaaaaaa");
        adoptionService.addAdoption(adoption);
    }

    @Test
    public void testDelAdoption() throws Exception{
        int id = 4;
        adoptionService.delAdoption(id);
    }

    @Test
    public void testUpdateAdoption() throws Exception{
        int id = 1;
        Adoption adoption = new Adoption();
        adoption.setCity("上海");
        adoption.setUser_id(3);
        adoption.setTypes("植被");
        adoption.setDetail("bbbbb");
        adoption.setNote("aaaaaaaa");
        adoptionService.updateAdoption(id, adoption);
    }

    @Test
    public void listAdoption() throws Exception{
        System.out.println(adoptionService.listAdoption(3));
    }
}
