public class Player {
    /**
     * Represents three die
     */
    private Die d[];
    /**
     * Represents points
     */
    private int points;

    /** Constructor = create three 6 sided dice */
    public Player(){
        points = 0;
        d = new Die[3];
        for ( int i =0 ; i < d.length ; i++ ){
            d[i] = new Die(6);
        }
    }

    /**
     * Sorts the 3 dice using selection sort
     */
    public void sort(){
        int lowest;
        for ( int i = 0 ; i < d.length - 1 ; i++ ){
            lowest = i;
            for (int j = i + 1 ; j < d.length ; j++ ){
                if ( d[j].compareTo(d[lowest]) < 0 ){
                    lowest = j;
                }
            }
            if ( lowest != i ){
                Die temp = d[i];
                d[i] = d[lowest];
                d[lowest] = temp;
            }
        }
    }

    /**
     * Turns the three die into a string
     * @return
     */
    public String toString(){
        return ( "D1=" + d[0].getDieVal() + ",D2=" + d[1].getDieVal() + ",D3=" + d[2].getDieVal() );
    }

    /**
     * Checks for win condition 3 of a kind
     * @return true of 3 of a kind
     */
    public boolean threeKinds(){
        //Compares only the first and last die because all 3 die are in order
        return d[0].equals(d[2]);
    }

    /**
     * Checks for win condition pair
     * @return returns true if a pair is found
     */
    public boolean pair(){
        if ( d[0].equals(d[1]) || d[1].equals(d[2]) || d[0].equals(d[2]) ){
            return true;
        }
        return false;
    }

    /**
     * Checks for win condition series 3
     * @return true if series 3 is found
     */
    public boolean seriesThree(){
        if ( d[0].compareTo(d[1]) == - 1 && d[1].compareTo(d[2]) == - 1){
            return true;
        }
        return false;
    }

    /**
     * Does the player's turn
     */
    public void takeTurn(){
        for ( int i = 0 ; i < d.length ; i++ ){
            d[i].roll();
        }
        sort();
        System.out.println( "Rolling ... " + toString() );
        //Three of a kind
        if ( threeKinds() ){
            System.out.println( "You got 3 of a kind!");
            points += 3;
        }
        //A pair
        else if ( pair() ){
            System.out.println( "You got a pair!" );
            points += 1;
        }
        //A series of three
        else if ( seriesThree() ){
            System.out.println("You got a series of 3!");
            points += 2;
        }
        //Nothing found, no points
        else{
            System.out.println( "Awww. Too Bad." );
        }
        System.out.println( "Score = " + points + " points");

    }

    /**
     * Retrieves user's points
     * @return points
     */
    public int getPoints( ){
        return points;
    }
}
