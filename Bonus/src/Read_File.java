import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Read_File {

    private Scanner reader;
    //
    public static void main(String args[]){
        System.out.println("everything works");
    }

    public void read(){
        Scanner input = new Scanner(System.in);
        System.out.println("What file do i need to read ? ");
        String filename = input.nextLine();
        OpenFile(filename);
        ReadFile();
        CloseFile();
    }

    public void OpenFile(String filename){
        try {
            reader = new Scanner(new File(filename));
            System.out.println("File was found");
        }catch (Exception e){
            System.out.println("File was not found");
        }
    }

    public void ReadFile(){
        while (reader.hasNext()) {
            String Artist = reader.next();
            String Title = reader.next();
            String Time = reader.next();
            String Song = "Artist : " + Artist + ", Title : " + Title +", Time : " + Time;
            System.out.println(Song);
        }
    }

    public void CloseFile(){
        reader.close();
        System.out.println("File closed successfully");
    }
}
