package com.loki.invoice.core.util;

import java.math.BigDecimal;

public enum TaxValueEnum {
    TAX_5(BigDecimal.valueOf(5)),
    TAX_12(BigDecimal.valueOf(12)),
    TAX_15(BigDecimal.valueOf(15));

    private BigDecimal value;

    TaxValueEnum(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}
