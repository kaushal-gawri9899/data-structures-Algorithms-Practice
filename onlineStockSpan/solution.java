/**
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 */
class StockSpanner {

    Stack<int[]> myStack;
    public StockSpanner() {
        myStack =  new Stack<>();
    }
    
    public int next(int price) {
        int toReturn=1;
        
        //Compare the price for the element at top of stack to the user input price
        //If the price by user is more, remove the top of the element on the stack and increase the value of toReturn by 1;
        //Make sure that question says <=price
        while(!myStack.isEmpty() && myStack.peek()[0]<=price)
        {
            toReturn+=myStack.pop()[1];
        }
        myStack.push(new int[]{price,toReturn});
        
        return toReturn;
        
    }
    
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */