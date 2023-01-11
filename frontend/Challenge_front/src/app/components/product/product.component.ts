
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { CustumersService } from 'src/app/services/custumers/custumers.service';
import { ProductsService } from 'src/app/services/products/products.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import Swal from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/product';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit{

  value: string;
  transactionForm!: FormGroup;
  transaction: any;
  product: Product;
  idAccount: number;
  products: any;
  resss: number ;

  constructor(
    public router: Router,
    public fb: FormBuilder,
    public route: ActivatedRoute,
    public custumersService: CustumersService,
    public productsService: ProductsService,
    public transactionsService: TransactionsService

  ) {

  }

  ngOnInit(): void {

    this.idAccount = this.route.snapshot.params['id'];
    this.product= new Product();
    this.productsService.getProductById(this.idAccount).subscribe(resp=> {
    this.product =resp;
    },
     
    );

    
    this.productsService.getAllProdcut(this.idAccount).subscribe(resp =>{
             this.products = resp;
    },
    error => { console.error(error) } 
    
    );

    this.transactionForm = this.fb.group({

      
      idTransaction: [''],
      description: [''],
      valueTransfer: ['', Validators.required],
      movementType: ['', Validators.required],
      idReceptionAccount: [''],
      product: ['', Validators.required]

    });

    this.transactionForm.get('product')?.valueChanges.subscribe(__values=>{
      this.transaction
    })

  }

  guardar(): void {
    this.transactionsService.createTransaction(this.transactionForm.value).subscribe(resp => {
      if (resp.movementType==="Transferencia") {
        this.transactionsService.createTransactionReception(this.transactionForm.value).subscribe(resp2 =>{

          this.transactionForm.reset();

          Swal.fire({
            position: 'top',
            icon: 'success',
            title: 'Transaccion Exitosa',
            showConfirmButton: false,
            timer: 1500
          });
  
        },
  
        error => {
          console.error(error),
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Transacción no valida',
            showConfirmButton: false,
            timer: 1500
  
          })
        }
        )
        
      } else {
        this.transactionForm.reset();

        Swal.fire({
          position: 'top',
          icon: 'success',
          title: 'Transaccion Exitosa',
          showConfirmButton: false,
          timer: 1500
        });
      }  
   
    },

      error => {
        console.error(error),
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: 'Transacción no valida',
          showConfirmButton: false,
          timer: 1500

        })
      })

  }



  back(idCustomer: any): void{
      this.router.navigate(['details', (idCustomer)]);
    Swal.fire({
      position: 'top',
      icon: 'error',
      title: 'Proceso cancelado',
      showConfirmButton: false,
      timer: 1500
    });
    
  }
  


}

