package com.nenusoftware.gardenprotector.service.adoption.impl;

import com.nenusoftware.gardenprotector.entity.adoption.Adoption;
import com.nenusoftware.gardenprotector.mapper.adoption.AdoptionMapper;
import com.nenusoftware.gardenprotector.service.adoption.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:19
 */
@Service
public class AdoptionServiceImpl implements AdoptionService {

    @Autowired
    AdoptionMapper adoptionMapper;

    @Override
    public boolean addAdoption(Adoption adoption) throws Exception{
        return adoptionMapper.addAdoption(adoption);
    }

    @Override
    public boolean delAdoption(int id) throws Exception{
        return adoptionMapper.delAdoption(id);
    }

    @Override
    public boolean updateAdoption(int id, Adoption adoption) throws Exception{
        return adoptionMapper.updateAdoption(id, adoption);
    }

    @Override
    public List<Adoption> listAdoption(int user_id) throws Exception{
        List<Adoption> list = adoptionMapper.listAdoption(user_id);
        return list;
    }
}
