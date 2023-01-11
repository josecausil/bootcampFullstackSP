import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/customer';
import { CustumersService } from 'src/app/services/custumers/custumers.service';
import Swal from 'sweetalert2';
import { ProductsService } from 'src/app/services/products/products.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import { __values } from 'tslib';
import { Router } from '@angular/router';
@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  products:any;
  productForm!: FormGroup;
  idCustomer: number ;
  customer: Customer;
  customerForm: any;

constructor(
  public router: Router,
  public fb: FormBuilder,
  public route: ActivatedRoute,
  public custumersService: CustumersService,
  public productsService: ProductsService,
  public transactionsService: TransactionsService
  ){

}

ngOnInit(): void {
   
  this.idCustomer = this.route.snapshot.params['id'];
  this.customer= new Customer();
  this.custumersService.getCustomerById(this.idCustomer).subscribe(resp=> {
  this.customer =resp;
  },
   
  );

  this.productForm = this.fb.group({
   
    idAccount: [''],
    typeAccount: ['',Validators.required],
    accountStatus:[''],
    customer: ['', Validators.required]
   
    
  
  });

  this.productForm.get('customer')?.valueChanges.subscribe(__values=>{
    this.products 
  })


  this.productsService.findAllByCustomer(this.idCustomer).subscribe(resp => {

    this.products = resp;
  },
    error => { console.error(error) }
  );


   
}

guardar(): void {
  this.productsService.createProduct(this.productForm.value).subscribe(resp => {
    this.productForm.reset();
    this.products=this.products.filter((products: { idAccount: any; })=> resp.idmer!==products.idAccount);
    this.products.push(resp);
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Producto creado con Exitosamente',
      showConfirmButton: false,
      timer: 1500
    });
  },

    error => {
      console.error(error),
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No se puede crear producto',
        showConfirmButton: false,
        timer: 1500

      })
    })

}

status(product:any){

  if(product.accountStatus=="Activa"){
    product.accountStatus="Inactiva"
  }else{
    product.accountStatus="Activa"
  }

  this.productsService.updateProduct(product).subscribe(resp =>{
    this.products=this.products.filter((products: { idAccount: any; })=> resp.idAccount!==products.idAccount);
   this.products.push(resp);

Swal.fire({
  position: 'top',
  icon: 'success',
  title: 'Estado Atualizado',
  showConfirmButton: false,
  timer: 1500
});

  },
  error => {
    console.error(error),
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'No se puedo Actualizar',
      showConfirmButton: false,
      timer: 1500

    })
  }
  )

}

transaction(idAccount:any){
  this.router.navigate(['product', (idAccount)]);
}

cancel(product:any){
  if(product.balance==0){
    product.accountStatus="Cancelado"
    
  this.productsService.updateProduct(product).subscribe(resp =>{

 
    Swal.fire({
      position: 'top',
      icon: 'success',
      title: 'Estado Atualizado',
      showConfirmButton: false,
      timer: 1500
    });
    
      },
      error => {
        console.error(error),
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'No se puedo Actualizar',
          showConfirmButton: false,
          timer: 1500
    
        })
      }
      )
    }else{
      Swal.fire({
        icon: 'error',
        title: 'No se puede cancelar',
        text: 'Tiene un saldo: '+product.balance,
        showConfirmButton: false,
        timer: 2000
  
      })
    }



}

statusTransaction(idAccount:any){
  this.router.navigate(['/status-transaction', (idAccount)]);
}

back(): void{
  this.router.navigate(['/customer']);

  
}

}
