package ast;

import ast.visitor.IVisitor;

public class SaveStatement extends  Statement {
    protected SaveStatement() {
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
