package com.JACardonaJ.reto_3.Controller;

import com.JACardonaJ.reto_3.Model.Admin;
import com.JACardonaJ.reto_3.Model.Tool;
import com.JACardonaJ.reto_3.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired   //  /api/Admin/all
    private AdminService adminService;
    @GetMapping("/all")
    public List<Admin> getAll(){
        return  adminService.getAll();
    }
    @GetMapping("/{id}")
    public  Optional<Admin> getAdmin(@PathVariable("id") int id){
        return  adminService.getAdmin(id);
    }

    // /api/Admin/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return adminService.save(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin){
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return adminService.deleteAdmin(id);
    }

}
