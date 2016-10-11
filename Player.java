/* 
 * Player.java 
 * 
 * Version: 
 *     $Id$
 * 
 * Revisions: Initial Version
 *    
 */
/**
 * Player class creates the profile for the two players.
 *
 * @author Sanket Agarwal
 * @author Krishna Tippur Gururaj
 */
public class Player{

	String pName;
	int sumSize  = 0;
	int tempSize     = 0;

	String[][] ocean    = new String[10][10];
	String[][] board    = new String[3][3];



	public Player(){

	}
	public Player(String pName, int n){



		this.pName = pName;

		if(n == 10){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					ocean[i][j] = "0";

				}

			}
		}

		else if(n == 3){
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					board[i][j] = "#";

				}

			}
		}
	}
}
