package com.nenusoftware.gardenprotector.controller.adoption;

import com.nenusoftware.gardenprotector.entity.adoption.Adoption;
import com.nenusoftware.gardenprotector.service.adoption.AdoptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:49
 */
@Controller
@CrossOrigin
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    AdoptionService adoptionService;

    @RequestMapping(value = "addAdoption")
    public void addAdoption(String user_idstr, String city, String types, String detail, String note) throws Exception{
        Adoption adoption = new Adoption();
        adoption.setCity(city);
        Integer user_id = Integer.parseInt(user_idstr);
        adoption.setUser_id(user_id);
        adoption.setTypes(types);
        adoption.setDetail(detail);
        adoption.setNote(note);
        adoptionService.addAdoption(adoption);
    }

    @RequestMapping(value = "delAdoption")
    public void deleteAdoption(int id) throws Exception{
        adoptionService.delAdoption(id);
    }

    @RequestMapping(value = "updateAdoption")
    public void updateAdoption(String adoptionIdStr, String city, String types, String detail, String note) throws Exception{
        Adoption adoption = new Adoption();
        int id = Integer.parseInt(adoptionIdStr);
        adoption.setCity(city);
        adoption.setTypes(types);
        adoption.setDetail(detail);
        adoption.setNote(note);
        adoptionService.updateAdoption(id, adoption);
    }

    @RequestMapping(value = "listAdoption")
    public List<Adoption> listAdoption(String user_idstr) throws Exception{
        Integer user_id = Integer.parseInt(user_idstr);
        List<Adoption> adoptionList = Collections.emptyList();
        adoptionList = adoptionService.listAdoption(user_id);
        return  adoptionList;
    }

}
