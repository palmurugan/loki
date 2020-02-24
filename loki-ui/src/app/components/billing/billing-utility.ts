export function prepareBillingLine(data: any): any {
    var billingLine = data.item;
    billingLine.quantity = data.quantity;
    billingLine.discountPercentage = data.item.discount;
    billingLine.discount = calculateDiscount(data).toFixed(2);
    billingLine.cgst = calculateGST(data, billingLine.discount).toFixed(2);
    billingLine.sgst = calculateGST(data, billingLine.discount).toFixed(2);
    billingLine.total = calculateTotal(data, billingLine.discount).toFixed(2);
    return billingLine;
}

function calculateGST(data: any, discountValue: number): number {
    return ((((+data.item.price * +data.quantity) - discountValue) * (+data.item.tax / 100)) / 2);
}

function calculateDiscount(data: any): number {
    return ((parseInt(data.item.price) * parseInt(data.quantity)) * (parseInt(data.item.discount) / 100));
}

function calculateTotal(data: any, discount: number): number {
    return ((((parseInt(data.item.price) * parseInt(data.quantity)) + calculateGST(data, discount) + calculateGST(data, discount))) - discount);
}
