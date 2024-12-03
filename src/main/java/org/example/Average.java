package org.example;

import java.util.Scanner;

public class Average {

    Scanner sc = new Scanner(System.in);

    int[] data = new int[5];
    double mean;

    Average(){

        for (int i=0; i<5; i++){
            System.out.print("Please Enter Score Number "+(i+1)+": ");
            int answer = sc.nextInt();
            data[i] = answer;
        }

        selectionSort();
        calculateMean();

    }

    public void calculateMean(){
        int total = 0;
        for (int i=0; i<5; i++){
            total += data[i];
        }
        mean = ((double)(total)/5);
    }

    public String toString(){
        String result = "";

        for (int i=0; i<5; i++){
            result += data[i] + " ";
        }

        return result;
    }

    public void selectionSort(){
        for (int j=0; j<5; j++) {
            int last = data[0];
            int store = 0;
            for (int i = 1; i < 5; i++) {
                System.out.printf("(%s, %s)", data[i], last);
                if (data[i] < last) {
                    System.out.print("DONE");
                    data[i - 1] = data[i];
                    data[i] = last;
                }
            }
            System.out.println(this.toString());
        }
    }
}