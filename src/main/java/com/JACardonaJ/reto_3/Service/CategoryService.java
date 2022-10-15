package com.JACardonaJ.reto_3.Service;


import com.JACardonaJ.reto_3.Model.Category;
import com.JACardonaJ.reto_3.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository ;
    public List<Category> getAll(){
        return (List<Category>)  categoryRepository.getALL();

    }
    public Optional<Category> getCategory(int id){
        return  categoryRepository.getCategory(id);
    }
    public Category save(Category category){
        if(category.getId()==null){
            return  categoryRepository.save(category);
        }else{
            Optional<Category> categoryEncontrada=categoryRepository.getCategory(category.getId());
            if(categoryEncontrada.isPresent()){
                return   category;
            }else {
                return   categoryRepository.save(category);
            }
        }
    }

    public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> categoryEncontrada=categoryRepository.getCategory(category.getId());
            if(categoryEncontrada.isPresent()){
                if(category.getDescription() !=null){
                    categoryEncontrada.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    categoryEncontrada.get().setName(category.getName());
                }
                 categoryRepository.save(categoryEncontrada.get());
                return  categoryEncontrada.get();
            }  else{
                return  category;
            }

        } else {
            return category;
        }
    }

    public  boolean delete(int Id){
        boolean respuesta=getCategory(Id).map(elemento->{
            categoryRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta ;
    }
}
