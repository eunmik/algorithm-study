package com.eunmi.algorithm.dp;

public class UglyNumbers {
    public static void main(String[] args){
        UglyNumbers u = new UglyNumbers();
        double begin ,end;
        begin = System.currentTimeMillis();
        int n = 10;
        System.out.println(n+"th ugly number is"+u.getNthUglyNo_method2(n));

        end = System.currentTimeMillis();
        double time_spent = (end - begin);
        System.out.println("Time Taken " + time_spent);

    }


    //ugly 숫자의 카운트가 n보다 작을 때 까지 for문을 돌린다.
    //숫자가 ugly인지 확인하기 위해 2,3,5로 나눈다, 만약 숫자가 1이 되면 ugly 숫자이다.
    //모든 숫자를 확인 하기 때문에 효율성이 좋지 않다. O(1)
    /*This function divides a by greatest divisible power of b*/
    static int maxDivide(int a, int b)
    {
        while (a % b == 0)
            a = a / b;
        return a;
    }

    /* Function to check if a number is ugly or not */
    static int isUgly(int no)
    {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);

        return (no == 1) ? 1 : 0;
    }

    /* Function to get the nth ugly number*/
    static int getNthUglyNo_method1(int n)
    {
        int i = 1;

        // ugly number count
        int count = 1;

        // check for all integers
        // until count becomes n
        while (n > count) {
            i++;
            if (isUgly(i) == 1)
                count++;
        }
        return i;
    }

    /* DP 사용, 시간 복잡도 : O(n)
    모든 숫자는 2,3,5로 나누기때문에 3그룹으로 나누어서 볼 수 있다.
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
    여기서 우리는 각각 그룹에서 ugly number를 얻기 위해 merge sort를 사용한다.
    가장 작은것을 선택하고 다음 스텝으로 넘어간다.

     */
    // Function to get the nth ugly number
    int getNthUglyNo_method2(int n)
    {
        // To store ugly numbers
        int ugly[] = new int[n]; // Declare an array for ugly numbers
        int i2 = 0, i3 = 0, i5 = 0; //Initialize three array index variables i2, i3, i5 to point to 1st element of the ugly array
        int next_multiple_of_2 = 2; //Initialize 3 choices for the next ugly no
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1; //initialize first ugly no

        for (int i = 1; i < n; i++) //Now go in a loop to fill all ugly numbers till n
        {
            next_ugly_no
                    = Math.min(next_multiple_of_2,
                    Math.min(next_multiple_of_3,
                            next_multiple_of_5));

            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2)
            {
                i2 = i2 + 1;
                next_multiple_of_2 = ugly[i2] * 2;
            }
            if (next_ugly_no == next_multiple_of_3)
            {
                i3 = i3 + 1;
                next_multiple_of_3 = ugly[i3] * 3;
            }
            if (next_ugly_no == next_multiple_of_5)
            {
                i5 = i5 + 1;
                next_multiple_of_5 = ugly[i5] * 5;
            }
        }

        // End of for loop (i=1; i<n; i++)
        return next_ugly_no;
    }


}
