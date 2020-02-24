import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { HttpClientModule, HttpClient, HttpHandler } from '@angular/common/http'
import { AppRoutingModule } from './app-routing/app-routing.module';

/** Application Modules */
import { CustomerModule } from './customer/customer.module';
import { BillingModule } from './billing/billing.module';

/* Third party modules */
import { PrimeNgModule } from './primeng.module';
import { MaterialModule } from './material-module';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

/** Application Components */
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { FormComponent } from './components/form/form.component';
import { TestComponent } from './components/test/test.component';

/** Custom Services */
import { BillingService } from './service/billing.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    FormComponent,
    TestComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    PrimeNgModule,
    MDBBootstrapModule.forRoot(),
    CustomerModule,
    BillingModule,
    FormsModule,
    MaterialModule,
    ReactiveFormsModule
  ],
  providers: [BillingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
