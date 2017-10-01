package main;

import java.util.Scanner;

import factory.Factory;
import factory.RssFactory;
import product.Product;

/**
 * ���C���N���X.
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
		Scanner scanner = new Scanner(System.in); // URL����͂����邽�߂�Scanner�N���X
		
		System.out.println("sample URL: https://hogehoge");
		System.out.println("URL����͂��Ă��������B");
		System.out.print("URL: ");
		
		String url = scanner.next();
		
		Factory factory = RssFactory.getInstance();
		Product rss = factory.create(url);
		rss.use(url);
		
		System.out.println("�ႤURL����͂��܂����H(Y/N)");
		String judge = scanner.next();
		
		if(judge.equals("Y")) {
			// �ċN�֐�
			parse();
		} else {
			// �֐����I������
			return ;
		}
		
	}

}
