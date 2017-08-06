package me.inventosachingupta.aid;

public class Convert2Int {
    public static int c2i(String s){
        int res = 1;
        String str[] = s.split("X");
        res = Integer.parseInt(str[0]) * Integer.parseInt(str[1]);
        return res;
    }
}
