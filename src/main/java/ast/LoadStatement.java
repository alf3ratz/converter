package ast;

import ast.visitor.IVisitor;

public class LoadStatement extends Statement {
    protected LoadStatement() {
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
