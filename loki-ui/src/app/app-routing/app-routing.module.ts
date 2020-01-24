import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from '../customer/customer/customer.component';
import { CustomerListComponent } from '../customer/customer-list/customer-list.component';

import { AppComponent } from '../app.component';

const routes: Routes = [
  {
    path: '',
    component: AppComponent
  }, {
    path: 'customer',
    component: CustomerComponent,
  }, {
    path: 'customer/:id', component: CustomerComponent
  }, {
    path: 'customerlist',
    component: CustomerListComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }