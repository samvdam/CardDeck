package src.pkgException;

import src.pkgCore.Deck;

public class DeckException extends Exception {

	private Deck d;

	public DeckException(Deck d) {
		super();
		this.d = d;
	}

	protected Deck getD() {
		return d;
	}
	
}