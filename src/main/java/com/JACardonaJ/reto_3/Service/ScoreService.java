package com.JACardonaJ.reto_3.Service;

import com.JACardonaJ.reto_3.Model.Score;
import com.JACardonaJ.reto_3.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();

    }

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save(Score score) {
        if (score.getIdscore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreEncontrado = getScore(score.getIdscore());
            if (scoreEncontrado.isPresent()) {
                return scoreRepository.save(score);
            } else {
                return score;

            }
        }
    }

    public Score update(Score score) {
        if (score.getIdscore() != null) {
            Optional<Score> scoreEncontrado = getScore(score.getIdscore());
            if (!scoreEncontrado.isPresent()) {
                if (score.getMessageText() != null) {
                    scoreEncontrado.get().setMessageText(score.getMessageText());

                }
                if (score.getStars() != null) {
                    scoreEncontrado.get().setStars(score.getStars());
                }
                return scoreRepository.save(scoreEncontrado.get());
            }


        }
        return score;
    }

    public  boolean delete(int id){
        boolean respuesta=getScore(id).map(elemento -> {
            scoreRepository.delete(elemento);
            return true;
        }).orElse(false);
        return  respuesta;

    }

}
