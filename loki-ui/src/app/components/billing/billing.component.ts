import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';

@Component({
  selector: 'app-billing',
  templateUrl: './billing.component.html',
  styleUrls: ['./billing.component.css']
})
export class BillingComponent implements OnInit {

  billing_periods: any[];
  units: any[];

  myControl = new FormControl();
  products: any[] = [
    { name: 'Product 1' },
    { name: 'Product 2' },
    { name: 'Product 3' }
  ];

  displayedColumns: string[] = ['no', 'name', 'unit', 'price', 'quantity', 'discount', 'cgst', 'sgst', 'igst', 'total'];
  data: any[] = ELEMENT_DATA;

  filteredOptions: Observable<any[]>;

  constructor() { }

  ngOnInit() {

    this.billing_periods = [
      { code: '15D', description: 'Every 15 days' },
      { code: '30D', description: 'Monthly' },
      { code: '90D', description: 'Quarterly' }
    ]

    this.units = [
      { code: 'Ton(s)', description: 'Every 15 days' },
      { code: 'KG', description: 'Monthly' },
      { code: '90D', description: 'Quarterly' }
    ]

    this.filteredOptions = this.myControl.valueChanges
      .pipe(
        startWith(''),
        map(value => typeof value === 'string' ? value : value.name),
        map(name => name ? this._filter(name) : this.products.slice())
      );
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
  { no: 1, name: 'Product1', unit: 'KG', price: 1250.50, quantity: 12, discount: 2.5, cgst: 1200, sgst: 1200, igst: 0, 'total': 12000 },
  { no: 2, name: 'Product2', unit: 'KG', price: 1250.50, quantity: 12, discount: 2.5, cgst: 1200, sgst: 1200, igst: 0, 'total': 12000 },
  { no: 3, name: 'Product3', unit: 'KG', price: 1250.50, quantity: 12, discount: 2.5, cgst: 1200, sgst: 1200, igst: 0, 'total': 12000 }
];
