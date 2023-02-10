package DesignPatterns.Strategy;
//from  http://en.wikipedia.org/wiki/Strategy_pattern
class StrategyExample {
 
    public static void main(String[] args) {
 
        Context context;
        Strategy strategy;
        // Three contexts following different strategies
        strategy = new ConcreteStrategyAdd();
        context = new Context(strategy);
        System.out.println("resultA = "+context.executeStrategy(3,4));
 
        strategy = new ConcreteStrategySubtract();
        context = new Context(strategy);
        System.out.println("resultB = "+context.executeStrategy(3,4));
 
        strategy = new ConcreteStrategyMultiply();
        context = new Context(strategy);
        System.out.println("resultC = "+context.executeStrategy(3,4));
    }
}
 
// The classes that implement a concrete strategy should implement this
// The context class uses this to call the concrete strategy
interface Strategy {
     int execute(int a, int b);
}
// Implements the algorithm using the strategy interface
class ConcreteStrategyAdd implements Strategy {
 
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyAdd's execute()");
        return a + b;  // Do an addition with a and b
    }
}
//Implements the algorithm using the strategy interface
class ConcreteStrategySubtract implements Strategy {
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategySubtract's execute()");
        return a - b;  // Do a subtraction with a and b
    }
}
//Implements the algorithm using the strategy interface 
class ConcreteStrategyMultiply implements Strategy {
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyMultiply's execute()");
        return a * b;   // Do a multiplication with a and b
    }
}
 
// Configured with a ConcreteStrategy object and maintains a reference to a Strategy object
class Context {
    private Strategy strategy;
     // Constructor
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    // execute strategy
    public int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
 
}
