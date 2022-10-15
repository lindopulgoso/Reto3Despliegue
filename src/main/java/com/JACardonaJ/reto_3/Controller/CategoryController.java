package com.JACardonaJ.reto_3.Controller;



import com.JACardonaJ.reto_3.Model.Category;
import com.JACardonaJ.reto_3.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/all")
    public List<Category> getAll(){return  categoryService.getAll();}
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return  categoryService.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }




}
