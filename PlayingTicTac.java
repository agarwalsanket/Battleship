/* 
 * PlayingTicTac.java 
 * 
 * Version: 
 *     $Id$
 * 
 * Revisions: Initial Version
 *    
 */
/**
 * PlayingTicTac  class  extends the abstract class  GameArrangement
 * which implements the method Arrangement and PlayIt
 * 
 * This class handles the entire functionality of the game
 *
 * @author Sanket Agarwal
 * @author Krishna Tippur Gururaj
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayingTicTac extends GameArrangement {

	public Player Arrangement(String name ){  //Initializes the boards/ship for the game


		Player p = new Player(name, 3);

		return p;

	}
	public void PlayIt(Player p1, Player p2, Scanner sc){

		int posRow = 0;
		int posCol = 0;
		int p1row[]  = new int[9];
		int p1col[]  = new int[9];
		int p2row[]  = new int[9];
		int p2col[]  = new int[9];
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		boolean p1win = false;
		boolean p2win = false;

		int counter = 0;

		System.out.println(p1.pName+": it's your turn");
		while(counter < 5){

			System.out.println(p1.pName+": mark your move, enter your row number(0-2) and column number(0-2)");
			try {

				posRow = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			while(posRow > 2){
				System.out.println("Enter a row number more than 0 and less than or equal to 2");
				try {

					posRow = sc.nextInt();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a number");

				}
			}
			p1row[i] = posRow;

			try {

				posCol = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			while(posCol > 2){
				System.out.println("Enter a column number more than 0 and less than or equal to 2");
				try {

					posCol = sc.nextInt();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a number");

				}
			}
			p1col[j] = posCol;
			if(!p1.board[posRow][posCol].equals("X") && !p1.board[posRow][posCol].equals("O")){
				p1.board[posRow][posCol] = "X";
			}
			else{
				System.out.println("This position is already marked");

				continue;

			}



			if((counter == 2 ||counter == 3 )|| counter == 4){

				if((p1.board[0][0].equals("X") && p1.board[0][1].equals("X")) && p1.board[0][2].equals("X")){
					p1win = true;
					break;

				}
				else if((p1.board[1][0].equals("X") && p1.board[1][1].equals("X")) && p1.board[1][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[2][0].equals("X") && p1.board[2][1].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[2][0].equals("X") && p1.board[2][1].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][0].equals("X") && p1.board[1][0].equals("X")) && p1.board[2][0].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][1].equals("X") && p1.board[1][1].equals("X")) && p1.board[2][1].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][2].equals("X") && p1.board[1][2].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][0].equals("X") && p1.board[1][1].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][2].equals("X") && p1.board[1][1].equals("X")) && p1.board[2][0].equals("X")){
					p1win = true;
					break;
				}
				else{
					p1win = false;
				}

				if((p1.board[0][0].equals("O") && p1.board[0][1].equals("O")) && p1.board[0][2].equals("O")){
					p2win = true;
					break;

				}
				else if((p1.board[1][0].equals("O") && p1.board[1][1].equals("O")) && p1.board[1][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[2][0].equals("O") && p1.board[2][1].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[2][0].equals("O") && p1.board[2][1].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][0].equals("O") && p1.board[1][0].equals("O")) && p1.board[2][0].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][1].equals("O") && p1.board[1][1].equals("O")) && p1.board[2][1].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][2].equals("O") && p1.board[1][2].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][0].equals("O") && p1.board[1][1].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][2].equals("O") && p1.board[1][1].equals("O")) && p1.board[2][0].equals("O")){
					p2win = true;
					break;
				}
				else{
					p2win = false;
				}



			}



			if(counter<4){
				boolean turnAround = true;
				do{
					System.out.println(p2.pName+": mark your move, enter your row number(0-2) and column number(0-2)");
					try {

						posRow = sc.nextInt();

					}
					catch(InputMismatchException ex){
						System.out.println("Error"+ ex);
						System.out.println("Enter a number");

					}
					while(posRow > 2){
						System.out.println("Enter a row number more than 0 and less than or equal to 2");
						try {

							posRow = sc.nextInt();

						}
						catch(InputMismatchException ex){
							System.out.println("Error"+ ex);
							System.out.println("Enter a number");

						}
					}
					p2row[k] = posRow;

					try {

						posCol = sc.nextInt();

					}
					catch(InputMismatchException ex){
						System.out.println("Error"+ ex);
						System.out.println("Enter a number");

					}
					while(posCol > 2){
						System.out.println("Enter a column number more than 0 and less than or equal to 2");
						try {

							posCol = sc.nextInt();

						}
						catch(InputMismatchException ex){
							System.out.println("Error"+ ex);
							System.out.println("Enter a number");

						}
					}
					p2col[l] = posCol;
					if(!p1.board[posRow][posCol].equals("X") && !p1.board[posRow][posCol].equals("O") ){
						p1.board[posRow][posCol] = "O";
						turnAround = true;
					}
					else{
						System.out.println("This position is already marked bro");
						turnAround = false;


					}
				}while(turnAround == false);

			}

			if((counter == 2 ||counter == 3 )|| counter == 4){

				if((p1.board[0][0].equals("X") && p1.board[0][1].equals("X")) && p1.board[0][2].equals("X")){
					p1win = true;
					break;

				}
				else if((p1.board[1][0].equals("X") && p1.board[1][1].equals("X")) && p1.board[1][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[2][0].equals("X") && p1.board[2][1].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[2][0].equals("X") && p1.board[2][1].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][0].equals("X") && p1.board[1][0].equals("X")) && p1.board[2][0].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][1].equals("X") && p1.board[1][1].equals("X")) && p1.board[2][1].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][2].equals("X") && p1.board[1][2].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][0].equals("X") && p1.board[1][1].equals("X")) && p1.board[2][2].equals("X")){
					p1win = true;
					break;
				}
				else if((p1.board[0][2].equals("X") && p1.board[1][1].equals("X")) && p1.board[2][0].equals("X")){
					p1win = true;
					break;
				}
				else{
					p1win = false;
				}

				if((p1.board[0][0].equals("O") && p1.board[0][1].equals("O")) && p1.board[0][2].equals("O")){
					p2win = true;
					break;

				}
				else if((p1.board[1][0].equals("O") && p1.board[1][1].equals("O")) && p1.board[1][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[2][0].equals("O") && p1.board[2][1].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[2][0].equals("O") && p1.board[2][1].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][0].equals("O") && p1.board[1][0].equals("O")) && p1.board[2][0].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][1].equals("O") && p1.board[1][1].equals("O")) && p1.board[2][1].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][2].equals("O") && p1.board[1][2].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][0].equals("O") && p1.board[1][1].equals("O")) && p1.board[2][2].equals("O")){
					p2win = true;
					break;
				}
				else if((p1.board[0][2].equals("O") && p1.board[1][1].equals("O")) && p1.board[2][0].equals("O")){
					p2win = true;
					break;
				}
				else{
					p2win = false;
				}



			}

			i++;
			j++;
			k++;
			l++;
			counter++;

		}


		if(p1win == true){
			System.out.println(p1.pName+" , you win!");
			for(int m = 0; m < 3; m++){
				for(int n = 0; n < 3; n++){
					System.out.print(p1.board[m][n]+" ");

				}
				System.out.println();
			}
			System.out.println("X: "+p1.pName+"'s mark");
			System.out.println("O: "+p2.pName+"'s mark");
			System.out.println("#: no marks");
		}
		else if(p2win == true){
			System.out.println(p2.pName+" , you win!");
			for(int m = 0; m < 3; m++){
				for(int n = 0; n < 3; n++){
					System.out.print(p1.board[m][n]+" ");

				}
				System.out.println();
			}
			System.out.println("X : "+p1.pName+"'s mark");
			System.out.println("O : "+p2.pName+"'s mark");
			System.out.println("# : no marks");
		}
		else{
			System.out.println("No one wins");
			for(int m = 0; m < 3; m++){
				for(int n = 0; n < 3; n++){
					System.out.print(p1.board[m][n]+" ");

				}
				System.out.println();
			}
			System.out.println("X :"+p1.pName+"'s mark");
			System.out.println("O :"+p2.pName+"'s mark");
			System.out.println("#: no marks");

		}


	}


	public static void main(String [] args){

		PlayingTicTac t = new PlayingTicTac();
		Player p = new Player();
		Scanner sc  = new Scanner(System.in);

		System.out.println("THE TIC-TAC-TOE GAME");
		System.out.println("Enter the name of the first Player: ");

		try {

			p.pName  = sc.next();

		}
		catch(InputMismatchException ex){
			System.out.println("Error"+ ex);
			System.out.println("Enter a name");

		}

		Player p1 = t.Arrangement(p.pName);
		/*for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(p1.board[i][j]);

			}
			System.out.println();
		}*/

		System.out.println("Enter the name of the second Player: ");

		try {

			p.pName  = sc.next();

		}
		catch(InputMismatchException ex){
			System.out.println("Error"+ ex);
			System.out.println("Enter a name");

		}

		Player p2 = t.Arrangement(p.pName);

		/*for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(p2.board[i][j]);

			}
			System.out.println();
		}
		 */
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Let's start the game:");

		t.PlayIt(p1, p2, sc);


		sc.close();
	}
}
