package mayintarlasi;

import java.util.Random;
import java.util.Scanner;

//bos ise ve etrafinda mine yoksa -2

public class mayintarlasi {
	int rowNum, colNum, size;
	int[][] map;
	int[][] board;
	boolean game = true;
	
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	mayintarlasi(int rowNum, int colNum){
		this.rowNum = rowNum;
		this.colNum = colNum;
		this.map = new int[rowNum][colNum];
		this.board = new int[rowNum][colNum];
		this.size = rowNum*colNum;
		}

	public void run() {
		int row, col, success= 0;
		prepareGame();
		print(map);
		System.out.println("oyun basladi");
		
		while(game) {
			print(board);
			System.out.println("row: ");
			row = scan.nextInt();
			System.out.println("col: ");
			col = scan.nextInt();
				if(row < 0 || row >= rowNum) {
					System.out.println("gecersiz koordinat girdiniz");
					continue;
				}if(col < 0 || col >= colNum) {
					System.out.println("gecersiz koordinat girdiniz");
					continue;
				}			
			if (map[row][col] != -1) {
				checkMineExistence(row, col);
				success++;
				if (success == (size - (size / 4))) {
					System.out.println("basarili hicbir mayina basmadiniz");
					break;
				}
			}else {
				game = false;
				System.out.println("oyun bitti");
			}
		}
	}
	
	public void checkMineExistence(int r, int c) {
		if (map[r][c] == 0) {
			if((c < colNum - 1) && (board[r][c+1] == -1)) { //sag
				board[r][c]++;
			}if ((r < rowNum - 1) && (map[r+1][c] == -1)) { //ust
				board[r][c]++;
			}if ((r > 0) && (map[r-1][c] == -1)) { //sol
				board[r][c]++;
			}if ((c > 0) && (map[r][c-1] == -1)) { //alt
				board[r][c]++;
			}
			
			if(board[r][c] == 0) {
				board[r][c] = -2;
			}
			
		}
	}
	
	
	public void prepareGame() {
		int randRow, randCol, count = 0;
		while(count != (size/4)) {
			randRow = rand.nextInt(rowNum);
			randCol = rand.nextInt(colNum);
			if (map[randRow][randCol] != -1) { //mayin eklenmediyse
				map[randRow][randCol] = -1;
				count++;
			}
		}
	}
	
	public void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] >= 0) {
					System.out.print(" "); 
				}
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
