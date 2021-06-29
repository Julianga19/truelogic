package com.example.truelogic.demo.service;

import com.example.truelogic.demo.model.Player;
import com.example.truelogic.demo.repository.PlayerRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author jgarzona
 */
@Service
public class PlayerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired  
    PlayerRepository playerRepository;  
    
    private final String kafkaTopic = "novice-players";

    public String evaluatePlayer(Player player) {
        String result = "";
        switch(player.getType()){
            case "expert":                
                playerRepository.save(player);
                result = "Player " + player.getName() + " stored in DB.";
                break;            
            case "novice":
                kafkaTemplate.send(kafkaTopic, player.toString());
                result = "Player " + player.getName() + " sent to Kafka topic";
                break;                
            default:
                result = "Player " + player.getName() + " did not fit";
                break;
        }
        return result;
    }

}
