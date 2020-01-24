import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { PrimeNgModule } from '../primeng.module';
import { MaterialModule } from '../material-module';
import { AppRoutingModule } from '../app-routing/app-routing.module';
import { HttpClientModule } from '@angular/common/http';

/**
 * Customer module components
 */
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerComponent } from './customer/customer.component';
import { ConfirmDialogComponent } from '../components/confirm-dialog/confirm-dialog.component';

/**
 * Customer module services
 */
import { APIProvider } from '../provider/api-provider';
import { CustomerService } from '../customer/service/customer.service';

@NgModule({
  declarations: [CustomerComponent, CustomerListComponent, ConfirmDialogComponent],
  imports: [
    CommonModule,
    PrimeNgModule,
    MDBBootstrapModule,
    FormsModule,
    MaterialModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ], providers: [
    APIProvider,
    CustomerService
  ], entryComponents: [ConfirmDialogComponent]
})
export class CustomerModule { }
