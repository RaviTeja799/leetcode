class Solution {
    public boolean isAnagram(String s, String t) {
        boolean ans = true;
        int str1 [] = new int[26];
        int str2 [] = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            int j = (int)s.charAt(i)-'a';
            str1[j]+=1;
        }
        for(int i = 0 ; i < t.length() ; i++){
            int j = (int)t.charAt(i)-'a';
            str2[j]+=1;
        }
        for(int i = 0 ; i < 26 ; i++){
            if(str1[i]!=str2[i]) ans = false;
        }
        return ans;

    }
}