package com.example.truelogic.demo.controller;


import com.example.truelogic.demo.model.Player;
import com.example.truelogic.demo.model.Response;
import com.example.truelogic.demo.service.PlayerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jgarzon
 */
@RestController
@RequestMapping("Controller")
public class Controller {

    @Autowired
    private PlayerService playerService;

    
    @PostMapping(
    value = "/processPlayers", consumes = "application/json", produces = "application/json")
    public Object processPlayers(@RequestBody List<Player> players) {
        Response result = new Response();
        List<String> resultList = new ArrayList();
        try {                        
            players.stream().forEach((p) -> resultList.add(playerService.evaluatePlayer(p)));
        } catch (Exception e) {
            resultList.add("Ups, something is bad");
        }
        result.setResult(resultList);
        return result;
    }

}
