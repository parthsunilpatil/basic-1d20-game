package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Round {
	
	private String breakdown;
	
	private Player attacker;
	
	private Player defender;
	
	public Round(String breakdown, Player attacker, Player defender) {
		super();
		this.breakdown = breakdown;
		this.attacker = attacker;
		this.defender = defender;
	}

	public String getBreakdown() {
		return breakdown;
	}

	public void setBreakdown(String breakdown) {
		this.breakdown = breakdown;
	}

	public Player getAttacker() {
		return attacker;
	}

	public void setAttacker(Player attacker) {
		this.attacker = attacker;
	}

	public Player getDefender() {
		return defender;
	}

	public void setDefender(Player defender) {
		this.defender = defender;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Round [breakdown=" + breakdown + ", attacker=" + attacker + ", defender=" + defender + "]";
		}
	}
	
}
