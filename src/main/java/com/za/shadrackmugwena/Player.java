package com.za.shadrackmugwena;

/**
 * A Class representation of a BlackJack player including a dealer.
 *
 * @author Shadrack Mugwena
 */
public class Player
{
  private final String name;
  private Hand hand;
  private boolean winner;

  public Player(String name)
  {
    this.name = name;
    this.hand = new Hand();
  }

  /**
   * Gets the name of the player
   *
   * @return the name of the player.
   */
  public String getName()
  {
    return name;
  }

  public Hand getHand()
  {
    return hand;
  }

  /**
   * Gets boolean value indicating whether or not a player playing against a dealer wins.
   *
   * @return true if a player wins, false otherwise.
   */
  public boolean isWinner()
  {
    return winner;
  }

  /**
   * Sets boolean value indicating whether or not a player playing against a dealer wins.
   *
   * @param winner a boolean value indicating whether or not a player playing against a dealer wins.
   */
  public void setWinner(boolean winner)
  {
    this.winner = winner;
  }

  /**
   * Draws a given card from a deck. This is mainly for testing purpose as in real life you wouldn't choose what card to draw.
   *
   * @param deck the deck from which the card is drawn.
   * @param card the card to be drawn.
   */
  public void draw(Deck deck, Card card)
  {
    if (card != null)
    {
      deck.dealCard(card);
      hand.addCard(card);
    }
    else
    {
      draw(deck);
    }

  }

  /**
   * Draws a card from a deck. A drawn card is random as the deck would have been shuffle.
   *
   * @param deck the deck from which the card is drawn.
   */
  public void draw(Deck deck)
  {
    hand.addCard(deck.dealCard());
  }

  @Override
  public String toString()
  {
    return  "Player {\n" +
            "         Name   : " + getName() + ",\n" +
            "         Winner : " + isWinner() + ",\n" +
            "         " + getHand().toString() + "\n" +
            "       }";
  }
}
