class Pair{
    TreeNode x;int hd;
    Pair(TreeNode a,int b){x=a;hd=b;}
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null)return res;
        ArrayDeque<Pair> q=new ArrayDeque<>();
        HashMap<Integer,List<List<Integer>>> hm=new HashMap<>();
        q.add(new Pair(root,0));int level=0,m=0;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                Pair t=q.pollFirst();m=Math.min(m,t.hd);
                List<Integer> a=new ArrayList<Integer>();
                a.add(level);a.add(t.x.val);
                List<List<Integer>> x=hm.getOrDefault(t.hd,new ArrayList<List<Integer>>());
                x.add(a);
                hm.put(t.hd,x);
                if(t.x.left!=null)q.add(new Pair(t.x.left,t.hd-1));
                if(t.x.right!=null)q.add(new Pair(t.x.right,t.hd+1));
            }
            level++;
        }
        while(hm.containsKey(m)){
            List<List<Integer>> t=hm.get(m);
            Collections.sort(t,(a,b)->{
                if(a.get(0)>b.get(0))return 1;
                else if(a.get(0)<b.get(0))return -1;
                else return a.get(1)-b.get(1);
            });
            
            List<Integer> x=new ArrayList<Integer>();
            for(List<Integer> c:t){x.add(c.get(1));}
            res.add(x);m++;
         }
         return res;
    }
}