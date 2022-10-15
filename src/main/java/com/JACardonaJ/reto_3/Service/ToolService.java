package com.JACardonaJ.reto_3.Service;

import com.JACardonaJ.reto_3.Model.Tool;
import com.JACardonaJ.reto_3.Repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository ;
    public List<Tool> getAll() {
        return  toolRepository.getAll();

    }

    public Optional<Tool> getTool(int id) {
        return toolRepository.getTool(id);
    }
    public  Tool save(Tool tool){
        if(tool.getId()==null){
            return  toolRepository.save(tool);
        }else{
            Optional<Tool> toolEncontrado=getTool(tool.getId());
            if(toolEncontrado.isPresent()){
                return  tool;                     //toolRepository.save(tool);
            } else {
                return toolRepository.save(tool);

            }
        }
    }
    public  Tool update(Tool tool){
        if(tool.getId()!=null){
            Optional<Tool>  toolEncontrado=toolRepository.getTool(tool.getId());
            if(toolEncontrado.isPresent()){
                if(tool.getName()!=null){
                    toolEncontrado.get().setName(tool.getName());
                }   if(tool.getBrand()!=null){
                    toolEncontrado.get().setBrand(tool.getBrand());
                }if(tool.getYear()!=null){
                    toolEncontrado.get().setYear(tool.getYear());
                }if(tool.getDescription()!=null){
                    toolEncontrado.get().setDescription(tool.getDescription());
                }if(tool.getCategory()!=null){
                    toolEncontrado.get().setCategory(tool.getCategory());
                } return  toolRepository.save(toolEncontrado.get());
            }  else{
                return tool;
            }
        } else{
            return tool;
        }
    }

    public  boolean delete(int id){
        boolean respuesta=getTool(id).map(elemento -> {
            toolRepository.delete(elemento);
            return true;
        }).orElse(false);
        return  respuesta;

    }

}
