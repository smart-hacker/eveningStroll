package com.company;

import java.util.*;

public class Graphs3
{
    static int num;
    static int[] xDif = {1, 0};
    static int[] yDif = {0, 1};
    static int x1;
    static int y1;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int rows = Integer.parseInt(str[0]);
        int cols = Integer.parseInt(str[1]);
        int[][] arr = new int[rows][cols];
        int theInt = 0;
        for (int i = 0; i < rows; i++)
        {
            String[] cur = sc.nextLine().split(" ");
            int[] curInt = new int[cols];
            for (int j = 0; j < cols; j++)
            {
                if (cur[j].equals("."))
                {
                    cur[j] = "1";
                }
                else if (cur[j].equals("R"))
                {
                    cur[j] = "0";
                }
                else
                {
                    cur[j] = "2";
                    if(theInt == 0)
                    {
                        x1 = i;
                        // System.out.println(x1);
                        y1 = j;
                        // System.out.println(y1);
                        theInt++;
                    }
                }
                curInt[j] = Integer.parseInt(cur[j]);
            }
            arr[i] = curInt;
        }
        /*
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
         */
        // System.out.println(x1 + " " + y1);
        graph(x1, y1, arr);
        System.out.println(num);
    }

    public static void graph(int x, int y, int[][] arr)
    {
        for(int i = 0; i < 2; i++)
        {
            int xx = x + xDif[i];
            int yy = y + yDif[i];
            if(xx == arr.length || yy == arr[0].length)
            {
                continue;
            }
            else if(arr[xx][yy] == 0)
            {
                continue;
            }
            else if(arr[xx][yy] == 2)
            {
                num++;
                return;
            }
            else
            {
                graph(xx, yy, arr);
            }
        }
    }
}

// Each Node Going From Top Left To Bottom Right Is A Parent, Going Down The Tree In Graph To Each Child
// Compute Total Number Of Possibilities