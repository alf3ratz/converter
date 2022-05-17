package ast;

import ast.visitor.IVisitor;

public class ErrorStatement extends Statement {
    protected ErrorStatement() {
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
