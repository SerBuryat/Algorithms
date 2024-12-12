package ru.serburyat.leetcode.minstack;

class MinStack {

    public static class Node {
        // without getters/setters for coding speed
        public int val;
        public Node last;
        public Node lastMinValNode;

        public Node(int val, Node last) {
            this.val = val;
            this.last = last;
        }
    }

    private Node last;

    public void push(int val) {
        var add = new Node(val, this.last);
        if(this.last == null) {
            add.lastMinValNode = add;
        } else {
            var lastMin = this.last.lastMinValNode;
            add.lastMinValNode = val < lastMin.val ? add : lastMin;
        }
        this.last = add;
    }

    public void pop() {
        this.last = this.last.last;
    }

    public int top() {
        return this.last.val;
    }

    public int getMin() {
        return this.last.lastMinValNode.val;
    }
}
