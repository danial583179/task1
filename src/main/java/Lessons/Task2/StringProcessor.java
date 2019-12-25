package Lessons.Task2;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    public static String mulStr(String string,int n){
        if(string == null){
            throw new RuntimeException("String can't be null");
        }
        if(n < 0){
            throw new RuntimeException("Can't multiply string negative times");
        }
        if(n == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(string);
        for(int i = 0;i < n - 1;++i){
            sb.append(string);
        }
        return sb.toString();
    }

    public static long countOfSubstring(String string1,String string2) {
        long counter = 0;
        Pattern pattern = Pattern.compile("\\Q" + string2 + "\\E");
        Matcher matcher = pattern.matcher(string1);
        int i = 0;
        while(matcher.find(i)){
            counter++;
            i = matcher.start() + 1;
        }
        return counter;
        /*for(int i = 0;i + string2.length() <= string1.length();++i){
            if(string1.substring(i,i + string2.length()).contains(string2)){
                counter++;
            }
        }
        return counter;*/
    }

    public static String charToNumberReplace(String string) throws Exception {
       if(string == null){
           throw new Exception("String can't be null");
       }
       StringBuilder sb = new StringBuilder(string);
       for(int i = 0;i < sb.length();++i){
           switch (sb.charAt(i)){
               case '1': {
                   sb.deleteCharAt(i);
                   sb.insert(i,"one");
                   break;
               }
               case '2': {
                   sb.deleteCharAt(i);
                   sb.insert(i,"two");
                   break;
               }
               case '3': {
                   sb.deleteCharAt(i);
                   sb.insert(i,"three");
                   break;
               }
           }
       }
       return sb.toString();
    }
    public static void evenCharRemove(StringBuilder sb) throws Exception {
        if(sb == null){
            throw new Exception("String builder can't be null");
        }
        for(int i = 1;i < sb.length();i++){
            sb.deleteCharAt(i);
        }
    }

    public static StringBuilder swapWords(StringBuilder sb)throws Exception{
        if(sb == null){
            throw new Exception("String builder can't be null");
        }
        int indexStart = 0,indexEnd = 0;
        while(sb.charAt(indexStart) == ' '){
            indexStart++;
            if(indexStart == sb.length()){
                return sb;
            }
        }
        int indexStartStops = indexStart;
        while(sb.charAt(indexStartStops) != ' '){
            indexStartStops++;
            if(indexStartStops == sb.length()){
                return sb;
            }
        }
        sb.reverse();
        while (sb.charAt(indexEnd) == ' '){
            indexEnd++;
        }
        int indexEndStops = indexEnd;
        while (sb.charAt(indexEndStops) != ' '){
            indexEndStops++;
        }
        sb.reverse();
        //taking value of words
        String word1 = sb.substring(indexStart, indexStartStops);
        String word2 = sb.substring(sb.length() - indexEndStops, sb.length() - indexEnd);
        //word2 inserts to word1's place
        sb.delete(indexStart, indexStartStops);
        sb.insert(indexStart, word2);
        //word1 inserts to word2's place
        sb.delete(sb.length() - indexEndStops, sb.length() - indexEnd);
        sb.insert(sb.length() - indexEnd, word1);

        return sb;
    }
    public static String hexToDec(String string){
        return Pattern.compile("0x[\\da-fA-F]{1,8}").matcher(string).replaceAll(matchResult -> Integer.toString(Integer.decode(matchResult.group())));
    }
}
