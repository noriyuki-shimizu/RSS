package main;

import java.util.Scanner;

import factory.Factory;
import factory.RssFactory;
import product.Product;

/**
 * メインクラス.
 * 
 * @author Noriyuki-Shimizu
 *
 */
public class RssMain {

	public static void main(String[] args) {
		
		parse();
		
	}
	
	private static void parse() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in); // URLを入力させるためのScannerクラス
		
		System.out.println("sample URL: https://hogehoge");
		System.out.println("URLを入力してください。");
		System.out.print("URL: ");
		
		String url = scanner.next();
		
		Factory factory = RssFactory.getInstance();
		Product rss = factory.create(url);
		rss.use(url);
		
		System.out.println("違うURLを入力しますか？(Y/N)");
		String judge = scanner.next();
		
		if(judge.equals("Y")) {
			// 再起関数
			parse();
		} else {
			// 関数を終了する
			return ;
		}
		
	}

}
