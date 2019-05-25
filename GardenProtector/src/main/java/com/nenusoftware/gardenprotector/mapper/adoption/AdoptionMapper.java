package com.nenusoftware.gardenprotector.mapper.adoption;

import com.nenusoftware.gardenprotector.entity.adoption.Adoption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:15
 */
@Mapper
@Repository
public interface AdoptionMapper {

    public boolean addAdoption(@Param("adoption") Adoption adoption) throws Exception;

    public boolean delAdoption(@Param("id") int id) throws Exception;

    public boolean updateAdoption(@Param("id") int id, @Param("adoption") Adoption adoption) throws Exception;

    public List<Adoption> listAdoption(@Param("user_id") int user_id) throws Exception;
}
