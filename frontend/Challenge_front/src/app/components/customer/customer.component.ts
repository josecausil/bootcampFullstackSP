import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { CustumersService } from 'src/app/services/custumers/custumers.service';
import { ProductsService } from 'src/app/services/products/products.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { VirtualTimeScheduler } from 'rxjs';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit{
  customerForm!: FormGroup;
  customers: any;

  constructor(
    public router: Router,
    public fb: FormBuilder,
    public custumersService: CustumersService,
    public productsService: ProductsService,
    public transactionsService: TransactionsService

  ) {

  }

  ngOnInit(): void {

    this.customerForm = this.fb.group({

      idCustomer: [''],
      identificationType: ['', Validators.required],
      identificationNumber: ['', Validators.required],
      names: ['', Validators.minLength(2)],
      lastName: ['', Validators.minLength(2)],
      email: ['', Validators.email],
      birthDate: ['', Validators.required],

    });
    this.custumersService.getAllCustomer().subscribe(resp => {

      this.customers = resp;
    },
      error => { console.error(error) }
    );


  }

  manage(idCustomer: any){
    
    this.router.navigate(['customer/details', (idCustomer)]);
   
  }

  update(idCustomer:any) {

    this.router.navigate(['customer/update-customer', (idCustomer)]);

    }

  delete(custumer:any) {
    this.custumersService.deleteCustomer(custumer).subscribe(resp => {
        
        this.customers.pop(custumer)
        Swal.fire({
          position: 'top',
          icon: 'success',
          title: 'Cliente eliminado Exitosamente',
          showConfirmButton: false,
          timer: 1500
        });
      

    },
    error => {
      console.error(error),
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No se puede eliminar cliente',
        showConfirmButton: false,
        timer: 1500

      })
    }
    )
  }



}
