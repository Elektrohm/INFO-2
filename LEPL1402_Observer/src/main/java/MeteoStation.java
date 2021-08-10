public class MeteoStation extends Observable {

    //seems ok
    public Observer[] getSubscribers() {
        Observer[] Subscribers = new Observer[subscribers.size()];
        for (int i = 0; i<subscribers.size(); i++){
            Subscribers[i] = subscribers.get(i);
        }
        return Subscribers;
    }

    //seems ok
    public void broadcast(Pair<String, Integer> pair) {
        Observer[] subList = getSubscribers();
        for (Observer sub : subList){
            Pair thisZone = new Pair(null,sub.getZone());
            if (pair.equals(thisZone)){
                sub.update(pair.getAlert());
            }
        }
    }

    //seems ok
    public void addObserver(Observer sub) {
        if (!subscribers.contains(sub)) {
            subscribers.add(sub);
        }
    }

    //seems ok
    public boolean removeObserver(Observer sub) {
        if (sub != null) {
            return subscribers.remove(sub);
        }
        return false;
    }


    public void setAlert(String alert, int zone) {
        Observer[] subList = getSubscribers();
        for (Observer sub : subList){
            if (sub.getZone() == zone){
                sub.update(alert);
            }
        }
    }
}
