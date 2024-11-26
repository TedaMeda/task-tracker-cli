package util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {
    public static List<String> parseString(String s) {
        List<String> res = new ArrayList<>();
        int size = s.length();
        int prevInd = -1;
        int ind = 0;
        while (ind < size) {
            if(s.charAt(ind)=='"'){
                res.add(s.substring(ind+1,size-1));
                return res;
            }
            else if(s.charAt(ind) == ' '){
                res.add(s.substring(++prevInd, ind));
                prevInd = ind;
            }
            ind++;
        }
        res.add(s.substring(++prevInd, size));
        return res;
    }

    public static String toLower(String s){
        return s.toLowerCase();
    }
}
