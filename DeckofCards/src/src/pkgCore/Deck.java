package src.pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import src.pkgEnum.eRank;
import src.pkgEnum.eSuit;
import src.pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck = new ArrayList<Card>();

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {

		if (cardsInDeck.size() == 0)
		{
			throw new DeckException(this);
		}
		return cardsInDeck.remove(0);

	}

	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return (c);
			}
		}
		return (null);
	}

	public int getiDeckCount()
	{
		return cardsInDeck.size();
	}
	
	public int getRemaining(Object eNum) {
		int cnt=0;
		for(Card c:cardsInDeck) {
			if(eNum instanceof eRank) {
				if(c.geteRank()==eNum)
					cnt++;
			}
			else if(eNum instanceof eSuit) {
				if(c.geteSuit()==eNum)
					cnt++;
			}
		}
		return cnt;
	}
}