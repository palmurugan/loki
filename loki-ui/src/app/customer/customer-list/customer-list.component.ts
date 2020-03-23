import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatDialog } from '@angular/material';

import { ConfirmDialogComponent, ConfirmDialogModel } from '../../components/confirm-dialog/confirm-dialog.component';

import { CustomerService } from '../../customer/service/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  delete: string = '';
  length: number;
  pageIndex: number = 0;
  pageSize: number = 5;
  pageSizeOptions: number[] = [5, 10, 25, 50, 100];

  displayedColumns: string[] = ['firstName', 'lastName', 'company', 'email', 'phone', 'action'];
  dataSource: MatTableDataSource<any> | null;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private customerService: CustomerService, public dialog: MatDialog) { }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.customerService.getAllCustomers(this.pageIndex, this.pageSize).subscribe(data => {
      this.setPagination(data['totalElements'], data['number'], data['size']);
      this.dataSource = new MatTableDataSource(data['content']);
    })
  }

  setPagination(length: number, startIndex: number, pageSize: number) {
    this.length = length;
    this.pageIndex = startIndex;
    this.pageSize = pageSize;
  }

  onPaginateChange(event: any) {
    this.pageIndex = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadData();
  }

  onDelete(customerId: number): void {
    const message = 'Are you sure you want to delete?';

    const dialogData = new ConfirmDialogModel("Delete Customer", message);

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      width: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      if (dialogResult) {
        this.customerService.deleteCustomer(customerId).subscribe(result => {
          /* Refresh Grid after delete */
          this.loadData();
        });
      }
    });
  }
}