public class Time {
    private int hour;
    private int minute;
    private int second;

    public static void main(String args[]){
        System.out.println("everything is under control");
    }

    public Time(int time){
        this.hour = time/3600;
        this.minute = (time-this.hour*3600)/60;
        this.second = time%60;
    }

    @Override
    public String toString(){
        String head = "Hour(s) : "+this.hour+", Minute(s) : "+this.minute+", Second(s) : "+this.second ;
        return head;
    }

    public Time add(Time other){
        this.minute = this.minute + other.minute;
        this.second = this.second + other.second;
        this.hour = this.hour + other.hour;
        if (this.second>=60){
            while (this.second >= 60){
                this.second-=60;
                this.minute+=1;
            }
        }
        if (this.minute>=60) {
            while (this.minute >= 60) {
                this.minute -= 60;
                this.hour += 1;
            }
        }
        return this;
    }

    public int to_seconds(){
        return this.hour*3600+this.minute*60+this.second;
    }

    public int getHour(){ return this.hour; }
    public int getMinute(){ return this.minute; }
    public int getSecond(){ return this.second; }
}
