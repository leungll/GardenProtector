package com.nenusoftware.gardenprotector.controller.adoption;

import com.nenusoftware.gardenprotector.entity.adoption.Adoption;
import com.nenusoftware.gardenprotector.service.adoption.AdoptionService;
import com.nenusoftware.gardenprotector.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2019/5/23 9:49
 */
@RestController
@CrossOrigin
@RequestMapping("/adoption")
public class AdoptionController {

    @Autowired
    AdoptionService adoptionService;

    @Resource
    UserService userService;

    @RequestMapping(value = "addAdoption")
    @ResponseBody
    public void addAdoption(HttpServletRequest request, String city, String types, String detail, String note) throws Exception{
        Adoption adoption = new Adoption();
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        adoption.setCity(city);
        adoption.setUser_id(userId);
        adoption.setTypes(types);
        adoption.setDetail(detail);
        adoption.setNote(note);
        adoptionService.addAdoption(adoption);
    }

    @RequestMapping(value = "delAdoption")
    public void deleteAdoption(String idStr) throws Exception{
        int id = Integer.parseInt(idStr);
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
    public List<Adoption> listAdoption(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        String username = String.valueOf(session.getAttribute("usernameSession"));
        int userId = userService.getIdByUsername(username).getId();
        List<Adoption> adoptionList = Collections.emptyList();
        adoptionList = adoptionService.listAdoption(userId);
        return adoptionList;
    }
}
