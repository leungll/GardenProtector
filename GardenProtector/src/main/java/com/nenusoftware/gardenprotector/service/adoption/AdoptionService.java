package com.nenusoftware.gardenprotector.service.adoption;

import com.nenusoftware.gardenprotector.entity.adoption.Adoption;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:19
 */
public interface AdoptionService {

    public boolean addAdoption(Adoption adoption) throws Exception;

    public boolean delAdoption(int id) throws Exception;

    public boolean updateAdoption(int id, Adoption adoption) throws Exception;

    public List<Adoption> listAdoption(int user_id) throws Exception;
}
