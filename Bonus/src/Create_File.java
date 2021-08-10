import java.io.*;
import java.util.*;
import java.lang.*;

public class Create_File {

    private  PrintWriter file;
    private  boolean loopKeepGoing = true;

    public static void main(String args[]){
        System.out.println("everything works");
    }

    //main method to print out things
    public void album(){
        Scanner x = new Scanner(System.in);
        System.out.println("write down the name of your file : ");

        create_file(x.nextLine());
        System.out.println("Keep adding songs until you're done, in that case write stop");

        while (loopKeepGoing){
            try {
                Scanner text = new Scanner(System.in);
                String phrase = text.nextLine();
                if (phrase.equals("stop")){loopKeepGoing = false;}
                else{write(phrase);}

            }catch (Exception e){
                System.out.println("you entered something wrong, imma shut down");
                loopKeepGoing = false;
            }
        }
        closeFile();
    }

    //method to create a file
    public void create_file(String filename){
        try{
            file = new PrintWriter(filename);
            System.out.println( filename + " was created");
        } catch (FileNotFoundException e) {
            System.out.println("Error happened");
        }
    }

    //method to write in the file
    public void write(String sentences) throws IOException {
        file.print(sentences + " \n");
    }

    //method to close the file
    public void closeFile(){
        file.close();
        System.out.println("the file has been closed");
    }

}
