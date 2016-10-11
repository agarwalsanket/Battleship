/* 
 * PlayingBattleShip.java 
 * 
 * Version: 
 *     $Id$
 * 
 * Revisions: Initial Version
 *    
 */
/**
 * PlayingBattleShip  class  extends the abstract class  GameArrangement
 * which implements the method Arrangement and PlayIt
 * 
 * This class handles the entire functionality of the game
 *
 * @author Sanket Agarwal
 * @author Krishna Tippur Gururaj
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayingBattleShip extends GameArrangement{


	boolean isVacant       = true;
	int counterSize        = 0;
	int shipSize ;

	public Player Arrangement(String name ){  //Initializes the boards/ship for the game


		Player p = new Player(name, 10);

		return p;

	}

	public boolean FleetArrangement(String shipCommon, int posRow,int posColumn, String direction,Player p){

		//Player p = new Player();
		isVacant = true;

		if(shipCommon.equals("carrier")){
			shipSize = 5;
		}
		else if(shipCommon.equals("battleship")){
			shipSize = 4;
		}
		else if(shipCommon.equals("cruiser")){
			shipSize = 3;
		}
		else if(shipCommon.equals("destroyer")){
			shipSize = 2;
		}
		else{
			System.out.println("Not a battleship"+shipCommon);
			return false;
		}

		if(direction.equals("v")){
			if(posRow < 0 || posRow > (9-shipSize)+1){
				System.out.println("Enter a value more than 0 & less than or equal to"+((9-shipSize)+1)+" for row");
				isVacant = false;

			}
			else if(posColumn < 0 || posColumn > 9){
				System.out.println("Enter a value more than 0 & less than or equal to 9 for column");
				isVacant = false;
			}
			else
			{
				if(p.ocean[Math.abs(posRow-1)][posColumn] == "S" || p.ocean[(posRow + shipSize)>9?9:(posRow + shipSize)][posColumn] == "S"){
					isVacant = false;
					System.out.println("There are adjacent ships on its top or bottom");
				} 
				else if(true){
					for(int i = posRow; i < posRow+shipSize; i++){
						if(p.ocean[i][Math.abs(posColumn-1)] == "S" || p.ocean[i][posColumn+1] == "S"){
							isVacant = false;
							System.out.println("There are adjacent ships on its left or right");
							continue;

						}
						else if(p.ocean[i][posColumn] == "S"){
							isVacant = false;
							System.out.println("You are overlapping a ship at position "+ i);
							continue;

						}
						/*else{
							isVacant = true;
						}*/
					}

				}

				if(isVacant == true){

					for(int i = posRow; i < posRow+shipSize; i++){
						p.ocean[i][posColumn] = "S";
					}

				}

			}
		}
		else if(direction.equals("h")){

			if(posRow < 0 || posRow > 9){
				System.out.println("Enter a value more than 0 & less than or equal to 9 for row");
				isVacant = false;

			}
			else if(posColumn < 0 || posColumn > (9-shipSize)+1){
				System.out.println("Enter a value more than 0 & less than or equal to "+((9-shipSize)+1)+"  for column");
				isVacant = false;
			}
			else
			{
				if(p.ocean[posRow][Math.abs(posColumn-1)] == "S" || p.ocean[posRow][(posColumn + shipSize)>9?9:(posColumn + shipSize)] == "S"){
					isVacant = false;
					System.out.println("There are adjacent ships on its left or right");
				} 
				else if(true){
					for(int i = posColumn; i < posColumn+shipSize; i++){
						if(p.ocean[Math.abs(posRow-1)][i] == "S" ||  (p.ocean[((posRow+1)>9?posRow:posRow+1)][i] == "S")){
							isVacant = false;
							System.out.println("There are adjacent ships on its top or bottom");
							continue;

						}
						else if(p.ocean[posRow][i] == "S"){
							System.out.println("You are overlapping a ship at position "+ i);
							isVacant = false;
							continue;

						}
						/*else{
							isVacant = isVacant;
						}
						 */

					}
				}

				if(isVacant == true){


					for(int i = posColumn; i < posColumn+shipSize; i++){
						p.ocean[posRow][i] = "S";
					}

				}
			}

		}
		return isVacant;
	}

	public void PlayIt(Player p1, Player p2, Scanner sc){


		int rowTemp = 0;
		int colTemp = 0;
		int p1Counter = 0;
		int p2Counter = 0;
		while(p1Counter < 14 && p2Counter < 14){
			System.out.println(p1.pName+": enter your guess for "+ p2.pName+ "'s ocean"); 
			System.out.println("feed row # then press enter and then feed column # :");


			try {

				rowTemp = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}

			while(rowTemp > 9){
				System.out.println("Enter a row number more than 0 and less than or equal to 9");
				try {

					rowTemp = sc.nextInt();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a number");

				}
			}

			try {

				colTemp = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			while(colTemp > 9){
				System.out.println("Enter a column number more than 0 and less than or equal to 9");
				try {

					colTemp = sc.nextInt();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a number");

				}
			}

			if(p2.ocean[rowTemp][colTemp].equals("S")){
				p2.ocean[rowTemp][colTemp] = "D";  // D for hit done
				//p1.track[rowTemp][rowTemp] = "H";  //H for keeping track of hits
				System.out.println("Congrats "+p1.pName+"! This was a hit at point:"+ "("+rowTemp+","+colTemp+")"); 
				p1Counter++;
				//System.out.println(p1Counter);
			}
			else if(p2.ocean[rowTemp][colTemp].equals("D")){
				System.out.println("You have already hit this point"); 
			}
			/*else if(p2.ocean[rowTemp][colTemp].equals("X") || p2.ocean[rowTemp][colTemp].equals("0"))            {

			System.out.println("You missed it"+p2.ocean[rowTemp][rowTemp]); 
			p2.ocean[rowTemp][rowTemp] = "X";
		}*/
			else 
			{
				System.out.println("You missed it"); 
				//p1.track[rowTemp][rowTemp]  = "X"; //X for miss both for tracking board and ocean
				p2.ocean[rowTemp][colTemp] = "X";
			}

			System.out.println(p2.pName+": enter your guess for "+ p1.pName+ "'s ocean"); 
			System.out.println("feed row # then press enter and then feed column # :");

			try {

				rowTemp = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			while(rowTemp > 9){
				System.out.println("Enter a row number more than 0 and less than or equal to 9");
				try {

					rowTemp = sc.nextInt();


				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a number");

				}
			}

			try {

				colTemp = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			while(colTemp > 9){
				System.out.println("Enter a column number more than 0 and less than or equal to 9");
				try {

					colTemp = sc.nextInt();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a number");

				}
			}
			if(p1.ocean[rowTemp][colTemp].equals("S")){
				p1.ocean[rowTemp][colTemp] = "D";
				//p2.track[rowTemp][colTemp] = "H"; 
				System.out.println("Congrats "+p2.pName+"! This was a hit at point:"+ "("+rowTemp+","+colTemp+")"); 
				p2Counter++;
				//System.out.println(p2Counter);
			}
			else if(p1.ocean[rowTemp][colTemp].equals("D")){
				System.out.println("You have already hit this point"); 
			}
			/*else if(p1.ocean[rowTemp][colTemp].equals("0") || p1.ocean[rowTemp][colTemp].equals("X")){
System.out.println("You missed it"+p1.ocean[rowTemp][rowTemp]); 
			p1.ocean[rowTemp][rowTemp] = "X";
		}*/
			else{
				System.out.println("You missed it"+p1.ocean[rowTemp][rowTemp]); 
				//p2.track[rowTemp][rowTemp]  = "X"; //X for miss both for tracking board and ocean
				p1.ocean[rowTemp][colTemp] = "X";
			}

		}
		if(p1Counter >= 14){
			System.out.println("Congrats "+p1.pName+"! you won" );
			System.out.println("This is the track record of your hits and miss" );
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					System.out.print(p2.ocean[i][j]+" ");
				}
				System.out.println();

			}

		}
		else if(p2Counter >= 14){
			System.out.println("Congrats "+p2.pName+"! you won" );
			System.out.println("This is the track record of your hits and miss" );
			for(int i = 0; i < 10; i++){
				for(int j = 0; j < 10; j++){
					System.out.print(p1.ocean[i][j]+" ");
				}
				System.out.println();

			}
			System.out.println("D-->Hit  X-->Miss");
		}


	}

	public static void main(String[] args){

		Player p    = new Player();
		//Fleet f     = new Fleet();
		Scanner sc  = new Scanner(System.in);
		int posRow         = 0;
		int posCol         = 0;
		String shipStr     = "";
		String orientation = "h" ;

		PlayingBattleShip f = new PlayingBattleShip();


		System.out.println("THE BATTLESHIP GAME");

		System.out.println("Enter the name of the first Player: ");

		try {

			p.pName  = sc.next();

		}
		catch(InputMismatchException ex){
			System.out.println("Error"+ ex);
			System.out.println("Enter a name");

		}

		Player p1 = f.Arrangement(p.pName);
		int k = 4;
		while(k > 0){
			/*	System.out.println("Enter the  ship(carrier-->1/battleship-->2/cruiser-->3/destroyer-->4) ");
			ship = sc.nextInt();*/

			if(k == 4){
				shipStr = "carrier";
				System.out.println("Enter the location for Carrier");
			}
			else if(k == 3){
				shipStr = "battleship";
				System.out.println("Enter the location for Battleship");
			}
			else if(k == 2){
				shipStr = "cruiser";
				System.out.println("Enter the location for Cruiser");
			}
			else if(k == 1){
				shipStr = "destroyer";
				System.out.println("Enter the location for Destroyer");
			}
			else
			{

				System.out.println("This is not a ship");
				continue;

			}

			System.out.println("Enter the row you want to place your ship(0-9) ");
			try {

				posRow  = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");


			}
			System.out.println("Enter the column you want to place your ship(0-9) ");
			try {

				posCol  = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			System.out.println("Enter the orientation of the ship(v/h)");

			try {

				orientation = sc.next();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a character");

			}

			while(!orientation.contentEquals("h") && !orientation.contentEquals("v") ){
				System.out.println("Enter either h or v");
				try {

					orientation = sc.next();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a character");

				}
			}

			boolean	isFillingDoneP1 =  f.FleetArrangement(shipStr, posRow,posCol,orientation,p1 );

			if(isFillingDoneP1==false){
				continue;
			}
			p1.sumSize = f.counterSize;
			k--;
		}
		System.out.println(p.pName+ "'s ocean");
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				System.out.print(p1.ocean[i][j]);
			}
			System.out.println();

		}
		System.out.println("Do you want to hide it, if yes enter 1 0r else enter 2");
		int Y = 0;
		try {

			Y  = sc.nextInt();

		}
		catch(InputMismatchException ex){
			System.out.println("Error"+ ex);
			System.out.println("Enter a number");

		}

		if(Y == 1){
			for(int i = 0; i < 100; i++){
				System.out.println();	
			}
		}


		System.out.println("Enter the name of the second Player: ");
		//Player p2 = new Player();

		try {

			p.pName  = sc.next();

		}
		catch(InputMismatchException ex){
			System.out.println("Error"+ ex);
			System.out.println("Enter a name");

		}
		Player p2 = f.Arrangement(p.pName);
		int l = 4;
		while(l > 0){
			/*	System.out.println("Enter the  ship(carrier-->1/battleship-->2/cruiser-->3/destroyer-->4) ");
			ship = sc.nextInt();*/

			if(l == 4){
				shipStr = "carrier";
				System.out.println("Enter the location for Carrier");
			}
			else if(l == 3){
				shipStr = "battleship";
				System.out.println("Enter the location for Battleship");
			}
			else if(l == 2){
				shipStr = "cruiser";
				System.out.println("Enter the location for Cruiser");
			}
			else if(l == 1){
				shipStr = "destroyer";
				System.out.println("Enter the location for Destroyer");
			}
			else
			{

				System.out.println("This is not a ship");
				continue;

			}
			System.out.println("Enter the row you want to place your ship(0-9) ");
			try {

				posRow = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			System.out.println("Enter the column you want to place your ship(0-9) ");
			try {

				posCol = sc.nextInt();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a number");

			}
			System.out.println("Enter the orientation of the ship(v/h)");
			try {

				orientation = sc.next();

			}
			catch(InputMismatchException ex){
				System.out.println("Error"+ ex);
				System.out.println("Enter a character");

			}

			while(!orientation.contentEquals("h") && !orientation.contentEquals("v") ){
				System.out.println("Enter either h or v");
				try {

					orientation = sc.next();

				}
				catch(InputMismatchException ex){
					System.out.println("Error"+ ex);
					System.out.println("Enter a character");

				}
			}



			boolean isFillingDoneP2 = f.FleetArrangement(shipStr, posRow,posCol,orientation,p2 );
			if(isFillingDoneP2 ==false){
				continue;
			}
			p2.sumSize = p2.sumSize + p2.tempSize;
			l--;
		}
		System.out.println(p.pName+ "'s ocean");     
		for(int i = 0; i < 10; i++){                  // Printing the ocean
			for(int j = 0; j < 10; j++){
				System.out.print(p2.ocean[i][j]);
			}
			System.out.println();

		}

		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Let's start the game:");

		f.PlayIt(p1,p2,sc);

		sc.close();


	}

}
