package by.training.task07.service;

import java.util.ArrayList;
import java.util.Random;

public class MatrixService {
        public int[][] exerciseOne(int[][] a) throws MatrixException {
            if(a==null||a.length==0||a[0].length==0){
                throw new MatrixException();
            }
            int[][] res;
            ArrayList<Integer> numbersOfColumns = new ArrayList<Integer>();
            for(int i = 1; i<a.length; i+=2){
                if(a[0][i]>a[a[i].length-1][i]){
                    numbersOfColumns.add(i);
                }
            }
            //find the necessary columns
            res = new int[a[0].length][numbersOfColumns.size()];
            for(int i =0; i< res.length;i++){
                for(int j =0; j<res[0].length;j++){
                    res[i][j] = a[i][numbersOfColumns.get(j)];
                }
            }
            return res;
        }

        public int[][] exerciseTwo(int number) throws MatrixException {
            if(number<0){
                throw new MatrixException();
            }
                int[][] res = new int[number][number];
                for (int i = 0; i < res.length; i++) {
                    res[i][i] = (i + 1) * (i + 2);
                }
                return res;

        }

        public int[][] exerciseThree(int number) throws MatrixException {
            if(number<0) {
                throw new MatrixException();
            }
                int[][] res = new int[number][number];
                int counter =1;
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length;j++){
                        res[i][j] = counter++;
                    }
                }
                return res;

        }

    public int[][] exerciseFour(int[][] a) throws MatrixException {
        if(a==null||a.length==0||a[0].length==0){
            throw new MatrixException();
        }
        int max = findMax(a);
        return replaceOddNumbers(a,max);
    }

    public int findMax(int[][] a) throws MatrixException {
            if(a==null||a.length==0||a[0].length==0){
                throw new MatrixException();
            }
            int max = a[0][0];
            for(int i =0; i< a.length;i++){
                for(int j =0; j<a[0].length;j++){
                    if(a[i][j]>max){
                        max = a[i][j];
                    }
                }
            }
            return max;
    }

    public int[][] replaceOddNumbers(int[][] a, int number) throws MatrixException {
        if(a==null||a.length==0||a[0].length==0){
            throw new MatrixException();
        }
            for(int i = 0; i< a.length; i++){
                for (int j =0; j<a[0].length;j++){
                    if(a[i][j]%2!=0){
                        a[i][j] = number;
                    }
                }
            }
            return a;
    }

        public int[][] createMatrix(int a, int b){
            int[][] res = new int[a][b];
            Random random = new Random();
            for(int i =0; i<a;i++){
                for(int j =0; j<b; j++){
                    res[i][j] = random.nextInt(10);
                }
            }
            return res;
        }
}
