package test;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import sample.Ship;

public class GameBoard {

    // Fields
    final int boardSize; // the game board will have this many number of rows and columns
    GridCell[] gridCells;

    // Constructor
    public GameBoard(int boardSize, Button[] buttons) {
        this.boardSize = boardSize;
        this.gridCells = new GridCell[boardSize * boardSize];
        initializeCells(buttons);
    }


    // Methods

    void initializeCells(Button[] cells) {
        for (int i = 0; i < boardSize * boardSize; i++) {
            gridCells[i] = new GridCell( -1, cells[i]);
        }
    }

    // this cell has been fired at
    // update accordingly
    // returns true if it's a valid move, false otherwise
    boolean updateCell(Button cellBtn) {
        GridCell cell = gridCells[Integer.parseInt(cellBtn.getId())]; // fetch GridCell instance connected to this button

        if ( cell.isHit() ) { return false; } // return if this cell's already been hit

        // TODO dertermine if the cell is occupied and update cell accordingly
        if ( cell.getOwner() == -1 ) {
            cell.getButton().setText("X");
        }
        cell.setHit();

        // test only remove later changes color of the button
        cell.setColor("salmon");
        return true;
    }
}

