package com.loki.invoice.core.cache.dto;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class InvoiceLineCacheDTO {

    @QuerySqlField(index = true)
    private Long id;

    @QuerySqlField(index = true)
    private Long invoiceId;

    @QuerySqlField(index = true)
    private Long itemId;

    @QuerySqlField(index = true)
    @NotNull(message = "Price is required")
    private BigDecimal price;

    @QuerySqlField(index = true)
    @NotNull(message = "Quantity is required")
    private Double quantity;

    @QuerySqlField(index = true)
    private String tax;

    @QuerySqlField(index = true)
    private String discountType;

    @QuerySqlField(index = true)
    private Double discount;

    @QuerySqlField(index = true)
    private String description;

    private BigDecimal CGST;

    private BigDecimal SGST;

    private BigDecimal IGST;

    private BigDecimal originalPrice;

    private BigDecimal netPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getCGST() {
        return CGST;
    }

    public void setCGST(BigDecimal CGST) {
        this.CGST = CGST;
    }

    public BigDecimal getSGST() {
        return SGST;
    }

    public void setSGST(BigDecimal SGST) {
        this.SGST = SGST;
    }

    public BigDecimal getIGST() {
        return IGST;
    }

    public void setIGST(BigDecimal IGST) {
        this.IGST = IGST;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }
}
