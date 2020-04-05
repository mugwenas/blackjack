package com.za.shadrackmugwena;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for Deck class
 *
 * @author Shadrack Mugwena
 */
public class DeckTest
{
  private static final int STANDARD_DECK_SIZE = 52;

  private Deck classUnderTest = new Deck();

  private Fixture fixture;
  private Rank rank;
  private Suit suit;
  private Card card;

  @Before
  public void setUp()
  {
    fixture = new Fixture();
  }

  @Test
  public void testDeckSize_size52()
  {
    fixture.thenAssertDeckSize(STANDARD_DECK_SIZE);
  }

  @Test
  public void testDealCardShuffle_deckSizeLess()
  {
    fixture.whenDealCardIsCalled(null);
    fixture.thenAssertDeckSize(STANDARD_DECK_SIZE - 1);
  }

  @Test
  public void testDealCardSpecific_deckSizeLess()
  {
    fixture.givenRank(Rank.EIGHT);
    fixture.givenSuit(Suit.CLUBS);
    fixture.givenCard(rank, suit);
    fixture.whenDealCardIsCalled(card);
    fixture.thenAssertDeckSize(STANDARD_DECK_SIZE - 1);
  }


  private class Fixture
  {
    private void givenRank(Rank value)
    {
      rank = value;
    }

    private void givenSuit(Suit value)
    {
      suit = value;
    }

    private void givenCard(Rank rank, Suit suit)
    {
      card = new Card(rank, suit);
    }

    private void whenDealCardIsCalled(Card card)
    {
      if (null == card)
      {
        classUnderTest.dealCard();
      }
      else
      {
        classUnderTest.dealCard(card);
      }
    }

    private void thenAssertDeckSize(int expectedSize)
    {
      assertEquals(expectedSize, classUnderTest.getDeck().size());
    }

  }

}