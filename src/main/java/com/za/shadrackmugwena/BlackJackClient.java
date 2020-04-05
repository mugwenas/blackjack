package com.za.shadrackmugwena;

/**
 * A class for testing BlackJack algorithm
 *
 * @author Shadrack Mugwena
 */
public class BlackJackClient
{
  private static BlackJack blackJack = new BlackJackImpl();
  private static Deck deck;
  private static Player dealer;
  private static Player player;

  public static void main (String [] args) throws Exception
  {
    deck = getShuffledDeck();
    dealer = getDealer("Dealer");
    dealerDrawsCard(new Card(Rank.JACK, Suit.SPADES));
    dealerDrawsCard(new Card(Rank.NINE, Suit.HEARTS));


    //Test Case: Lemmy
    player = getPlayer("Lemmy");
    playerDrawsCard(new Card(Rank.ACE, Suit.SPADES));
    playerDrawsCard(new Card(Rank.SEVEN, Suit.HEARTS));
    playerDrawsCard(new Card(Rank.ACE, Suit.DIAMONDS));
    blackJack.play(dealer, player);
    printResults(player);

    //Test Case: Andrew
    player = getPlayer("Andrew");
    playerDrawsCard(new Card(Rank.KING, Suit.DIAMONDS));
    playerDrawsCard(new Card(Rank.FOUR, Suit.SPADES));
    playerDrawsCard(new Card(Rank.FOUR, Suit.CLUBS));
    blackJack.play(dealer, player);
    printResults(player);

    //Test Case: Billy
    player = getPlayer("Billy");
    playerDrawsCard(new Card(Rank.TWO, Suit.SPADES));
    playerDrawsCard(new Card(Rank.TWO, Suit.DIAMONDS));
    playerDrawsCard(new Card(Rank.TWO, Suit.HEARTS));
    playerDrawsCard(new Card(Rank.FOUR, Suit.DIAMONDS));
    playerDrawsCard(new Card(Rank.FIVE, Suit.CLUBS));
    blackJack.play(dealer, player);
    printResults(player);

    //Test Case: Carla
    player = getPlayer("Carla");
    playerDrawsCard(new Card(Rank.QUEEN, Suit.CLUBS));
    playerDrawsCard(new Card(Rank.SIX, Suit.SPADES));
    playerDrawsCard(new Card(Rank.NINE, Suit.DIAMONDS));
    blackJack.play(dealer, player);
    printResults(player);

  }

  private static Deck getShuffledDeck()
  {
    deck = new Deck();
    deck.shuffle();

    return deck;
  }

  private static Player getPlayer(String name)
  {
    return new Player(name);
  }

  private static Player getDealer(String name)
  {
    return getPlayer(name);
  }

  private static void dealerDrawsCard(Card card)
  {
    dealer.draw(deck, card);
  }

  private static void playerDrawsCard(Card card)
  {
    player.draw(deck, card);
  }

  private static void printResults(Player player)
  {
    System.out.println("############### " + player.getName() + " ##############################");
    System.out.println(player);
  }
}
