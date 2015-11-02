class MinStack {

    Stack<Integer> st=new Stack<Integer>();
    Stack<Integer> min_st=new Stack<Integer>();
    public void push(int x) {
       //用两个栈来存储信息，一个用来存储所有信息，另一个用来存储最小值
       //先将X入栈，如果存储最小值的栈为空或者X小于他最上面的值，则X同时入存储最小值的栈
         st.push(x);
        if(min_st.empty()||x<=min_st.peek())
            min_st.push(x);
     /*   else if(x==min_st.peek()){
            min_st.push(x);
            st.push(x);
        }
        else st.push(x);*/
    }
//先将在st中的值出栈，该值与min_st中的值相等，则min_st中的值也出栈
    public void pop() {
         int top=st.peek();
           st.pop();
        if(top==min_st.peek())
      { min_st.pop();
       
        }
    
}
     int top() { 
         //取出min_st最上面的值并返回
        int a=0;
       // if(st!=null)
         a=st.peek();
       return a;
    }

     int getMin() {
         //取出st最上面的值并返回
        int b=0;
       // if(min_st!=null)
        b=min_st.peek();
       return b;
    }
    
}
