import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
import { Customer } from 'src/app/customer';
import { CustumersService } from 'src/app/services/custumers/custumers.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-customer',
  templateUrl: './update-customer.component.html',
  styleUrls: ['./update-customer.component.css']
})
export class UpdateCustomerComponent implements OnInit{

  customers:any;
  customerForm:FormGroup;
  idCustomer: number;
  customer: Customer;


  constructor(
    public router: Router,
    public fb: FormBuilder,
    public route: ActivatedRoute,
    public custumersService: CustumersService,
  ){
    
  }
  ngOnInit(): void {
    this.idCustomer = this.route.snapshot.params['id'];
    this.customer= new Customer();
    this.custumersService.getCustomerById(this.idCustomer).subscribe(resp=> {
      this.customer =resp;
      },
       
      );
    
  }

  goListCustomer():void{

    this.router.navigate(['/customer']);
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Cliente Actualizado Exitosamente',
      showConfirmButton: false,
      timer: 1500
    });

  }


  update():void{
    this.custumersService.updateCustomerById(this.customer).subscribe(res=> {
      this.goListCustomer();

    },
    error => {
      console.error(error),
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No se puede actualizar cliente',
        showConfirmButton: false,
        timer: 1500

      })
    }
    )
  }

  cancel(): void{
    this.router.navigate(['/customer']);
    Swal.fire({
      position: 'top',
      icon: 'error',
      title: 'Proceso cancelado',
      showConfirmButton: false,
      timer: 1500
    });
    
  }

}
