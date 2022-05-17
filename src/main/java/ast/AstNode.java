package ast;

import ast.visitor.IVisitor;

public abstract class AstNode {
    private int start;
    private int end;

    protected AstNode() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public abstract void accept(IVisitor visitor);
}
