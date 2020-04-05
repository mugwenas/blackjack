package com.za.shadrackmugwena;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Blackjack implementation unit test
 *
 * @author Shadrack Mugwena
 */
public class BlackJackImplTest
{
  private BlackJack classUnderTest = new BlackJackImpl();

  @Rule
  public ExpectedException expectedRule = ExpectedException.none();

  private Fixture fixture;
  private boolean playerWins = false;
  private Deck deck;
  private Player dealer;
  private Player player;

  @Before
  public void setUp()
  {
    fixture = new Fixture();
  }

  @Test
  public void testPlay_nullDealer_ExceptionThrown() throws Exception
  {
    expectedRule.expect(IllegalArgumentException.class);
    expectedRule.expectMessage("Both Dealer and Player can't null");

    fixture.whenPlayIsCalled(null, new Player("Shadrack"));
  }

  @Test
  public void testPlay_nullPlayer_ExceptionThrown() throws Exception
  {
    expectedRule.expect(IllegalArgumentException.class);
    expectedRule.expectMessage("Both Dealer and Player can't null");

    fixture.whenPlayIsCalled(new Player("Dealer"), null);
  }

  @Test
  public void testPlay_cardsLengthLessThanMinimumCardsNumber_ExceptionThrown() throws Exception
  {
    expectedRule.expect(IllegalArgumentException.class);
    expectedRule.expectMessage("Both Dealer and Player must have dealt at least once");

    fixture.givenShuffledDeck();
    fixture.givenDealer("Dealer");
    fixture.givenPlayer("Andrew");

    fixture.whenPlayIsCalled(dealer, player);

  }

  @Test
  public void testPlay_DealerHandValue15_PlayerHandValue25_PlayerLoses() throws Exception
  {
    fixture.givenShuffledDeck();
    fixture.givenDealer("Dealer");
    fixture.givenPlayer("Andrew");

    fixture.givenDealerDrawsCard(new Card(Rank.SIX, Suit.CLUBS));
    fixture.givenDealerDrawsCard(new Card(Rank.NINE, Suit.CLUBS));

    fixture.givenPlayerDrawsCard(new Card(Rank.NINE, Suit.HEARTS));
    fixture.givenPlayerDrawsCard(new Card(Rank.SIX, Suit.SPADES));
    fixture.givenPlayerDrawsCard(new Card(Rank.JACK, Suit.HEARTS));

    fixture.whenPlayIsCalled(dealer, player);

    fixture.thenAssertPlayerLoses();

  }

  @Test
  public void testPlay_DealerHandValue15_PlayerHandValue20_PlayerWins() throws Exception
  {
    fixture.givenShuffledDeck();
    fixture.givenDealer("Dealer");
    fixture.givenPlayer("Billy");

    fixture.givenDealerDrawsCard(new Card(Rank.SIX, Suit.CLUBS));
    fixture.givenDealerDrawsCard(new Card(Rank.NINE, Suit.CLUBS));

    fixture.givenPlayerDrawsCard(new Card(Rank.QUEEN, Suit.SPADES));
    fixture.givenPlayerDrawsCard(new Card(Rank.KING, Suit.CLUBS));

    fixture.whenPlayIsCalled(dealer, player);

    fixture.thenAssertPlayerWins();
  }

  @Test
  public void testPlay_DealerHandValue15_PlayerHandValue21_PlayerWins() throws Exception
  {
    fixture.givenShuffledDeck();
    fixture.givenDealer("Dealer");
    fixture.givenPlayer("Carla");

    fixture.givenDealerDrawsCard(new Card(Rank.SIX, Suit.CLUBS));
    fixture.givenDealerDrawsCard(new Card(Rank.NINE, Suit.CLUBS));

    fixture.givenPlayerDrawsCard(new Card(Rank.TWO, Suit.CLUBS));
    fixture.givenPlayerDrawsCard(new Card(Rank.NINE, Suit.DIAMONDS));
    fixture.givenPlayerDrawsCard(new Card(Rank.KING, Suit.SPADES));

    fixture.whenPlayIsCalled(dealer, player);

    fixture.thenAssertPlayerWins();
  }


  private class Fixture
  {
    private void whenPlayIsCalled(Player dealer, Player player) throws Exception
    {
      playerWins = classUnderTest.play(dealer, player);
    }

    private void thenAssertPlayerWins()
    {
      assertTrue(playerWins);
    }

    private void thenAssertPlayerLoses()
    {
      assertFalse(playerWins);
    }

    private void givenShuffledDeck()
    {
      deck = new Deck();
      deck.shuffle();
    }

    private void givenPlayer(String name)
    {
      player = new Player(name);
    }

    private void givenDealer(String name)
    {
      dealer = new Player(name);
    }

    private void givenPlayerDrawsCard(Card card)
    {
      player.draw(deck, card);
    }

    private void givenDealerDrawsCard(Card card)
    {
      dealer.draw(deck, card);
    }

  }

}