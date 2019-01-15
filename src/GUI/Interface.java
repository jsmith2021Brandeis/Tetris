/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Navigation.Direction;
import java.util.Scanner;

/**Name: Jacob Smith
 *Date: December 26 2018
 *Assignment: Personal Study, Specifies how the game class should output for my Tetris class
 * This is an example of passing a method as a parameter, putting it in an object
 * ANd it lets me keep code away from the game class
 */
public class Interface {
   
    private InterfaceType mode;
    private TetrisMainWindow window;
    private Scanner reader;
    
    
    /**
     * default constructor, sets output to print to the console
     */
    public Interface(){
        //set the output mode to console, which limits user input
        mode=InterfaceType.CONSOLE;
        reader=new Scanner(System.in);
    }
    
    /**
     * sets the output to be to a graphical window 
     * @param window The Swing object representing the game window
     */
    public Interface(TetrisMainWindow window){
        //set the output mode to window
        mode=InterfaceType.WINDOW;
        //update window instance vairbale with pointer to live window object
        this.window=window;
        
    }
    
    /**
     * Outputs to whatever interface is selection
     * @param toOutput the String to output to the Game
     */
    public void output(String toOutput){
        switch (mode) {
            case CONSOLE:
                System.out.println(toOutput);
                break;
            case WINDOW:
                window.setOutput(toOutput);
                break;    
            default:
                throw new IllegalArgumentException("This output type not prepared for, sorry");
        }
    }
    
    /**
     * Reads user input depending on which mode was selected
     * @return the Direction the user wanted, null if user didn't press a key 
     */
    public Direction input(){
        switch (mode) {
            case CONSOLE:
                String keyPressed=null;
                System.out.println("Please press a Left, s Down, d right, w rotate");
            	//if a key is pressed an enter is hit
                if(reader.hasNext()) {
                	//read keyPress using scanner and return that direction, will stop program
                	keyPressed=reader.next();
                }
                return Direction.getDirection(keyPressed);
            case WINDOW:
                //check if window recieved command, will not stop program
                if(window.recievedCommand()){
                   return window.processCommand();
                }
                return null; 
            default:
                throw new IllegalArgumentException("This output type not prepared for, sorry");
        }
        
    
    }
 
}
