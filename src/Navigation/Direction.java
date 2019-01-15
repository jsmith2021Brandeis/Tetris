/**Name: Jacob Smith
  *Email:jsmith2021@brandeis.edu 
  *Date: Dec 20, 2018 
  *Assignment:	Personal Study, holds the directions the pieces can move
  *Bugs: getDirection creates  new array each time...
  *Nice things: All of the multiwya if statements having to do with directions are replaced with using an array of enums, makes
  *     changing anything in here safe to the rest of the program!
  */
package Navigation;

public enum Direction {
	DOWN (0,1,"S"),LEFT (-1,0,"A"),RIGHT(1,0,"D"),ROTATELEFT(0,0,"W");
	
	private final int horizOffset;
	private final int vertOffset;
	private final String key;
        
	/**
	 * Creates a new Direction object
	 * @param horizOffset how much object moves left/right
	 * @param vertOffset how much piece moves up/down
         * @param key the key associated with that direction
	 */
	private Direction(int horizOffset,int vertOffset,String key) {
		this.horizOffset=horizOffset;
		this.vertOffset=vertOffset;
                this.key=key;
	}
        
        /**
         * Useful for parsing user Key Press
         * @param keyPressed a String representing the key that was pressed
         * @return the direction mapped to keyPressed String, null if no direction found
         */
        public static Direction getDirection(String keyPressed){
        Direction []directions=Direction.values();
            for(int i=0;i<directions.length;i++){
                Direction d=directions[i];
                String key=d.getKey();
                //ignoring case to handle the lowercase key binding
                if(keyPressed.equalsIgnoreCase(key)){
                   return d;
                }
            
            }
            return null;
        }
	/**
	 * 
	 * @return how much Object should move up or down
	 */
	public int getVertOffset() {
		return vertOffset;
	}
	
	/**
	 * 
	 * @return how much Object should move left or right
	 */
	public int getHorizOffset() {
		return horizOffset;
	}
        
        /*
        * @return the key associated with that key
        */
        public String getKey(){
           return key;
        }
        
}
