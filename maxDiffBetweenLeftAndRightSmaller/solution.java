class solution {
    int findMaxDiff(int a[], int n) {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];
        Arrays.fill(leftSmall, 0);
        Arrays.fill(rightSmall, 0);

        findSmaller(a, n, leftSmall);
        reverse(a);
        findSmaller(a, n, rightSmall);

        //Instead of reversing it we can first start from index = 0 and add smaller elements to our left array
        // and then start iterating from end of a and start adding smaller elements to our right
        //More code duplication
        /** 
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
                // leftSmall[i]=a[i];
            }
            if (!stack.isEmpty())
                rightSmall[i] = stack.peek();

            stack.push(a[i]);
        }

        for (int j = n - 1; j >= 0; j--) {
            while (!stack.isEmpty() && stack.peek() >= a[j]) {
                stack.pop();
                // rightSmall[j]=a[j];
            }
            if (!stack.isEmpty())
                rightSmall[j] = stack.peek();

            stack.push(a[j]);
        }
        */

        int result = -1;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, Math.abs(leftSmall[i] - rightSmall[n - i - 1]));
        }

        return result;

    }

    static void findSmaller(int[] a, int n, int[] smaller) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) {
                stack.pop();
                // leftSmall[i]=a[i];
            }
            if (!stack.isEmpty())
                smaller[i] = stack.peek();

            stack.push(a[i]);
        }

    }

    static void reverse(int a[]) {
        int i, n = a.length;
        int temp;
        for (i = 0; i < n / 2; i++) {
            temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }
}