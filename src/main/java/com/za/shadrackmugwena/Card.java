package com.za.shadrackmugwena;

/**
 * A blueprint for creating Card objects
 *
 * @author Shadrack Mugwena
 */
public class Card
{
  private Rank rank;
  private Suit suit;

  public Card(Rank rank, Suit suit)
  {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank()
  {
    return rank;
  }

  public Suit getSuit()
  {
    return suit;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }

    Card card = (Card) o;

    if (rank != card.rank)
    {
      return false;
    }
    return suit == card.suit;
  }

  @Override
  public int hashCode()
  {
    int result = rank != null ? rank.hashCode() : 0;
    result = 31 * result + (suit != null ? suit.hashCode() : 0);
    return result;
  }

  @Override
  public String toString()
  {
    return String.format("%s of %s", rank, suit);
  }
}
