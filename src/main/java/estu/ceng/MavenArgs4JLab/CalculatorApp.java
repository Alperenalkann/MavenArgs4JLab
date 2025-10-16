package estu.ceng.MavenArgs4JLab;

import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.CmdLineException;

public class CalculatorApp {

    @Option(name="--num1", required=true, usage="First number")
    private double num1;

    @Option(name="--num2", required=true, usage="Second number")
    private double num2;

    @Option(name="--op", required=true, usage="Operation: add, sub, mul, div")
    private String operation;

    @Option(name="--round", usage="Round the result")
    private boolean round;

    public static void main(String[] args) {
        new CalculatorApp().doMain(args);
    }

    public void doMain(String[] args) {
        Double finalResult = null;
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
            switch (operation){
                case "add":
                    finalResult= num1 + num2;
                    break;
                case "sub":
                    finalResult= num1 - num2;
                    break;
                case "mul":
                    finalResult=num1 * num2;
                    break;
                case "div":
                    finalResult=num1 / num2;
                    break;
                default:
                    System.out.println("Invalid operation");
            }
            if(finalResult != null ){
                if (round) {
                    System.out.println("Result: " + Math.round(finalResult));
                } else {
                    System.out.println("Result: " + finalResult);
                }
            }
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
  }
}
}