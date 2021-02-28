/**
 * Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * FreqStack has two functions:
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 */
class FreqStack {
    HashMap<Integer, Integer> frequency;
    HashMap<Integer, Stack<Integer>> elements;
    int maximumFreq;
    
    public FreqStack() {
        this.frequency = new HashMap<>();
        this.elements = new HashMap<>();
        this.maximumFreq=0;
    }
    
    public void push(int x) {
        
        //Get the frequency of the given element and increment by 1
        //If element not there add do 0+1
        int freq = frequency.getOrDefault(x,0)+1;
        //Add element to our freqeuncy map
        frequency.put(x,freq);
        
        //Update the maximum frequency on every push
        maximumFreq = Math.max(maximumFreq, freq);
        
        //If the current frequency is not already there in our elements map
        if(!elements.containsKey(freq))
        {
            //Add a new frequency and a corresponding stack for it
            elements.put(freq, new Stack<Integer>());
        }
        
        //Add the element int the stack for the current freq in our elements map
        elements.get(freq).add(x);
    }
    
    public int pop() {
        
        //Remove the elements with highest frequency
        int x = elements.get(maximumFreq).pop();
        //Update frequency of that element
        frequency.put(x, maximumFreq-1);
        
        //Check if the stack for our maximum frequency value became empty, if so update the maximumFrequency by reducing its value
        if(elements.get(maximumFreq).isEmpty())
            maximumFreq--;
        
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */