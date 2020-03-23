import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { CustomerService } from '../../customer/service/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {

  customerForm: FormGroup;

  customerCategories: any[];
  countries: any[];
  states: any[];
  currencies: any[];
  tax_preferences: any[];
  billing_periods: any[];
  billing_types: any[];

  currency: string;
  tax_preference: string;
  billing_period: number;
  billing_type: number;

  updateMode: boolean = false;
  customerId: number;


  constructor(private router: Router, private formBuilder: FormBuilder, private route: ActivatedRoute, private customerService: CustomerService) {

    this.customerCategories = [
      { id: 1, name: 'Regular Customer' },
      { id: 2, name: 'Advanced Customer' },
      { id: 3, name: 'Premium Customer' }
    ]

    this.countries = [
      { code: 'IN', description: 'India' }
    ]

    this.states = [
      { code: 'TN', description: 'Tamilnadu' },
      { code: 'KL', description: 'Kerala' }
    ]

    this.currencies = [
      { code: 'INR', description: 'INR' },
      { code: 'USD', description: 'USD' }
    ]

    this.billing_periods = [
      { code: '15D', description: 'Every 15 days' },
      { code: '30D', description: 'Monthly' },
      { code: '90D', description: 'Quarterly' }
    ]

    this.billing_types = [
      { description: 'Prepaid', code: 'PREPAID' },
      { description: 'Postpaid', code: 'POSTPAD' },
      { description: 'Order Based', code: 'ORDERBASED' },
      { description: 'Delivery Based', code: 'DELIVERYBASED' }
    ]
  }

  ngOnInit() {
    this.initiateForm();

    /**
     * This block of code mainly used for handling edit mode
     */
    this.route.paramMap.subscribe(params => {
      if (params.get('id')) {
        this.customerId = parseInt(params.get('id'));
        this.customerService.getCustomer(this.customerId).subscribe(result => {
          this.updateMode = true;
          this.customerForm.patchValue(result);
        });
      }
    });
  }

  initiateForm() {
    this.customerForm = this.formBuilder.group({
      id: new FormControl(''),
      firstName: new FormControl('', [Validators.required]),
      lastName: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required]),
      company: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required, Validators.email]),
      customerCategory: new FormControl('', [Validators.required]),
      customerContact: this.formBuilder.group({
        address1: new FormControl('', [Validators.required]),
        city: new FormControl('', [Validators.required]),
        country: new FormControl('', [Validators.required]),
        state: new FormControl('', [Validators.required]),
        zip: new FormControl('', [Validators.required]),
        address2: new FormControl('')
      }),
      customerDetail: this.formBuilder.group({
        currency: new FormControl('', [Validators.required]),
        billType: new FormControl('', [Validators.required]),
        billingPeriod: new FormControl('', [Validators.required]),
        billCreditLimit: new FormControl('', [Validators.required]),
        creditLimit: new FormControl('', [Validators.required]),
        tin: new FormControl(''),
        gstin: new FormControl(''),
        pan: new FormControl('')
      })
    });

    this.customerForm.patchValue({
      country: 'IN',
      state: 'TN',
      currency: 'INR',
      customerCategory: 1
    })
  }

  save() {
    this.customerService.createCustomer(this.customerForm.value).subscribe(result => {
      this.router.navigate(['/customerlist']);
    });
  }

  update() {
    this.customerService.updateCustomer(this.customerId, this.customerForm.value).subscribe(result => {
      this.router.navigate(['/customerlist']);
    });
  }

  cancel() {
    this.router.navigate(['/customerlist']);
  }

  // convenience getter for easy access to form fields
  get cf() { return this.customerForm.controls; }
}
