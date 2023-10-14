package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr value) implements Expr {
        public Negate(double value) {
            this(new Constant(value));
        }

        @Override
        public double evaluate() {
            return -value.evaluate();
        }
    }

    record Exponent(Expr left, Expr right) implements Expr {
        public Exponent(double left, double right) {
            this(new Constant(left), new Constant(right));
        }

        public Exponent(Expr left, double right) {
            this(left, new Constant(right));
        }

        public Exponent(double left, Expr right) {
            this(new Constant(left), right);
        }

        @Override
        public double evaluate() {
            return Math.pow(left.evaluate(), right.evaluate());
        }
    }

    record Addition(Expr left, Expr right) implements Expr {
        public Addition(double left, double right) {
            this(new Constant(left), new Constant(right));
        }

        public Addition(Expr left, double right) {
            this(left, new Constant(right));
        }

        public Addition(double left, Expr right) {
            this(new Constant(left), right);
        }

        @Override
        public double evaluate() {
            return left.evaluate() + right.evaluate();
        }
    }

    record Multiplication(Expr left, Expr right) implements Expr {
        public Multiplication(double left, double right) {
            this(new Constant(left), new Constant(right));
        }

        public Multiplication(Expr left, double right) {
            this(left, new Constant(right));
        }

        public Multiplication(double left, Expr right) {
            this(new Constant(left), right);
        }

        @Override
        public double evaluate() {
            return left.evaluate() * right.evaluate();
        }
    }
}
