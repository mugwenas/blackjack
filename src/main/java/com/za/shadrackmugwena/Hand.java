package com.za.shadrackmugwena;

import java.util.ArrayList;
import java.util.List;

/**
 * A Class representation of a BlackJack Hand.
 *
 * @author Shadrack Mugwena
 */
public class Hand
{
  private final int BLACK_JACK = 21;

  private List<Card> cards = new ArrayList<>();

  /**
   * Gets the total value of cards on the hand. Every ace value is treated as 11.
   * If the cards contain ACE and the total value exceed 21 then we subtract 10 for each ace in the hand
   *
   * @return the total value of cards on the hand.
   */
  public int getValue()
  {
    int value = getHardValue();
    long aceCount = getAceCount();
    if (aceCount > 0)
    {
      if (value > BLACK_JACK)
      {
        value = new Long(value - (aceCount * 10)).intValue();
      }
    }
    return value;
  }

  private int getHardValue()
  {//every ace value was treated as 11
    return cards.stream()
            .map(Card::getRank)
            .mapToInt(Rank::getValue)
            .sum();
  }

  private long getAceCount()
  {
    return cards.stream()
            .map(Card::getRank)
            .filter(r -> r == Rank.ACE)
            .count();
  }

  /**
   * Adds the drawn card onto the hand
   *
   * @param card the card drawn card
   */
  public void addCard(Card card)
  {
    cards.add(card);
  }

  /**
   * Get all cards currently on the hand.
   *
   * @return all cards currently on the hand.
   */
  public List<Card> getCards()
  {
    return cards;
  }

  @Override
  public String toString()
  {
    return  "Hand {\n" +
            "                 value: " + getValue() + ",\n" +
            "                 cards: " + cards + "\n" +
            "             }";
  }
}
