package com.za.shadrackmugwena;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * A hand class unit test
 *
 * @author Shadrack Mugwena
 */
public class HandTest
{
  private Hand classUnderTest = new Hand();

  private Fixture fixture;
  private Card card;
  private int computedValue;

  @Before
  public void setUp()
  {
    fixture = new Fixture();
  }

  @Test
  public void testGetValue_Cards_Without_Ace()
  {
    fixture.givenCardsOnHandWithoutAce();
    fixture.whenGetValueIsCalled();
    fixture.thenAssertComputedValue(23);
  }

  @Test
  public void testGetValue_Cards_With_Ace()
  {
    fixture.givenCardsOnHandWithAce();
    fixture.whenGetValueIsCalled();
    fixture.thenAssertComputedValue(20);
  }

  @Test
  public void testAddCard()
  {
    fixture.givenCard(Rank.FIVE, Suit.DIAMONDS);
    fixture.whenAddCardIsCalled(card);
    fixture.thenAssertHandSize(1);
  }

  private class Fixture
  {
    private void givenCard(Rank rank, Suit suit)
    {
      card = new Card(rank, suit);
    }

    private void whenAddCardIsCalled(Card card)
    {
      classUnderTest.addCard(card);
    }

    private void whenGetValueIsCalled()
    {
      computedValue = classUnderTest.getValue();
    }

    private void thenAssertComputedValue(int expectedValue)
    {
      assertEquals(expectedValue, computedValue);
    }

    private void thenAssertHandSize(int expectedValue)
    {
      assertEquals(expectedValue, classUnderTest.getCards().size());
    }

    private void givenCardsOnHandWithoutAce()
    {
      classUnderTest.getCards().addAll(Arrays.asList(
              new Card(Rank.FIVE, Suit.HEARTS), new Card(Rank.EIGHT, Suit.SPADES), new Card(Rank.KING, Suit.DIAMONDS)));
    }

    private void givenCardsOnHandWithAce()
    {
      classUnderTest.getCards().addAll(Arrays.asList(
              new Card(Rank.ACE, Suit.HEARTS), new Card(Rank.EIGHT, Suit.SPADES),
              new Card(Rank.KING, Suit.DIAMONDS), new Card(Rank.ACE, Suit.SPADES)));
    }
  }

}