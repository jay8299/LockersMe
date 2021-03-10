package com.lockedme;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		/**
		 * Welcome Screen
		 */
		System.out.println("");
		System.out.println("");
		System.out.println(" ".repeat(20) + "*".repeat(30));
		System.out.println(" ".repeat(20) + "*".repeat(30) + "\n");
		System.out.println(" ".repeat(25) + "Welcome to Locked.Me\n");
		System.out.println(" ".repeat(20) + "*".repeat(30));
		System.out.println(" ".repeat(20) + "*".repeat(30));
		System.out.println("\n" + " ".repeat(30) + "Developed by:: \"Teja Vijay Kumar Tiyyagura\"");
		System.out.println("\n" + " ".repeat(30) + "     Contact:: \"ttiyyagura@teksystems.com\"");
		userOptionsMenu();

	}

	public static void userOptionsMenu() {

		/**
		 * Directory Path
		 */
		String path = "C:\\Users\\ttiyyagura\\eclipse-workspace\\LockedMe-TEK-Phase1-End\\files";

		try {
			/**
			 * Main Menu Options
			 */
			System.out.println("\n\n\t" + "*".repeat(15) + " Main Menu " + "*".repeat(15));
			System.out.println("\tOption 1: Display List of Files in a Directory");
			System.out.println("\tOption 2: Perform Business level Operations");
			System.out.println("\tOption 3: Close the Application\n");

			Scanner scan = new Scanner(System.in);
			System.out.print("Enter Any of above options:: ");

			String option = scan.next();

			switch (option) {

			case "1": {
				getFilesList(path);
			}
				break;

			case "2": {
				businessLevelMenu(path);
			}
				break;

			case "3": {
				System.out.println(" ");
				System.out.println("\n\tThank you for using this Prototype");
				System.out.println("\tDeveloped by:: \"Teja Vijay Kumar Tiyyagura\"");
			}
				break;

			default: {
				System.out.println("You have Entered a INVALID OPTIONS");
				System.out.println("Please Enter 1 or 2 or 3 only");
				userOptionsMenu();
			}
			}
			scan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getFilesList(String path) {
		try {
			/**
			 * List files in Directory
			 */
			File directory = new File(path);
			String[] files = directory.list();

			Arrays.sort(files);
			System.out.println("");
			if (files.length != 0) {
				System.out.println("List of the files in the directory::\n");
				for (int i = 0; i < files.length; i++) {
					int index = i + 1;
					System.out.println("\t" + index + ")" + files[i]);
				}
			} else {
				System.out.println("The File directory is Empty\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userOptionsMenu();
	}

	public static void businessLevelMenu(String path) {
		try {
			/**
			 * Business Level Options
			 */
			System.out.println("\n******** Business Options *********");
			System.out.println("Option 1: Add a file");
			System.out.println("Option 2: Delete a file");
			System.out.println("Option 3: Search a file");
			System.out.println("Option 4: Back to Main Menu ");
			System.out.println("Enter any of above options::");
			Scanner da = new Scanner(System.in);
			String data = da.next();

			switch (data) {
			case "1": {

				addFile(path);

			}
				break;
			case "2": {

				deleteFile(path);

			}
				break;
			case "3": {

				searchFile(path);

			}
				break;
			case "4": {

				System.out.println("Redirecting back to Main Menu........");
				userOptionsMenu();

			}
				break;
			default: {
				System.out.println("Invalid option... Please enter valid option");
				businessLevelMenu(path);
			}
				da.close();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addFile(String path) {
		try {
			/** 
			 *  Add File Service
			 */
			System.out.println("Please enter the file name to add::");
			Scanner in = new Scanner(System.in);
			String filename = in.next();

			File f = new File(path + File.separator + filename);

			if (f.createNewFile())
				System.out.println("Sucessfully added file  :" + "'" + f.getName() + "'" + " to the directory");
			else
				System.out.println(f.getName() + ":File already exists ");
			
			businessLevelMenu(path);
			in.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteFile(String path) {
		/** 
		 *  Delete File Service
		 */
		try {
			File directory = new File(path);
			System.out.println("Enter name of file you want to Delete");
			Scanner sc = new Scanner(System.in);
			String data = sc.next();
			String[] flist = directory.list();

			if (flist == null) {
				System.out.println("Empty directory.");
			} else {
				File file = new File(path + File.separator + data);

				if (file.delete())
					System.out.println("File deleted successfully");
				else
					System.out.println("There is no such File to Delete");
			}
			businessLevelMenu(path);
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void searchFile(String path) {
		try {

			File directory = new File(path);

			System.out.println("Enter the file name to search::");
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			// store all names with same name
			// with/without extension
			String[] filelist = directory.list();

			int flag = 0;
			if (filelist.length == 0) {
				System.out.println("The Directory is Empty.");
			} else {

				// Search in the array
				for (String file : filelist) {
					if (file.equals(name)) {
						System.out.println("Found the file:: " + "'" + file + "'");
						flag = 1;
						break;
					}
				}
			}

			if (flag == 0) {
				System.out.println("No File exixts with the name " + "\'" + name + "\'");
			}

			businessLevelMenu(path);
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
