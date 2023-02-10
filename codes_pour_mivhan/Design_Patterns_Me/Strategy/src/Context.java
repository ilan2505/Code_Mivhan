public class Context {
    protected Strategy strategy;
    public void appliquerStrategy(){
        strategy.operationStrategy();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
