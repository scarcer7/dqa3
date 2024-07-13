package com.razor.dqa.annotation.type;

public enum Comparison implements MathCompare {

    LESS_THAN {
        @Override
        public boolean pass(double v1, double v2) {
            return v1 < v2;
        }
    },
    GREATER_THAN {
        @Override
        public boolean pass(double v1, double v2) {
            return v1 > v2;
        }
    },
    EQUAL {
        @Override
        public boolean pass(double v1, double v2) {
            return v1 == v2;
        }
    },
    NOT_LESS_THAN {
        @Override
        public boolean pass(double v1, double v2) {
            return v1 >= v2;
        }
    },
    NOT_GREATER_THAN {
        @Override
        public boolean pass(double v1, double v2) {
            return v1 <= v2;
        }
    };

    
}
