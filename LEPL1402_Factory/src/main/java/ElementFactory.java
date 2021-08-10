public class ElementFactory extends Factory {
    private static final ElementFactory instance = new ElementFactory();

    private ElementFactory(){};

    public static ElementFactory getInstance() {
        return instance;
    }


    public LevelComponent getElement(char c) {
        String element = Character.toString(c);
        if (element.equals("D")){
            return new Door();
        }
        if (element.equals("-")){
            return new Floor();
        }
        if (element.equals("#")){
            return new Wall();
        }
        if (element.equals("K")){
            return new Key();
        }
        throw new IllegalArgumentException();
    }

}
