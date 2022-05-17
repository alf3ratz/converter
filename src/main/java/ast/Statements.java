package ast;

import ast.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class Statements extends AstNode {
    private final List<Statement> statements;

    Statements() {
        this.statements = new ArrayList<>();
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
