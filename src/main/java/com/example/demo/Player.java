package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Player implements Cloneable {

	private final String name;
	
	private int attack;
	
	private int defense;
	
	private int health;
	
	private final int MAX_HEALTH;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Player(String name, int attack, int defense, int health) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.health = health;
		this.MAX_HEALTH = health;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Player [attack=" + attack + ", defense=" + defense + ", health=" + health + ", MAX_HEALTH=" + MAX_HEALTH
					+ "]";
		}
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}
	
}
