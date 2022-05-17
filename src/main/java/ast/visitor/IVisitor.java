package ast.visitor;

import ast.ErrorStatement;
import ast.LoadStatement;
import ast.SaveStatement;
import ast.Statements;

public interface IVisitor {

    void visit(LoadStatement loadStatement);
    void visit(SaveStatement saveStatement);
    void visit(Statements statements);

    void visit(ErrorStatement errorStatement);
}

