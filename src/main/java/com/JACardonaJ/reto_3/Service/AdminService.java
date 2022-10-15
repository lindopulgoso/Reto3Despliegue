package com.JACardonaJ.reto_3.Service;

//import Model.Admin;
//import Repository.AdminRepository;


import com.JACardonaJ.reto_3.Model.Admin;
import com.JACardonaJ.reto_3.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return  adminRepository.getAll();

    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }
    public Admin save(Admin admin){
        if(admin.getId()==null){
            return  adminRepository.save(admin);
        }else{
            Optional<Admin> adminencontrado=adminRepository.getAdmin(admin.getId());
            if(adminencontrado.isPresent()){
                return adminRepository.save(admin);
            }else {
                return  admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getId()!=null){
            Optional<Admin> adminencontrado=getAdmin(admin.getId());
            if(!adminencontrado.isPresent() ){
                if(admin.getPassword() !=null){
                    adminencontrado.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    adminencontrado.get().setName(admin.getName());
                }
                return  adminRepository.save(adminencontrado.get());
            }

        } return admin;
    }

    public  boolean deleteAdmin(int Id){
        boolean respuesta=getAdmin(Id).map(adminPorEliminar->{
            adminRepository.delete(adminPorEliminar);
            return true;
        }).orElse(false);
        return respuesta ;
    }

}
