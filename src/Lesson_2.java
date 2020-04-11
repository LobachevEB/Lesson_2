import java.util.Arrays;

public class Lesson_2 {
    public static void main(String[] args){
        int[] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        swap01(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[8];
        fillArray(arr2,3);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyBy2(arr3);
        System.out.println(Arrays.toString(arr3));

        int[][] arr4 = new int[3][3];
        fillDiagonals(arr4);
        for (int i = 0; i < arr4.length; i++)
            System.out.println(Arrays.toString(arr4[i]));

        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, -2};
        int[] arr6 = {0,0};
        getMinMaxElem(arr5,arr6);
        System.out.println(Arrays.toString(arr6));

        int[] arr7 = {2, 2, 2, 1, 2, 2, 10, 1};
        boolean balanced = isBalancedArray(arr7);
        System.out.printf("Is arr7 balanced? %s\n",balanced);

        int[] arr8 = {0, 3, 6, 9, 12, 15, 18, 21};
        shiftArray(arr8,-11);
        System.out.println(Arrays.toString(arr8));

    }

    public static void swap01(int[] swapArray){
        for(int i = 0;i < swapArray.length;i++){
            swapArray[i] = ((swapArray[i] == 0) ? 1 : 0);
        }
    }

    public static void fillArray(int[] arrayToFill, int step){
        int init = 0;
        for (int i = 0;i < arrayToFill.length;i++){
            arrayToFill[i] = init;
            init += step;
        }
    }

    public static void multiplyBy2(int[] arrayMult){
        for (int i = 0; i < arrayMult.length; i++){
            arrayMult[i] = ((arrayMult[i] < 6)? arrayMult[i] * 2: arrayMult[i]);
        }
        return;
    }

    public static void fillDiagonals(int[][] matrix){
        int w = matrix.length;
        int h = matrix[0].length;
        if(w != h || w == 0)
            return;;
        int magicIndex = w - 1; //Для обратной диагонали сумма позиций x и y постоянна
        for(int x = 0; x < w; x++){
            for(int y = 0; y < h; y++){
                if(x == y || x + y == magicIndex)
                    matrix[x][y] = 1;
            }
        }
    }

    public static void getMinMaxElem(int[] testArray,int[] result){
        if (result.length < 2)
            return;
        if (testArray.length < 2)
            return;
        result[0] = testArray[0];
        result[1] = testArray[1];
        for (int i = 0;i < testArray.length; i++){
            if (testArray[i] > result[0])
                result[0] = testArray[i];
            if(testArray[i] < result[1])
                result[1] = testArray[i];
        }

    }

    public static boolean isBalancedArray(int[] testArray){
        if(testArray.length < 2)
            return false;
        int leftSum = testArray[0];
        int rightSum = 0;
        for (int i = testArray.length - 1; i > 0; i--)
            rightSum += testArray[i];
        if(leftSum == rightSum)
            return true;

        for (int i = 1; i < testArray.length; i++){
            rightSum -= testArray[i];
            leftSum += testArray[i];
            if(leftSum == rightSum)
                return true;
        }
        return false;
    }

    public static void shiftArray(int[] shiftArray,int n){
        if(shiftArray.length < 2)
            return;
        int x = Math.abs(n);
        //Если сдвиг большой, проверяем, не кратен ли он длине массива
        //Кратный сдвиг равносилен отсутствию сдвига
        if(x > shiftArray.length)
            x = x % shiftArray.length;
        if(x == 0)
            return;
        for(int i = 0;i < x; i++){
            if(n > 0){
                int edgeElem = shiftArray[shiftArray.length - 1];
                for(int j = shiftArray.length - 1; j > 0; j--)
                    shiftArray[j] = shiftArray[j - 1];
                shiftArray[0] = edgeElem;
            }
            else {
                int edgeElem = shiftArray[0];
                for(int j = 0; j < shiftArray.length - 1; j++)
                    shiftArray[j] = shiftArray[j + 1];
                shiftArray[shiftArray.length - 1] = edgeElem;
            }
        }
    }
}
