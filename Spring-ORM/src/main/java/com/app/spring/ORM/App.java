package com.app.spring.ORM;

import java.util.Scanner;
import com.app.spring.entity.Student;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MyMethod mm= new MyMethod();
		Boolean go = true;
		while (go) {
			Student student = new Student();
			System.out.println("Press 1: Insert student");
			System.out.println("Press 2: Display student");
			System.out.println("Press 3: Delete student");
			System.out.println("Press 4: Update student");
			System.out.println("Press 5: Display Single student");
			System.out.println("Press 6:  Exit");

			int no = scanner.nextInt();
			switch (no) {
			case 1:
				
				mm.insert();
				break;
			case 2:
				mm.getAllStudent();
				break;
			case 3:
				mm.deleteStudent();
				break;
			case 4:
			
				mm.updateStudent();
				break;
			case 5:
				mm.getStudent();
				break;
			case 6:
				go = false;
				break;

			default:
				System.out.println("Thank You!!");
				break;
			}
		}

	}
}
