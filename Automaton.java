import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 7.1
 */
public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    private int[] nextState;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells + 1];
        // Seed the automaton with a single 'on' cell in the middle.
        state[numberOfCells / 2] = 1;
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update() // question 32    {
        int left = 0;
        int center = state[0];
        for(int i = 0; i<numberOfCells; i++) {
            int right = (i == numberOfCells - 1) ? 0 : state[i + 1]; //neigbor to the right
            int newCenter = calculateNextState(left , center, right);
            
            // new value for this cell
            state[i] = newCenter;
            
            // for next iteration
            left = center;
            center = right;
        }
        state[numberOfCells] = 0;
        

        }private int calculateNextState(int left, int right, int center) {
            return (left + center + right * right + left * center * right) % 2;
        }
  

    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        // Randomly turn on 5 cells
        for (int i = 0; i <5; i++) {
            int index = (int)(Math.random() * numberOfCells);
            state[index] = 1;
    }
}
}
