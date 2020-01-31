public class SubSet {
    
    public static ArrayList<ArrayList<Integer>> res;
    
    public static void choose(ArrayList<Integer> A, ArrayList<Integer> list, int index) {
        for(int i=index; i<A.size(); i++) {
            list.add(A.get(i));
            res.add((ArrayList<Integer>) list.clone());
            choose(A, list, i + 1);
            while(i < A.size() - 1 && A.get(i) == A.get(i+1))
                i++;
            list.remove(list.size() - 1);
        }
    }
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        Collections.sort(A);
        
        choose(A, new ArrayList<Integer>(), 0);
        
        return res;
    }
}
