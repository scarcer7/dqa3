package com.razor.dqa.annotation.type;

public enum Operator implements MathOp {
    UNKNOWN {    
        @Override
        public double op(double v1, double v2) {
            return 0;
        }
    },
    PLUS{
        
        @Override
        public double op(double v1, double v2) {
            return v1 + v2;
        }
    },
    MINUS{
        
        @Override
        public double op(double v1, double v2) {
            return v1 - v2;
        }
    },
    MULTIPLY{
        
        @Override
        public double op(double v1, double v2) {
            return v1 * v2;
        }
    },
    DIVIDE{
        
        @Override
        public double op(double v1, double v2) {
            return v1 / v2;
        }
    };

}
