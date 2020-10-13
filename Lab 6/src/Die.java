public class Die {
    /**
     * Represents die value
     */
    private int dieVal;
    /**
     * Represent number of sides on a die
     */
    private int sides;

    /**
     * The die
     * @param s sides
     */
    public Die( int s){
        sides = s;
        dieVal = roll();
    }

    /**
     * Rolls the die and returns the result
     * @return die value
     */
    public int roll(){
        dieVal = (int)( Math.random() * sides ) +1;
        return dieVal;
    }

    /**
     * Retrieves the value of the die
     * @return value of the die
     */
    public int getDieVal(){
        return dieVal;
    }

    /**
     * Compares the die value with the second die value
     * @param dieVal2
     * @return a value that represents if the die value is greater, less, or equal to the second die value
     */
    public int compareTo( Die dieVal2 ){
        return dieVal - dieVal2.getDieVal();
    }

    /**
     * Compare two dice
     * @param o
     * @return true or false if die match
     */
    public boolean equals ( Object o ){
        if ( o instanceof Die) {
            Die d = (Die) o;
            return this.dieVal == d.dieVal && this.sides == d.sides;
        }
        return false;
    }


}
