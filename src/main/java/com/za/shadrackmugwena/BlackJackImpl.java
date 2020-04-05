package com.za.shadrackmugwena;

/**
 * A Concrete class implementing Blackjack as specified in the javadoc.
 *
 * @author Shadrack Mugwena
 *
 */
public class BlackJackImpl implements BlackJack
{
  private final int BLACK_JACK = 21;
  private final int MINIMUM_CARDS_NUMBER = 1;

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean play(Player dealer, Player player) throws Exception
  {
     validatePlayers(dealer, player);
     dealer.setWinner(true);

     int playerHandSize = player.getHand().getCards().size();

     int playerHandValue = player.getHand().getValue();
     int dealerHandValue = dealer.getHand().getValue();

     if (playerHandSize == 5 && playerHandValue <= BLACK_JACK)
     {
       player.setWinner(true);
       dealer.setWinner(false);

       return player.isWinner();
     }
     if ((playerHandValue >= dealerHandValue) && (playerHandValue <= BLACK_JACK))
     {
       player.setWinner(true);
       dealer.setWinner(false);

       return player.isWinner();
     }

    return false;
  }

  private void validatePlayers(Player dealer, Player player)
  {
    if (dealer == null || player == null)
    {
      throw new IllegalArgumentException("Both Dealer and Player can't null");
    }

    if (dealer.getHand().getCards().size() < MINIMUM_CARDS_NUMBER
            || player.getHand().getCards().size() < MINIMUM_CARDS_NUMBER)
    {
      throw new IllegalArgumentException("Both Dealer and Player must have dealt at least once");
    }
  }
}
