package com.JACardonaJ.reto_3.Controller;

import com.JACardonaJ.reto_3.Model.Score;
import com.JACardonaJ.reto_3.Service.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService ;
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Score> getAll(){
        return  scoreService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int id){
        return  scoreService.getScore(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Score save(@RequestBody Score score){
        return scoreService.save(score);
    }
}
