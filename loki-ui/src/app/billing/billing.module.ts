import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { PrimeNgModule } from '../primeng.module';
import { MaterialModule } from '../material-module';

import { BillingComponent } from '../components/billing/billing.component';
import { InvoiceComponent } from './invoice/invoice.component';


@NgModule({
  declarations: [
    InvoiceComponent,
    BillingComponent
  ],
  imports: [
    CommonModule,
    PrimeNgModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class BillingModule { }
