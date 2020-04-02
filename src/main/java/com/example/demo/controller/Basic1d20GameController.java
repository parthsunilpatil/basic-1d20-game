package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Game;
import com.example.demo.Player;
import com.example.demo.Round;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class Basic1d20GameController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello World!!";
	}
	
	@RequestMapping("/game")
	public Game game() throws JsonProcessingException, CloneNotSupportedException {
		Player p1 = new Player("ThisGuy", 10, 10, 100), p2 = new Player("ThatGuy", 10, 10, 100);
		List<Round> rounds = new LinkedList<Round>();
		while(true) {
			rounds.add(turn(p1, p2));
			if(p1.getHealth() == 0 || p2.getHealth() == 0) break;
			rounds.add(turn(p2, p1));
			if(p1.getHealth() == 0 || p2.getHealth() == 0) break;
		}
		return new Game(rounds, (p1.getHealth() != 0) ? p1 : p2);		
	}

	private Round turn(Player p1, Player p2) throws CloneNotSupportedException {
		int roll = ((int) (Math.random() * 19)) + 1;
		int damage = roll + p1.getAttack() - p2.getDefense();
		if(damage > 0) {
			if(damage < p2.getHealth()) {
				p2.setHealth(p2.getHealth() - damage);
			} else {
				p2.setHealth(0);
			}
		}
		return new Round(p1.getName() + " attacks " + p2.getName() + " for damage=" + damage + " == roll=" + roll + " + attack(" + p1.getName() + ")=" + p1.getAttack() + " - defense(" + p2.getName() + ")=" + p2.getDefense(), (Player) p1.clone(), (Player) p2.clone());
	}
}
