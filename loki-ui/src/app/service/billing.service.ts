import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { GlobalService } from './global.service'
import { APIProvider } from '../provider/api-provider';


@Injectable({
    providedIn: 'root'
})
export class BillingService {

    constructor(private globalService: GlobalService) {

    }

    /**
     * find all products to list in the billing component
     */
    findAllProducts(): Observable<any> {
        return this.globalService.getService(APIProvider.PRODUCT_ENDPOINTS.FINDALL, 'Find All Products');
    }

    findAllCustomers(): Observable<any> {
        return this.globalService.getService(APIProvider.CUSTOMER_ENDPOINTS.get, 'Find All Customers');
    }
}