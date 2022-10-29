package stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    /*
    using stack
    space complexity o(n*m) n*m is total dimension
    time complexity o(n*m)
     */
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        addTostack(nestedList);
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            List<NestedInteger> nest = stack.pop().getList();
            for(int i=nest.size()-1; i>=0; i--)
                stack.push(nest.get(i));
        }
        return !stack.isEmpty();
    }

    private void addTostack(List<NestedInteger> nestedList){
        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }
}

/**
 * Your stack.NestedIterator object will be instantiated and called as such:
 * stack.NestedIterator i = new stack.NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */