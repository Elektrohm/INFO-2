import java.util.Comparator;
import java.util.List;
import java.awt.Color;

public class Sorter {


    /*
     * Should sort the list and order the Flower by color, in this specific order : red, blue, green
     */

    public static void sortFlowerByColor(List<Flower> list){
        list.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if (o1.getPetalColor().getRed()==o2.getPetalColor().getRed()){
                    if (o1.getPetalColor().getBlue()==o2.getPetalColor().getBlue()){
                        return o1.getPetalColor().getGreen()-o2.getPetalColor().getGreen();
                    }
                    return o1.getPetalColor().getBlue() - o2.getPetalColor().getBlue();
                }
                return o1.getPetalColor().getRed()-o2.getPetalColor().getRed();
            }
        });
    }
    /*
     * Should sort the Plant by name only
     */
    public static void sortPlantByName(List<Plant> list){
        list.sort(Plant::compareTo);
    }

    /*
     * Should sort the list and order the Tree by height
     */
    public static void sortTreeByHeight(List<Tree> list){
        list.sort(new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.getHeight()-o2.getHeight();
            }
        });
    }
}
