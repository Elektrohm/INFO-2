import java.util.Arrays;

public class Valley {
    /*
     * Example:
     * [1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1]
     * Should return
     * [5, 3]
     */
    public static void main(String[] args){
        int[] array = {1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1};
        int[] test = valley(array);
        System.out.println("solution au problème : " + Arrays.toString(test));
    }

    public static int[] valley(int[] array){
        int[] landscapes = new int[array.length];
        int valley = 0;
        int mountain = 0;
        int index = 0;
        int sum = array[0];
        for (int i = 1 ; i<array.length ; i++){
            if (sum*array[i]<0){
                if (sum > 0 && index>0){valley = checkForValley(landscapes[index-1], sum, valley); }
                if (sum < 0 && index>0){mountain = checkForMountain(landscapes[index-1], sum, mountain); }
                landscapes[index] = sum;
                sum = 0;
                index++;
            }
            sum += array[i];
        }
        landscapes[index]=sum;
        if (sum > 0){ valley = checkForValley(landscapes[index-1],sum, valley);}
        else{ mountain = checkForMountain(landscapes[index-1],sum, mountain);}
        System.out.println("landscapes vaut : " + Arrays.toString(landscapes));
        return new int[]{valley, mountain};
    }

    /**
     *
     * @param before chiffre précédent à curr dans le tableau landscapes
     * @param curr est équivalent à sum
     * @param mountain valeur retenu de la montagne
     * @return la plus grande montagne
     */
    private static int checkForMountain(int before, int curr, int mountain) {
        if (before + curr > 0 & curr*(-1)>mountain){mountain = curr;}
        if (before + curr < 0 & before>mountain){mountain=before;}
        if (before + curr == 0 & before>mountain){mountain=before;}
        return mountain;
    }

    /**
     *
     * @param before chiffre précédent à curr dans le tableau landscapes
     * @param curr est équivalent à sum
     * @param valley valeur retenu de la vallée
     * @return la plus grande vallée
     */
    public static int checkForValley(int before, int curr, int valley){
        if (before + curr > 0 & before*(-1)>valley){ valley = before*(-1); }
        if (before + curr < 0 & curr>valley){valley=curr;}
        if (before + curr == 0 & curr>valley){valley=curr;}
        return valley;
    }

}



