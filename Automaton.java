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
    public Automaton(int numberOfCells) // question 36
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells + 1]; //+1 extra neighbor
        nextState = new int[numberOfcells]; //actual cells are stored
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
    public void update() // question 36   
    {
        int left = 0;
        int center = state[0];
        for (int i = 0; i < numberOfCells; i++) {
            int right = state[i + 1];
            nextState[i] = calculateNextState(left, center, right);
            left = center;
            center = right;
        }
        for (int i = 0; i < numberOfCells; i++) {
            state[i] = nextState[i];
        }
        state[numberOfCells] = 0;
    }
    private int calculateNextState(int left, int center, int right) {

        (center + right + center * right + left * center * right) % 2;
    }
    
        
    
}
