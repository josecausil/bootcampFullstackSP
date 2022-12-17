
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
  transactionForm!: FormGroup;
  transaction: any;
  product: Product;
  idAccount: number;

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

    this.transactionForm = this.fb.group({

      
      idTransaction: [''],
      transactionDate: [''],
      typeTransaction: ['', Validators.required],
      Description: [''],
      valueTransfer: ['', Validators.required],
      movementType: [''],
      balance: [''],
      availableBalance: [''],
      idReceptionAccount: [''],
      product: ['']

    });

    this.transactionForm.get('product')?.valueChanges.subscribe(__values=>{
      this.transaction
    })





  }






  guardar(): void {
    this.transactionsService.createTransaction(this.transactionForm.value).subscribe(resp => {
      this.transactionForm.reset();
      this.transaction=this.transaction.filter((transaction: { idTransaction: any; })=> resp.idTransaction!==transaction.idTransaction);
      this.transaction.push(resp);
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'Trabsaccion Exitosa',
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



}

