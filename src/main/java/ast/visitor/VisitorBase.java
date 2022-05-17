package ast.visitor;

import ast.ErrorStatement;
import ast.LoadStatement;
import ast.SaveStatement;
import ast.Statements;

abstract class VisitorBase implements IVisitor {
    @Override
    public void visit(Statements statements) {
        beforeVisit(statements);
        for (var statement : statements.getStatements()) {
            statement.accept(this);
        }
        afterVisit(statements);
    }

    @Override
    public void visit(LoadStatement loadStatement) {
        beforeVisit(loadStatement);
        afterVisit(loadStatement);
    }

    @Override
    public void visit(SaveStatement saveStatement) {
        beforeVisit(saveStatement);
        afterVisit(saveStatement);
    }

    @Override
    public void visit(ErrorStatement errorStatement) {
        beforeVisit(errorStatement);
        afterVisit(errorStatement);
    }

    public abstract void afterVisit(ErrorStatement errorStatement);
    public abstract void beforeVisit(ErrorStatement errorStatement);

    public abstract void beforeVisit(Statements statements);
    public abstract void afterVisit(Statements statements);

    public abstract void beforeVisit(LoadStatement statements);
    public abstract void afterVisit(LoadStatement statements);

    public abstract void beforeVisit(SaveStatement statements);
    public abstract void afterVisit(SaveStatement statements);
}
