class Solution {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        StringBuilder sb = new StringBuilder(num);
        int n1 = sb.length();
        int i = sb.length()-2;
        while(i>=0 && sb.charAt(i)>=sb.charAt(i+1)) i--;
        if(i == -1) return -1;
        int mini = i+1;
        for(int j = i+2; j<n1 ; j++){
            if(sb.charAt(j)>sb.charAt(i) && sb.charAt(j)<=sb.charAt(mini)) mini = j;
        }
        char temp = sb.charAt(i);
        sb.setCharAt(i,sb.charAt(mini));
        sb.setCharAt(mini,temp);
        StringBuilder sbstr = new StringBuilder(sb.substring(i+1,n1));
        sbstr.reverse();
        sb.replace(i+1,n1,sbstr.toString());
        long l = Long.parseLong(sb.toString());
        if(l>=Integer.MIN_VALUE && l<=Integer.MAX_VALUE) return (int)l;
        return -1;
    }
}