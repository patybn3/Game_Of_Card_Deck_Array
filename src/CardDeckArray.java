
public class CardDeckArray implements CardDeckInterface
{
    protected Card[] cardArray;
    protected int topIndex = -1;
    private final int MAXNUM = 52;
    //collects points to find a winner
    private int playerOneCount = 0;
    private int playerTwoCount = 0;

    public CardDeckArray()
    {
        cardArray = new Card[MAXNUM];
        //using the interface as the type for the reference variable
        //There are 52 cards in a deck
        insertIntoDeck();
    }

    public void insertIntoDeck()
    {
        //topIndex = -1;
        int i = 0;
        //A-King, there are 13 cards each suit
        while( i < 13 )
        {
            //suits, hearts, diamond, spade and clubs = 4
            for(int j = 0; j < 4; j++)
            {
                topIndex++;
                cardArray[topIndex] = new Card(j, i);
            }
            i++;
        }
    }

    @Override
    public Card draw()
    {
        if(topIndex >= 0)
        {
            Card holder = cardArray[topIndex];
            topIndex--;
            return holder;
        }
        return null;
    }

    @Override
    public void shuffle()
    {
        for (int i = 0; i < topIndex + 1; i++)
        {
            int randomNum = (int)(Math.random() * i);
            Card holder = cardArray[randomNum];
            cardArray[randomNum] = cardArray[i];
            cardArray[i] = holder;
        }
    }

    @Override
    public int size()
    {
        return topIndex +1;
    }

    //this method will start a game of 5 rounds, each player will draw their cards, randomly
    //the cards will be compared to each other, face and suit, and a winner will be picked.
    public void playCards()
    {
        Card player1Card, player2Card;
        int i = 0;

        System.out.println("There are "+ size() + " cards in the deck");

        while(i < 6)
        {
            System.out.println("Deck is being shuffled\n");
            shuffle();

            player1Card = draw();
            System.out.print("Player 1 drew the " + player1Card);
            System.out.println(" - " + size() + " cards left in the deck");

            player2Card =  draw();
            System.out.print("Player 2 drew the " + player2Card);
            System.out.println(" - " + size() + " cards left in the deck\n");

            // order suits = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES"};
            if(player1Card.getSuit() == player2Card.getSuit())
            {
                if(player1Card.getFace() == player2Card.getFace())
                {
                    System.out.println("Its a tie!! \n- Player 1 with " + player1Card);
                    System.out.println("- Player 2 with " + player2Card + "\n");
                    playerOneCount++;
                    playerTwoCount++;
                }
                else if(player1Card.getFace() > player2Card.getFace())
                {
                    System.out.println("Round Winner = PLayer 1 with " + player1Card + "\n");
                    playerOneCount++;
                }
                else
                {
                    System.out.println("Round Winner = Player 2 with " + player2Card + "\n");
                    playerTwoCount++;
                }

            }
            else if (player1Card.getSuit() > player2Card.getSuit())
            {
                System.out.println("Round Winner = PLayer 1 with " + player1Card + "\n");
                playerOneCount++;
            }
            else
            {
                System.out.println("Round Winner = Player 2 with " + player2Card +  "\n");
                playerTwoCount++;
            }

            i++;
        }

        if(playerOneCount == playerTwoCount)
        {
            System.out.println("Player 1 points: " + playerOneCount + " vs. Player 2 points: " + playerTwoCount);
            System.out.println("\nWe have a tie!!!");
        }
        else if(playerOneCount > playerTwoCount)
        {
            System.out.println("Player 1 points: " + playerOneCount + " vs. Player 2 points: " + playerTwoCount);
            System.out.println("\nWINNER = Player 1");
        }
        else
        {
            System.out.println("Player 1 points: " + playerOneCount + " vs. Player 2 points: " + playerTwoCount);
            System.out.println("\nWINNER = Player 2");
        }
    }
}
