import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { CustumersService } from 'src/app/services/custumers/custumers.service';
import { ProductsService } from 'src/app/services/products/products.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  customerForm!: FormGroup;
  customers: any;

  constructor(
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






  guardar(): void {
    this.custumersService.saveCustomer(this.customerForm.value).subscribe(resp => {
      this.customerForm.reset();
      this.customers=this.customers.filter((customers: { idCustomer: any; })=> resp.idCustomer!==customers.idCustomer);
      this.customers.push(resp);
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'Cliente Guardado Exitosamente',
        showConfirmButton: false,
        timer: 1500
      });
    },

      error => {
        console.error(error),
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'No se puede crear cliente',
          showConfirmButton: false,
          timer: 1500

        })
      })

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

  update(customer:any) {
    this.customerForm.setValue({
      idCustomer:customer.idCustomer,
      identificationType: customer.identificationType,
      identificationNumber: customer.identificationNumber,
      names: customer.names,
      lastName: customer.lastName,
      email: customer.email,
      birthDate: customer.birthDate,
    })
    }


    

}
