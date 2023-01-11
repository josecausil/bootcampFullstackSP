import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, UntypedFormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ProductsService } from 'src/app/services/products/products.service';
import { TransactionsService } from 'src/app/services/transactions/transactions.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { Product } from 'src/app/product';

@Component({
  selector: 'app-status-transaction',
  templateUrl: './status-transaction.component.html',
  styleUrls: ['./status-transaction.component.css']
})
export class StatusTransactionComponent implements OnInit{

  transactions:any;
  transactionForm: FormGroup;
  idProduct: number;
  product: Product;

  constructor(
    public router: Router,
    public fb: FormBuilder,
    public route: ActivatedRoute,
    public productsService: ProductsService,
    public transactionsService: TransactionsService
    ){
  
  }

  ngOnInit(): void {
  this.idProduct = this.route.snapshot.params['id'];
  this.product= new Product();
  this.productsService.getProductById(this.idProduct).subscribe(resp=> {
  this.product =resp;
  },
  );



  this.transactionsService.findAllByProduct(this.idProduct).subscribe(resp => {

    this.transactions = resp;
  },
    error => { console.error(error) }
  );

  

 }



}
