//package ast.visitor;
//
//class OurAnalyzer extends VisitorBase {
//    private List<ErrorHighlighter> highlighters;
//    private List<LoadStatement> loadStatements = new ArrayList<>();
//
//    public OurAnalyzer(List<ErrorHighlighter> highlighters) {
//
//        this.highlighters = highlighters;
//    }
//
//    @Override
//    public void afterVisit(ErrorStatement errorStatement) {
//        highlighters.add(new ErrorHighlighter(errorStatement.getStart(), errorStatement.getEnd()));
//    }
//
//    @Override
//    public void beforeVisit(ErrorStatement errorStatement) {
//
//    }
//
//    @Override
//    public void beforeVisit(Statements statements) {
//
//    }
//
//    @Override
//    public void afterVisit(Statements statements) {
//        for (var loadStatement : loadStatements) {
//            highlighters.add(new ErrorHighlighter(loadStatement.getStart(), loadStatement.getEnd()));}
//
//    }
//
//    @Override
//    public void beforeVisit(LoadStatement statement) {
//        loadStatements.add(statement);
//    }
//
//    @Override
//    public void afterVisit(LoadStatement statements) {
//
//    }
//
//    @Override
//    public void beforeVisit(SaveStatement statements) {
//
//    }
//
//    @Override
//    public void afterVisit(SaveStatement saveStatement) {
//        var loadStatement = loadStatements.stream().filter(s -> s.getValue().equals(saveStatement.getValue())).findFirst();
//        if (loadStatement.isPresent()) {
//            loadStatements.remove(loadStatement.get());
//        }
//        else
//        {
//            highlighters.add(new ErrorHighlighter(saveStatement.getStart(), saveStatement.getEnd()));
//        }
//    }
//}