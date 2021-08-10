import java.util.Arrays;

public class MyBuilder {

    public static void main(String args[]) {
        //test première fonction
        int[][] test = buildFrom("1 2 3 \n 4 5 \n 245");
        System.out.println(Arrays.deepToString(test));
        //test deuxième fonction
        int test2 = sum(test);
        System.out.println(test2);
        //test troisième fonction
        int[][] test3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] resultOftest3 = transpose(test3);
        for (int i = 0; i < resultOftest3.length; i++) {
            for (int j = 0; j < resultOftest3[0].length; j++) {
                System.out.print(resultOftest3[i][j] + " ");
            }
            System.out.println();//new line
        }
        //test quatrième fonction
        int[][] test4 = {{1, 5}, {2, 3}, {1, 7}};
        int[][] test4Mult = {{1, 2, 3, 7}, {5, 2, 8, 1}};
        int[][] produit = product(test4, test4Mult);
        for (int i = 0; i < produit.length; i++) {
            for (int j = 0; j < produit[0].length; j++) {
                System.out.print(produit[i][j] + " ");
            }
            System.out.println();//new line

        }

    }

    public static int[][] buildFrom(String s){
        String[] splittedString = s.split("\n");
        int array[][] = new int[splittedString.length][];
        int index = 0;
        for (String str: splittedString){
            String[] newString = str.trim().split("\\s");
            int size = newString.length;
            int [] arr = new int [size];
            for(int i=0; i<size; i++) {
                arr[i] = Integer.parseInt(newString[i]);
            }
            array[index] = arr;
            index ++;
        }
        return array;
    }

    public static int sum(int[][] array){
        int somme = 0;
        for (int[] arr : array){
            for (int i : arr){
                somme += i;
            }
        }
        return somme;
    }

    public static int[][] transpose(int[][] matrix){
        int[][] transpo = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                transpo[i][j]=matrix[j][i];
            }
        }
        return transpo;
    }

    public static int[][] product(int[][] matrix1, int[][] matrix2){
        int m = matrix1.length;
        int n = matrix2[0].length;
        int[][] matrix3 = new int[m][n];
        for (int row = 0 ; row<m ; row++){
            for (int col = 0 ; col<matrix3[row].length ; col++){
                int val = 0;
                for (int i = 0; i < matrix2.length; i++) {
                    val += matrix1[row][i] * matrix2[i][col];
                }
                matrix3[row][col] = val;
            }
        }
        return matrix3;
    }
}
