package com.za.shadrackmugwena;

/**
 * An Interface designating a play blackjack method to be implemented by a class(es).
 *
 * @author Shadrack Mugwena
 */
public interface BlackJack
{

  /**
   * A method simulating the logic and rules of Blackjack 21. The rules are as follows:
   * - Cards in a hand are summed to determine the hand's value.
   * - An ace can be equal to 1 or 11, based on the other cards in the hand. The goal is to not exceed 21.
   * - Any player whose hand consists of 5 cards without the hand exceeding 21 automatically beats the dealer.
   * - Players play against the dealer and not each other.
   * - Any player whose hand is equal to or exceeds the dealer's hand and less than or equal to 21 beats the dealer.
   *
   * @param dealer the dealer a player plays against.
   * @param player the player against the dealer.
   * @return whether or not the player wins. true if the player wins, false otherwise.
   */
  boolean play(Player dealer, Player player) throws Exception;


}
