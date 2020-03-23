import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { APIProvider } from '../../provider/api-provider';
import { GlobalService } from '../../service/global.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private globalService: GlobalService) { }

  /**
   * 
   * @param customerForm 
   */
  createCustomer(customerForm: any): Observable<any> {
    return this.globalService.postService(APIProvider.CUSTOMER_ENDPOINTS.create, customerForm, 'createCustomer');
  }

  /**
   * 
   * @param customerId 
   * @param customerForm 
   */
  updateCustomer(customerId: number, customerForm: any) {
    return this.globalService.putService(APIProvider.CUSTOMER_ENDPOINTS.create + '/' + customerId, customerForm, 'createCustomer');
  }

  /**
   * Http service to fetch all the customer details
   */
  getAllCustomers(page: number, size: number): Observable<any> {
    return this.globalService.getService(APIProvider.CUSTOMER_ENDPOINTS.get + '?page=' + page + '&size=' + size, 'getAllCustomers');
  }

  /**
   * Http servie to fetch a customer
   * @param customerId 
   */
  getCustomer(customerId: number): Observable<any> {
    return this.globalService.getService(APIProvider.CUSTOMER_ENDPOINTS.get + '/' + customerId, 'getCustomers');
  }

  /**
   * Http service to delete a customer
   */
  deleteCustomer(customerId: number) {
    return this.globalService.deleteService(APIProvider.CUSTOMER_ENDPOINTS.create + '/' + customerId, 'deleteCustomer');
  }
}
