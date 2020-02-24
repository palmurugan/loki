import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { MatTableDataSource } from '@angular/material';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

import { prepareBillingLine } from './billing-utility';
import { BillingService } from '../../service/billing.service';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  billingForm: FormGroup;
  billing_periods: any[];
  units: any[];
  products: any[];
  data: any[] = ELEMENT_DATA;
  filteredOptions: Observable<any[]>;
  billingLines: any[] = [];

  subTotal: number = 0;
  totalCGST: number = 0;
  totalSGST: number = 0;
  totalDiscount: number = 0;
  totalAmount: number = 0;


  displayedColumns: string[] = ['name', 'price', 'unit', 'quantity', 'discount', 'cgst', 'sgst', 'igst', 'total'];
  dataSource = new MatTableDataSource(this.billingLines);
  constructor(private billingService: BillingService, private formBuilder: FormBuilder, private changeDetectorRef: ChangeDetectorRef) { }

  ngOnInit() {

    this.initiateForm();

    /**
     * Fetching product list to show it in the billing component
     */
    this.billingService.findAllProducts().subscribe(result => {
      this.products = result;
      this.filteredOptions = this.billingForm.controls.item.valueChanges
        .pipe(
          startWith(''),
          map(value => typeof value === 'string' ? value : value.name),
          map(name => name ? this._filter(name) : this.products.slice())
        );
    });

    this.units = [
      { code: 'TON', description: 'Ton' },
      { code: 'KG', description: 'Kilogram' },
      { code: 'PKT', description: 'Packet' }
    ]

    this.billing_periods = [
      { code: '15D', description: 'Every 15 days' },
      { code: '30D', description: 'Monthly' },
      { code: '90D', description: 'Quarterly' }
    ]
  }

  /**
   * Adding items to the line
   */
  fnAddItem() {
    this.billingLines.push(prepareBillingLine(this.billingForm.value));

    // Calculating total for each line item
    this.calculateTotal();

    // Clearing the form data
    this.billingForm.patchValue({ item: '', unit: '', price: 0, discount: 0, tax: 0, quantity: 0 });

    // Refresh the Billing Line Grid
    this.dataSource = new MatTableDataSource(this.billingLines);
  }

  /**
   * Calculate Total Amount for this bill
   */
  calculateTotal = function () {
    this.subTotal = 0;
    this.totalCGST = 0;
    this.totalSGST = 0;
    this.totalDiscount = 0;
    this.totalAmount = 0;
    this.billingLines.forEach((value: any) => {
      this.subTotal += ((+value.quantity) * (+value.price));
      this.totalCGST += (+value.cgst);
      this.totalSGST += (+value.sgst);
      this.totalDiscount += ((+value.price * +value.quantity) * (+value.discountPercentage / 100));
    });
    this.totalAmount = ((this.subTotal + this.totalCGST + this.totalSGST) - (this.totalDiscount)).toFixed(2);
  }

  /**
   * Rendering Item details after selecting the item
   * @param event 
   */
  fnRenderItemDetail(event: any) {
    let item = event.option.value;
    this.billingForm.patchValue({
      unit: item.unit,
      price: item.price,
      discount: item.discount,
      tax: item.tax
    });
  }

  /**
  * Adding total for each item entry
  * This function will trigger while user choosing the quantity
  */
  fnAddTotal() {
    if (this.billingForm.get('quantity').value && this.billingForm.get('price').value) {
      let quantity = parseInt(this.billingForm.get('quantity').value);
      let price = parseInt(this.billingForm.get('price').value);
      this.billingForm.patchValue({
        total: (quantity * price)
      });
    }
  }

  /**
  * Initializing the ReactForms
  */
  initiateForm() {
    this.billingForm = this.formBuilder.group({
      customerName: new FormControl(''),
      item: new FormControl(''),
      unit: new FormControl('', [Validators.required]),
      quantity: new FormControl('', [Validators.required]),
      price: new FormControl('', [Validators.required]),
      discount: new FormControl('', [Validators.required]),
      tax: new FormControl('', [Validators.required]),
      total: new FormControl('', [Validators.required])
    });
  }

  displayFn(data?: any): string | undefined {
    return data ? data.name : undefined;
  }

  private _filter(name: string): any[] {
    const filterValue = name.toLowerCase();
    return this.products.filter(option => option.name.toLowerCase().indexOf(filterValue) === 0);
  }
}

const ELEMENT_DATA: any[] = [
  { no: 1, name: 'Product1', unit: 'TON', price: 1250.50, quantity: 12, discount: 2.5, cgst: 1200, sgst: 1200, igst: 0, 'total': 12000 },
  { no: 2, name: 'Product2', unit: 'TON', price: 1250.50, quantity: 12, discount: 2.5, cgst: 1200, sgst: 1200, igst: 0, 'total': 12000 },
  { no: 3, name: 'Product3', unit: 'TON', price: 1250.50, quantity: 12, discount: 2.5, cgst: 1200, sgst: 1200, igst: 0, 'total': 12000 }
];
