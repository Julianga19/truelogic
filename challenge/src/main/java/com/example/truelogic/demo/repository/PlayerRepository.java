package com.example.truelogic.demo.repository;

import com.example.truelogic.demo.model.Player;
import org.springframework.data.repository.CrudRepository;  

/**
 *
 * @author jgarzon
 */
public interface PlayerRepository extends CrudRepository<Player, Integer> {
    
}
