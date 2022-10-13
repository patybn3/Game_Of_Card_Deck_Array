//You will need to create a Card class; you can create your own or use the one in the README file:
public class Card
{
    // I read this source https://fpl.cs.depaul.edu/jriely/thinkapjava/thinkapjava.array2.html
    public static final String[] SUITS = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
    public static final String[] FACES = {"ACE", "2", "3", "4", "5", "6", "7", "8", "9", "10", "JACK", "QUEEN", "KING"};

    private int suit;
    private int face;
    // I change the parameters from string to int
    //I think ints will facilitate the loop
    public Card(int suit, int face)
    {
        this.suit = suit;
        this.face = face;
    }

    public int getSuit()
    {
        return suit;
    }

    public void setSuit(int suit)
    {
        this.suit = suit;
    }

    public int getFace()
    {
        return face;
    }

    public void setFace(int face)
    {
        this.face = face;
    }

    public String toString()
    {
        return "Card = " + FACES[face] + " of " + SUITS[suit];
    }
}

