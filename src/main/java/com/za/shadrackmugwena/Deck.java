package com.za.shadrackmugwena;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A Class representing a Deck of cards. This represents the standard 52-card deck.
 *
 * @author Shadrack Mugwena
 */
public class Deck
{
  private List<Card> deck;

  public Deck()
  {
    initialize();
  }

  private void initialize()
  {
    deck = Collections.synchronizedList(new ArrayList<>());
    for (Suit suit : Suit.values())
    {
      for (Rank rank : Rank.values())
      {
        deck.add(new Card(rank, suit));
      }
    }
  }

  /**
   * Gets all the cards in the deck.
   *
   * @return all the cards in the deck.
   */
  public List<Card> getDeck()
  {
    return deck;
  }

  /**
   * Shuffles the cards in the deck
   */
  public void shuffle()
  {
    Collections.shuffle(deck);
  }

  /**
   * Deals the Card from the deck
   *
   * @return the dealt card and removes it from the deck
   */
  public Card dealCard()
  {
    return deck.remove(0);
  }

  /**
   * Deals the specified card from the deck. This is mainly for testing purpose as
   * we cannot control the outcome of the shuffling method.
   *
   * @param card the card to be removed for the deck. If the card not provided we get the random card.
   */
  public Card dealCard(Card card)
  {
    if (card != null)
    {
      deck.remove(card);
      return card;
    }
    return dealCard();
  }

}
