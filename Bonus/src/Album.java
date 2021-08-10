import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;

public class Album {
    public static int no_alb = 0;
    public int no_album;
    private ArrayList<Song> songs = new ArrayList<>();
    private Time time;

    public static void main(String args[]){
        System.out.println("Yeah that's alright mate");
    }

    public Album(){
        this.no_album = no_alb;
        this.songs = null;
        this.time = null;
        no_alb += 1;
    }

    public Time getTime(){
        return this.time;
    }

    public void addSong(Song song){
        if (this.songs == null) {
            this.songs = new ArrayList<>();
            this.songs.add(song);
            Time temps = new Time(song.getTime().to_seconds());
            this.time = temps;
        }else {
            this.songs.add(song);
            this.time = this.time.add(song.getTime());
            }
    }

    public String headline(){
        String head = "Album no : " + this.no_album + ", " + this.time.toString();
        return head;
    }

    public String toString(){
        String to_print = this.headline() + "\n";
        if (this.songs != null) {
            for (Song song:this.songs) {
                to_print += song.toString() + "\n";
            }
        }
        return to_print;
    }

}
