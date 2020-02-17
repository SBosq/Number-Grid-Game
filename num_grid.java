import java.util.Scanner;
import java.util.Arrays;
/**
 * Write a description of class num_grid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class num_grid
{
    int [][] arr;
    Scanner wasd = new Scanner (System.in);
    int zeroRowPosition, zeroColumnPosition;
    public num_grid()
    {
        arr = new int [4][4];
        for (int i=1;i<16;i++)
        {
            int row,column;
            do{
                row =(int)(Math.random()*4);
                column =(int)(Math.random()*4);
            }while (arr[row][column]!=0);
            arr[row][column]=i;
        }

        for (int j=0;j<arr.length;j++)
        {
            for (int k=0;k<arr[j].length;k++)
            {
                if (arr[j][k]==0)
                {
                    zeroRowPosition = j;
                    zeroColumnPosition = k;
                    break;
                }
            }
        }
    }

    public void print()
    {
        for (int j=0;j<arr.length;j++)
        {
            for (int k=0;k<arr[j].length;k++)
            {
                if (arr[j][k]<10)
                {
                    System.out.print(" " + arr[j][k] + " ");
                }
                else
                {
                    System.out.print(arr[j][k] + " ");
                }
            }
            System.out.println();
        }
    }

    public char moveRequest()
    {
        return (wasd.next()).charAt(0);
    }

    public void move()
    {
        char capture=moveRequest();
        int temp;
        switch (capture)
        {
            case 'a':
            case 'A': if ((zeroColumnPosition+1)<(arr.length))
            {
                temp=arr[zeroRowPosition][zeroColumnPosition];
                arr[zeroRowPosition][zeroColumnPosition]=arr[zeroRowPosition][zeroColumnPosition+1];
                arr[zeroRowPosition][zeroColumnPosition+1]=temp;
                zeroColumnPosition++;
            }
            break;
            case 'd':
            case 'D':if ((zeroColumnPosition-1)>=0)
            {
                temp=arr[zeroRowPosition][zeroColumnPosition];
                arr[zeroRowPosition][zeroColumnPosition]=arr[zeroRowPosition][zeroColumnPosition-1];
                arr[zeroRowPosition][zeroColumnPosition-1]=temp;
                zeroColumnPosition--;
            }
            break;
            case 'w':
            case 'W':if ((zeroRowPosition+1)<(arr.length))
            {
                temp=arr[zeroRowPosition][zeroColumnPosition];
                arr[zeroRowPosition][zeroColumnPosition]=arr[zeroRowPosition+1][zeroColumnPosition];
                arr[zeroRowPosition+1][zeroColumnPosition]=temp;
                zeroRowPosition++;
            }
            break;
            case 's':
            case 'S':if ((zeroRowPosition-1)>=0)
            {
                temp=arr[zeroRowPosition][zeroColumnPosition];
                arr[zeroRowPosition][zeroColumnPosition]=arr[zeroRowPosition-1][zeroColumnPosition];
                arr[zeroRowPosition-1][zeroColumnPosition]=temp;
                zeroRowPosition--;
            }
            break;
        }
    }

    public boolean win()
    {
        int[][]arr1=new int[4][4]; //test array
        //int[][]arr2=new int[4][4]; //random created array

        arr1[0][0]=1;
        arr1[0][1]=2;
        arr1[0][2]=3;
        arr1[0][3]=4;

        arr1[1][0]=5;
        arr1[1][1]=6;
        arr1[1][2]=7;
        arr1[1][3]=8;

        arr1[2][0]=9;
        arr1[2][1]=10;
        arr1[2][2]=11;
        arr1[2][3]=12;

        arr1[3][0]=13;
        arr1[3][1]=14;
        arr1[3][2]=15;
        arr1[3][3]=0;

        if(Arrays.deepEquals(arr,arr1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main ()
    {
        System.out.print('\u000c');
        num_grid game = new num_grid();
        game.print();
        do{
            game.move();
            System.out.print('\u000c');
            game.print();
        }while (!game.win());
        System.out.println("Congrats you've won!");
    }
}