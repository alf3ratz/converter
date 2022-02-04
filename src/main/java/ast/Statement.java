package ast;

public abstract class Statement extends AstNode {
    private String value;

    protected Statement() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
