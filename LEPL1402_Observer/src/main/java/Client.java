public class Client extends Observer {


    public Client(int zone){
        this.zone = zone;
        this.news = "";
    }


    public void update(Object o) {
        if (o instanceof String){
            this.news = (String) o;
        }
    }


    public int getZone() {
        return this.zone;
    }


    public String getNews() {
        return this.news;
    }
}
