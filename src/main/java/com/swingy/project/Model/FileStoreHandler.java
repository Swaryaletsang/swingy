package com.swingy.project.Model;

import java.io.*;
import java.lang.NumberFormatException;
import java.util.ArrayList;

public class FileStoreHandler {
    static Player player = Player.getInstance();

    public static int create(){
        try {

			// Get the name of the contact to be updated 
			// from the Command line argument 
			String newPlayer = player.getName()+","+player.getLevel()+","+player.getExperience()+","+player.getAttack()+","+player.getDefence()+","+player.getHitPoints()+","+player.getWeapon()+","+player.getArmor(); 

			// Get the number to be updated 
			// from the Command line argument 
			// long newNumber = Long.parseLong(data[1]); 

			String info; 
			String name; 
			int index; 

			// Using file pointer creating the file. 
			File file = new File("./players.txt"); 

			if (!file.exists()) { 

				// Create a new file if not exists. 
				file.createNewFile(); 
			} 

			// Opening file in reading and write mode. 

			RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
			boolean found = false; 

			// Checking whether the name 
			// of contact already exists. 
			// getFilePointer() give the current offset 
			// value from start of the file. 
			while (raf.getFilePointer() < raf.length()) { 

				// reading line from the file. 
				info = raf.readLine(); 

				// finding the position of '!' 
				index = info.indexOf(','); 

				// separating name and number. 
                name = info.substring(0, index);  

				// if condition to find existence of record. 
				if (name.equals(newPlayer.substring(0,index))) { 
					found = true; 
					break; 
				} 
			} 

			if (found == false) { 

				// Enter the if block when a record 
				// is not already present in the file. 
				info = newPlayer;

				// writeBytes function to write a string 
				// as a sequence of bytes. 
				raf.writeBytes(info); 

				// To insert the next record in new line. 
				raf.writeBytes(System.lineSeparator()); 

				// Print the message 
				System.out.println(" Success "); 

				// Closing the resources. 
                raf.close(); 
                return 1;
			} 
			// The contact to be updated 
			// could not be found 
			else { 

				// Closing the resources. 
				raf.close(); 

				// Print the message 
                System.out.println("player name already exists");
                return 0; 
			} 
		} 

		catch (IOException ioe) { 

			System.out.println(ioe); 
		} 
		catch (NumberFormatException nef) { 

			System.out.println(nef); 
		}
        return 0;
    }
    public static ArrayList<String> read(){
        try { 

            ArrayList<String> players = new ArrayList<String>();
			String newPlayer; 
			String name;
			int index; 

			// Using file pointer creating the file. 
			File file = new File("players.txt"); 

			if (!file.exists()) { 

				// Create a new file if not exists. 
				file.createNewFile(); 
			} 

			// Opening file in reading and write mode. 

			RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
			boolean found = false; 

			// Traversing the file 
			// getFilePointer() give the current offset 
            // value from start of the file. 
			while (raf.getFilePointer() < raf.length()) { 

				// reading line from the file. 
				newPlayer = raf.readLine(); 

				// finding the position of '!' 
				index = newPlayer.indexOf(','); 

				// separating name and number. 
				name = newPlayer.substring(0, index); 

				// Print the contact data 
				players.add(name); 
            }
            raf.close();
            return players;
        }

			catch (IOException ioe) 
			{ 

				System.out.println(ioe); 
			} 
			catch (NumberFormatException nef) 
			{ 

				System.out.println(nef); 
			}
            return null;
    }
	public static String read(String _name) {
        try { 
			String selectedPlayer; 
			String name;
			int index; 

			// Using file pointer creating the file. 
			File file = new File("players.txt"); 

			if (!file.exists()) { 

				// Create a new file if not exists. 
				file.createNewFile(); 
			} 

			// Opening file in reading and write mode. 

			RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
			boolean found = false; 

			// Traversing the file 
			// getFilePointer() give the current offset 
            // value from start of the file. 
			while (raf.getFilePointer() < raf.length()) { 

				// reading line from the file. 
				selectedPlayer = raf.readLine(); 

				// finding the position of '!' 
				index = selectedPlayer.indexOf(','); 

				// separating name and number. 
				name = selectedPlayer.substring(0, index); 

                // check if name available
                if (name.equals(_name)) {
                    return selectedPlayer;
                }
            }
            raf.close();
        }

			catch (IOException ioe) 
			{ 

				System.out.println(ioe); 
			} 
			catch (NumberFormatException nef) 
			{ 

				System.out.println(nef); 
			}
            return null;
	} 
    public static void update(String _name){

		try { 

			// Get the name of the contact to be updated 
			// from the Command line argument 
			String newName = _name+","+player.getLevel()+","+player.getExperience()+","+player.getAttack()+","+player.getDefence()+","+player.getHitPoints()+","+player.getWeapon()+","+player.getArmor();

			// Get the number to be updated 
			// from the Command line argument  

			String nameNumberString; 
			String name; 
			int index; 

			// Using file pointer creating the file. 
			File file = new File("players.txt"); 

			if (!file.exists()) { 

				// Create a new file if not exists. 
				file.createNewFile(); 
			} 

			// Opening file in reading and write mode. 
			RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
			boolean found = false; 

			// Checking whether the name 
			// of contact already exists. 
			// getFilePointer() give the current offset 
			// value from start of the file. 
			while (raf.getFilePointer() < raf.length()) { 

				// reading line from the file. 
				nameNumberString = raf.readLine(); 

				// finding the position of '!' 
				index = nameNumberString.indexOf(','); 

				// separating name and number. 
				name = nameNumberString.substring(0, index); 

				// if condition to find existence of record. 
				if (name.equals(newName.substring(0, index))) { 
					found = true; 
					break; 
				} 
			} 

			// Update the contact if record exists. 
			if (found == true) { 

				// Creating a temporary file 
				// with file pointer as tmpFile. 
				File tmpFile = new File("temp.txt"); 

				// Opening this temporary file 
				// in ReadWrite Mode 
				RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw"); 

				// Set file pointer to start 
				raf.seek(0); 

				// Traversing the friendsContact.txt file 
				while (raf.getFilePointer() < raf.length()) { 

					// Reading the contact from the file 
					nameNumberString = raf.readLine(); 

					index = nameNumberString.indexOf(','); 
					name = nameNumberString.substring(0, index); 

					// Check if the fetched contact 
					// is the one to be updated 
					if (name.equals(newName.substring(0, index))) { 

						// Update the number of this contact 
						nameNumberString = newName; 
					} 

					// Add this contact in the temporary file 
					tmpraf.writeBytes(nameNumberString); 
 
				} 

				// The contact has been updated now 
				// So copy the updated content from 
				// the temporary file to original file. 

				// Set both files pointers to start 
				raf.seek(0); 
				tmpraf.seek(0); 

				// Copy the contents from 
				// the temporary file to original file. 
				while (tmpraf.getFilePointer() < tmpraf.length()) { 
					raf.writeBytes(tmpraf.readLine()); 
				} 

				// Set the length of the original file 
				// to that of temporary. 
				raf.setLength(tmpraf.length()); 

				// Closing the resources. 
				tmpraf.close(); 
				raf.close(); 

				// Deleting the temporary file 
				tmpFile.delete(); 

				System.out.println(" updated. "); 
			} 

			// The contact to be updated 
			// could not be found 
			else { 

				// Closing the resources. 
				raf.close(); 

				// Print the message 
				System.out.println(" Input name" + " does not exists. "); 
			} 
		} 

		catch (IOException ioe) { 
			System.out.println(ioe); 
		} 

		catch (NumberFormatException nef) { 
			System.out.println(nef); 
		} 

    }
    public static void delete(String _name){
        try { 

			// Get the name of the contact to be updated 
			// from the Command line argument 
			String newName = _name; 

			String nameNumberString; 
			String name;  
			int index; 

			// Using file pointer creating the file. 
			File file = new File("players.txt"); 

			if (!file.exists()) { 

				// Create a new file if not exists. 
				file.createNewFile(); 
			} 

			// Opening file in reading and write mode. 
			RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
			boolean found = false; 

			// Checking whether the name of contact exists. 
			// getFilePointer() give the current offset 
			// value from start of the file. 
			while (raf.getFilePointer() < raf.length()) { 

				// reading line from the file. 
				nameNumberString = raf.readLine(); 

				// finding the position of '!' 
				index = nameNumberString.indexOf(','); 

				// separating name and number. 
				name = nameNumberString.substring(0, index); 

				// if condition to find existence of record. 
				if (name.equals(newName)) { 
					found = true; 
					break; 
				} 
			} 

			// Delete the contact if record exists. 
			if (found == true) { 

				// Creating a temporary file 
				// with file pointer as tmpFile. 
				File tmpFile = new File("temp.txt"); 

				// Opening this temporary file 
				// in ReadWrite Mode 
				RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw"); 

				// Set file pointer to start 
				raf.seek(0); 

				// Traversing the friendsContact.txt file 
				while (raf.getFilePointer() < raf.length()) { 

					// Reading the contact from the file 
					nameNumberString = raf.readLine(); 

					index = nameNumberString.indexOf(','); 
					name = nameNumberString.substring(0, index); 

					// Check if the fetched contact 
					// is the one to be deleted 
					if (name.equals(newName)) { 

						// Skip inserting this contact 
						// into the temporary file 
						continue; 
					} 

					// Add this contact in the temporary file 
					tmpraf.writeBytes(nameNumberString); 

                    // Add the line separator in the temporary file
                    raf.writeBytes(System.lineSeparator()); 
				} 

				// The contact has been deleted now 
				// So copy the updated content from 
				// the temporary file to original file. 

				// Set both files pointers to start 
				raf.seek(0); 
				tmpraf.seek(0); 

				// Copy the contents from 
				// the temporary file to original file. 
				while (tmpraf.getFilePointer() < tmpraf.length()) { 
					raf.writeBytes(tmpraf.readLine()); 
				} 

				// Set the length of the original file 
				// to that of temporary. 
				raf.setLength(tmpraf.length()); 

				// Closing the resources. 
				tmpraf.close(); 
				raf.close(); 

				// Deleting the temporary file 
				tmpFile.delete();  
			} 

			// The contact to be deleted 
			// could not be found 
			else { 

				// Closing the resources. 
				raf.close(); 

				// Print the message 
				System.out.println(" Input name" + " does not exists. "); 
			} 
		} 

		catch (IOException ioe) { 
			System.out.println(ioe); 
		} 
    }
}



