
public class Level extends AbstractLevel {

    public String toString() {
        StringBuilder toString = new StringBuilder();
        LevelComponent[][] compo = getComponents();
        for (int i = 0; i< getSize(); i++){
            for (int index = 0; index < getSize(); index++){
                toString.append(compo[i][index].draw());
            }
            toString.append("\n");
        }
        return toString.toString();
    }


    public LevelComponent[][] getComponents() {
        return components;
    }

    int getSize() {
        return components.length;
    }

    public Level(String input){

        //détacher les étages entre eux
        String[] splitInput = input.split("\n");

        //créé la matrice
        size = splitInput.length;
        components = new LevelComponent[size][size];

        //index de la matrice
        int i = 0;
        LevelComponent[] stage;

        //créé un étage
        for (String part : splitInput) {
            stage = new LevelComponent[size];
            //rempli l'étage
            for (int index = 0; index < part.length(); index++) {
                stage[index] = getElement(part.charAt(index));
            }
            //défini l'étage dans la matrice
            components[i] = stage;
            i++;
        }
    }


    public LevelComponent getElement(char  c){
        ElementFactory instance = ElementFactory.getInstance();
        return instance.getElement(c);
    }

    public static void main(String args[]){
        Level thisLevel = new Level("#-\n-#");
        System.out.println(thisLevel);
    }

}