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
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
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
    public void update()
    {
        int left = 0;  //.. imaginary left neighbor of cell 0
        int center = state[0];  // current cell
        int right;
        for (int i = 0; i < state.length; i++) {
            //determine right neighbor (next cell)
            if (i + 1 < state.length) {
                right = state[i + 1];
            
        } else { 
            right = 0;
    }
}
int newValue = (left + center + right) % 2;
left = center;
center = right;
// new value to current position
state[i] = newValue;
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
