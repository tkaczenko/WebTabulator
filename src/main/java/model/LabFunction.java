package model;

/**
 * Created by tkaczenko on 22.02.17.
 */
public class LabFunction extends Function {
    private double x;
    private double y;
    private ExpressionType expressionType;

    public double function(double x) {
        this.x = x;
        if (x > a) {
            expressionType = ExpressionType.X_GREATER_A;
            return y = x * Math.sqrt(x - a);
        } else if (x == a) {
            expressionType = ExpressionType.X_EQUAL_A;
            return y = x * Math.sin(a * x);
        } else {
            expressionType = ExpressionType.X_LESS_A;
            return y = Math.exp(-a * x) * Math.cos(a * x);
        }
    }

    @Override
    public String toString() {
        return expressionType.toString() + "; a = " + a + ", x = " + x;
    }

    public ExpressionType getExpressionType() {
        return expressionType;
    }

    public enum ExpressionType {
        X_GREATER_A {
            @Override
            public String toString() {
                return "x * Math.sqrt(x - a)";
            }
        }, X_EQUAL_A {
            @Override
            public String toString() {
                return "x * Math.sin(a * x)";
            }
        }, X_LESS_A {
            @Override
            public String toString() {
                return "Math.exp(-a * x) * Math.cos(a * x)";
            }
        }
    }
}
