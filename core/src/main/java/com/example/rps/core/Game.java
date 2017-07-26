package com.example.rps.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Represents the game itself
 *
 * @author Beka Tsotsoria
 */
public class Game {

    private final Map<String, Player> players = new HashMap<>();

    /**
     * Performs round and returns result
     *
     * @return result of round
     * @throws IllegalStateException if there are not enough players in this game
     */
    public RoundResult doRound() {
        if (players.size() < 2) {
            throw new IllegalStateException("At least 2 players are needed");
        }
        Iterator<Player> iterator = players.values().iterator();
        Player player1 = iterator.next();
        Player player2 = iterator.next();
        Weapon weapon1 = player1.makeMove(null);
        Weapon weapon2 = player2.makeMove(null);
        Player winner = null;
        Weapon weaponUsed = null;
        if (Weapon.ROCK.is(weapon1)) {
            if (Weapon.PAPER.is(weapon2)) {
                winner = player2;
                weaponUsed = weapon2;
            } else if (Weapon.SCISSORS.is(weapon2)) {
                winner = player1;
                weaponUsed = weapon1;
            }
        } else if (Weapon.SCISSORS.is(weapon1)) {
            if (Weapon.PAPER.is(weapon2)) {
                winner = player1;
                weaponUsed = weapon1;
            } else if (Weapon.ROCK.is(weapon2)) {
                winner = player2;
                weaponUsed = weapon2;
            }
        } else if (Weapon.PAPER.is(weapon1)) {
            if (Weapon.ROCK.is(weapon2)) {
                winner = player1;
                weaponUsed = weapon1;
            } else if (Weapon.SCISSORS.is(weapon2)) {
                winner = player2;
                weaponUsed = weapon2;
            }
        }
        return new RoundResult(winner, weaponUsed);
    }

    /**
     * Joins player into game, there must be at least 2 players
     * in the game
     *
     * @throws IllegalArgumentException if {@link Player#getId() id} of the player is not
     *                                  unique in this game
     * @throws NullPointerException     if player is null
     */
    public void join(Player player) {
        if (player == null) {
            throw new NullPointerException("player");
        }
        if (players.putIfAbsent(player.getId(), player) != null) {
            throw new IllegalArgumentException("Id \"" + player.getId() + "\" is already taken");
        }
    }
}