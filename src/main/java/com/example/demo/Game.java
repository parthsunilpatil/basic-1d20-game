package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Game {

	private List<Round> rounds;
	
	private Player winner;

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Game(List<Round> rounds, Player winner) {
		super();
		this.rounds = rounds;
		this.winner = winner;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "Game [rounds=" + rounds + ", winner=" + winner + "]";
		}
	}
}
