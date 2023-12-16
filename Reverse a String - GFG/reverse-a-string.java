//{ Driver Code Starts
// Initial template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();

            System.out.println(ob.revStr(S));
        }
    }
}
// } Driver Code Ends


class Solution {
    static String revStr(String S) {
        char[] arr = S.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        reverse(i, j, arr);

        // Convert char array back to string
        String rev = new String(arr);
        return rev;
    }

    public static void reverse(int i, int j, char[] arr) {
        if (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            reverse(i + 1, j - 1, arr);
        }
    }
}