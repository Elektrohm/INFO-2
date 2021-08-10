public class Song {
    private String artist;
    private String title;
    public Time time;

    public static void main(String args[]){
        System.out.println("hello there");
    }

    public Song(String artist, String title, int time){
        Time temps = new Time(time);
        this.artist = artist;
        this.title = title;
        this.time = temps;
    }

    @Override
    public String toString() {
        String head = "Artist : " + this.artist + ", title : " + this.title + ", " + this.time.toString();
        return head;
    }

    public String getArtist() { return this.artist; }
    public String getTitle() { return this.title; }
    public Time getTime() { return this.time; }
}
