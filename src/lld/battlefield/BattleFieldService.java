package lld.battlefield;

import lld.battlefield.model.HitLocation;
import lld.battlefield.model.HitResponse;
import lld.battlefield.model.ShipLocation;

import java.util.*;

public class BattleFieldService {

    int N;

    int remainingShipA;
    int remainingShipB;

    List<ShipLocation> shipsA = new ArrayList<>();
    List<ShipLocation> shipsB = new ArrayList<>();

    void initGame(int n) {
        N = n;
        shipsA.clear();
        shipsB.clear();
        remainingShipA = 0;
        remainingShipB = 0;
    }

    void addShip(String id, int size, int xA, int yA, int xB, int yB) {
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

    void startGame() {
        int turn = 0;
        Set<String> alreadyHit = new HashSet<>();
        Random rand = new Random();

        while (true) {
            if (remainingShipA == 0) {
                System.out.println("🎯 Game Over: Player B wins!");
                break;
            } else if (remainingShipB == 0) {
                System.out.println("🎯 Game Over: Player A wins!");
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
                System.out.print("Player A's turn: Missile fired at (" + missileCoord.x + ", " + missileCoord.y + "). ");
                if (hit.status) {
                    System.out.println("Result: Hit! Player B's ship with ID '" + hit.id + "' destroyed.");
                } else {
                    System.out.println("Result: Miss.");
                }
            } else {
                HitResponse hit = isHit(shipsA, missileCoord, "A");
                System.out.print("Player B's turn: Missile fired at (" + missileCoord.x + ", " + missileCoord.y + "). ");
                if (hit.status) {
                    System.out.println("Result: Hit! Player A's ship with ID '" + hit.id + "' destroyed.");
                } else {
                    System.out.println("Result: Miss.");
                }
            }

            turn = 1 - turn;
        }
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

    void viewBattleField() {
        String[][] grid = new String[N][N];
        for (ShipLocation ship : shipsA) fillGrid(grid, ship);
        for (ShipLocation ship : shipsB) fillGrid(grid, ship);

        System.out.println("🗺️  Battlefield View:");
        System.out.print("    ");
        for (int col = 0; col < N; col++) {
            System.out.print(col + "\t");
        }
        System.out.println();

        for (int row = 0; row < N; row++) {
            System.out.print(row + " | ");
            for (int col = 0; col < N; col++) {
                System.out.print((grid[row][col] == null ? "." : grid[row][col]) + "\t");
            }
            System.out.println();
        }
        System.out.println();
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

    public static void main(String[] args) {
        BattleFieldService game = new BattleFieldService();
        game.initGame(6);

        // Valid center coordinates
        game.addShip("SH1", 2, 1, 1, 4, 1);
        game.addShip("SH2", 2, 2, 2, 4, 3);  // changed from 5,3 to 4,3

        game.viewBattleField();
        game.startGame();
    }
}
