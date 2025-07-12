package com.battleship.controller;

import com.battleship.model.ShipLocation;
import com.battleship.service.BattleFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
public class BattleFieldController {

    private final BattleFieldService battleFieldService;

    @Autowired
    public BattleFieldController(BattleFieldService battleFieldService) {
        this.battleFieldService = battleFieldService;
    }

    @PostMapping("/init")
    public String initGame(@RequestBody Map<String, Integer> body) {
        int size = body.getOrDefault("size", 6);
        battleFieldService.initGame(size);
        return "Game initialized with size " + size;
    }

    @PostMapping("/ship")
    public String addShip(@RequestBody Map<String, Object> body) {
        String id = (String) body.get("id");
        int size = (int) body.get("size");
        int xA = (int) body.get("xA");
        int yA = (int) body.get("yA");
        int xB = (int) body.get("xB");
        int yB = (int) body.get("yB");
        battleFieldService.addShip(id, size, xA, yA, xB, yB);
        return "Ship " + id + " added for both players.";
    }

    @PostMapping("/start")
    public String startGame() {
        return battleFieldService.startGame();
    }

    @PostMapping("/fire")
    public Map<String, Object> fireMissile() {
        return battleFieldService.fireMissile();
    }

    @GetMapping("/state")
    public String[][] viewBattleField() {
        return battleFieldService.viewBattleField();
    }
} 