package com.JACardonaJ.reto_3.Repository.RepositoryCrudRepository;

import com.JACardonaJ.reto_3.Model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
