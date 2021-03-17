package mayintarlasi;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int row, column;
	System.out.println("mayin tarlasina hg");
	System.out.println("boyutlari gir");
	System.out.print("row sayisi: ");
	row = scan.nextInt();
	System.out.print("column sayisi: ");
	column = scan.nextInt();
	
	mayintarlasi mayin = new mayintarlasi(row, column);
	mayin.run();
	}
}