package com.battleship.service;

import com.battleship.model.HitLocation;
import com.battleship.model.HitResponse;
import com.battleship.model.ShipLocation;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class BattleFieldService {

    int N;
    int remainingShipA;
    int remainingShipB;
    List<ShipLocation> shipsA = new ArrayList<>();
    List<ShipLocation> shipsB = new ArrayList<>();
    Set<String> alreadyHit = new HashSet<>();
    int currentTurn = 0; // 0 = A, 1 = B
    boolean gameOver = false;
    Random rand = new Random();

    public void initGame(int n) {
        N = n;
        shipsA.clear();
        shipsB.clear();
        remainingShipA = 0;
        remainingShipB = 0;
        alreadyHit.clear();
        currentTurn = 0;
        gameOver = false;
    }

    public void addShip(String id, int size, int xA, int yA, int xB, int yB) {
        validateBounds("A-" + id, xA, yA, size);
        validateBounds("B-" + id, xB, yB, size);
        shipsA.add(new ShipLocation("A-" + id, xA, yA, size));
        shipsB.add(new ShipLocation("B-" + id, xB, yB, size));
        remainingShipA++;
        remainingShipB++;
    }

    void validateBounds(String id, int x, int y, int size) {
        int offset = size / 2;
        int xStart, yStart;
        if (size % 2 == 0) {
            xStart = x - offset + 1;
            yStart = y - offset + 1;
        } else {
            xStart = x - offset;
            yStart = y - offset;
        }
        int xEnd = xStart + size - 1;
        int yEnd = yStart + size - 1;
        if (xStart < 0 || yStart < 0 || xEnd >= N || yEnd >= N) {
            throw new IllegalArgumentException("Ship " + id + " is out of battlefield bounds.");
        }
    }

    public String startGame() {
        int turn = 0;
        Set<String> alreadyHit = new HashSet<>();
        Random rand = new Random();
        StringBuilder log = new StringBuilder();
        while (true) {
            if (remainingShipA == 0) {
                log.append("🎯 Game Over: Player B wins!\n");
                break;
            } else if (remainingShipB == 0) {
                log.append("🎯 Game Over: Player A wins!\n");
                break;
            }
            HitLocation missileCoord;
            String key;
            do {
                missileCoord = hitMissile(turn, rand);
                key = missileCoord.x + "_" + missileCoord.y;
            } while (alreadyHit.contains(key));
            alreadyHit.add(key);
            if (turn == 0) {
                HitResponse hit = isHit(shipsB, missileCoord, "B");
                log.append("Player A's turn: Missile fired at (" + missileCoord.x + ", " + missileCoord.y + "). ");
                if (hit.status) {
                    log.append("Result: Hit! Player B's ship with ID '" + hit.id + "' destroyed.\n");
                } else {
                    log.append("Result: Miss.\n");
                }
            } else {
                HitResponse hit = isHit(shipsA, missileCoord, "A");
                log.append("Player B's turn: Missile fired at (" + missileCoord.x + ", " + missileCoord.y + "). ");
                if (hit.status) {
                    log.append("Result: Hit! Player A's ship with ID '" + hit.id + "' destroyed.\n");
                } else {
                    log.append("Result: Miss.\n");
                }
            }
            turn = 1 - turn;
        }
        return log.toString();
    }

    public Map<String, Object> fireMissile() {
        Map<String, Object> result = new HashMap<>();
        if (gameOver) {
            result.put("gameOver", true);
            result.put("message", "Game is already over.");
            return result;
        }
        HitLocation missileCoord;
        String key;
        do {
            missileCoord = hitMissile(currentTurn, rand);
            key = missileCoord.x + "_" + missileCoord.y;
        } while (alreadyHit.contains(key));
        alreadyHit.add(key);
        HitResponse hit;
        String player;
        if (currentTurn == 0) {
            hit = isHit(shipsB, missileCoord, "B");
            player = "A";
        } else {
            hit = isHit(shipsA, missileCoord, "A");
            player = "B";
        }
        result.put("turn", player);
        result.put("x", missileCoord.x);
        result.put("y", missileCoord.y);
        result.put("hit", hit.status);
        result.put("shipId", hit.id);
        result.put("shipOwner", hit.shipOwner);
        result.put("message",
            "Player " + player + " fires at (" + missileCoord.x + ", " + missileCoord.y + "): " +
            (hit.status ? ("Hit! " + (hit.id != null ? "Ship '" + hit.id + "' destroyed." : "")) : "Miss."));
        if (remainingShipA == 0) {
            result.put("gameOver", true);
            result.put("winner", "B");
            gameOver = true;
        } else if (remainingShipB == 0) {
            result.put("gameOver", true);
            result.put("winner", "A");
            gameOver = true;
        } else {
            result.put("gameOver", false);
            currentTurn = 1 - currentTurn;
        }
        return result;
    }

    HitLocation hitMissile(int turn, Random rand) {
        int xStart, xEnd, yStart = 0, yEnd = N - 1;
        if (turn == 0) {
            xStart = N / 2;
            xEnd = N - 1;
        } else {
            xStart = 0;
            xEnd = (N / 2) - 1;
        }
        int x = rand.nextInt(xEnd - xStart + 1) + xStart;
        int y = rand.nextInt(yEnd - yStart + 1) + yStart;
        return new HitLocation(x, y);
    }

    HitResponse isHit(List<ShipLocation> ships, HitLocation missileCoord, String fleetLabel) {
        Iterator<ShipLocation> it = ships.iterator();
        while (it.hasNext()) {
            ShipLocation ship = it.next();
            int offset = ship.size / 2;
            int xStart, yStart;
            if (ship.size % 2 == 0) {
                xStart = ship.x - offset + 1;
                yStart = ship.y - offset + 1;
            } else {
                xStart = ship.x - offset;
                yStart = ship.y - offset;
            }
            int xEnd = xStart + ship.size - 1;
            int yEnd = yStart + ship.size - 1;
            if (missileCoord.x >= xStart && missileCoord.x <= xEnd &&
                    missileCoord.y >= yStart && missileCoord.y <= yEnd) {
                it.remove();
                if ("A".equals(fleetLabel)) remainingShipA--;
                else remainingShipB--;
                HitResponse response = new HitResponse(true, missileCoord);
                response.id = ship.id;
                response.shipOwner = fleetLabel;
                return response;
            }
        }
        return new HitResponse(false, missileCoord);
    }

    public String[][] viewBattleField() {
        String[][] grid = new String[N][N];
        for (ShipLocation ship : shipsA) fillGrid(grid, ship);
        for (ShipLocation ship : shipsB) fillGrid(grid, ship);
        return grid;
    }

    void fillGrid(String[][] grid, ShipLocation ship) {
        int offset = ship.size / 2;
        int xStart, yStart;
        if (ship.size % 2 == 0) {
            xStart = ship.x - offset + 1;
            yStart = ship.y - offset + 1;
        } else {
            xStart = ship.x - offset;
            yStart = ship.y - offset;
        }
        for (int i = 0; i < ship.size; i++) {
            for (int j = 0; j < ship.size; j++) {
                int x = xStart + i;
                int y = yStart + j;
                if (x >= 0 && x < N && y >= 0 && y < N) {
                    grid[x][y] = ship.id;
                }
            }
        }
    }

    public int getCurrentTurn() {
        return currentTurn;
    }

    public boolean isGameOver() {
        return gameOver;
    }
} 