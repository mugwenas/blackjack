package com.za.shadrackmugwena;

/**
 * Class representing a Card suit. A card suit has a Unicode Character representing a symbol/icon of a card.
 *
 * @author Shadrack Mugwena
 */
public enum Suit
{
  HEARTS("\u2665"),
  DIAMONDS("\u2666"),
  SPADES("\u2660"),
  CLUBS("\u2663");

  private String symbol;

  Suit(String symbol)
  {
    this.symbol = symbol;
  }

  public String getSymbol()
  {
    return symbol;
  }
}
