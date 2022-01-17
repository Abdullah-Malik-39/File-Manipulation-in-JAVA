package filemanipulation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManipulation 
{
    public static void main(String[] args) throws IOException 
    {
        //Creating a File
        System.out.println("*********************************");
        File myObj = new File("NewFile.txt");
        try {
            if (myObj.createNewFile())
            {
                System.out.println("File created: " + myObj.getName());
            }
            else
            {
                System.out.println("File already exists.");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManipulation.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scanner scan1 = new Scanner(System.in);
        int choice;
        System.out.println("*********************************");
        System.out.println("1. Write data to the File");
        System.out.println("1. Read data from the File");
        System.out.println("Enter choice : ");
        choice = scan1.nextInt();
        
        //Writing Data to files
                
        switch(choice)
        {
            case 1 ->             
            {
                System.out.println("*********************************");
                System.out.println("1. Append Data to File");
                System.out.println("1. Overwrite Previous Data");
                System.out.println("Enter choice : ");
                choice = scan1.nextInt();
                switch (choice) 
                {
                    case 1 -> 
                    {
                        try (FileWriter myWriter = new FileWriter("NewFile.txt",true)) {
                            Scanner scan = new Scanner(System.in);
                            System.out.println("*****WRITING DATA*****");
                            String input = "null";
                            while (true)
                            {
                                input = scan.nextLine();
                                if("quit".equals(input))
                                    break;
                                else
                                    myWriter.write(input + "\n");
                            }
                            System.out.println("Successfully wrote to the file.");
                        }
                    }
                    case 2 -> 
                    {
                        try (FileWriter myWriter = new FileWriter("NewFile.txt")) {
                            Scanner scan = new Scanner(System.in);
                            System.out.println("*****WRITING DATA*****");
                            String input = "null";
                            while (true)
                            {
                                input = scan.nextLine();
                                if("quit".equals(input))
                                    break;
                                else
                                    myWriter.write(input + "\n");
                            }
                            System.out.println("Successfully wrote to the file.");
                        }
                    }
                    default -> System.out.println("Invalid Choice, Quiting Program");
                }
            }
            case 2 ->             
            {
                File myObjR = new File("NewFile.txt");
                Scanner myReader = new Scanner(myObjR);
                System.out.println("*****READING DATA*****");
                while (myReader.hasNextLine()) 
                {
                    String data = myReader.nextLine();
                    System.out.println(data);
                }
                break;
            }
            default -> 
            {
                System.out.println("Invalid Choice!");
                break;
            }
        }    
    }
}
