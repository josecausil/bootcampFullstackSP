import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  public API_SERVER="http://localhost:8080/v1/api/product"

  constructor(public httpClient: HttpClient
    
  ) { }

  
  public getAllProdcut (idAccount:any): Observable<any>{
    return this.httpClient.get(this.API_SERVER+"/allAccounts/"+(idAccount));
  }


  public createProduct (product:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER,product);
  }
  
  public findAllByCustomer (idCustomer:any): Observable<any>{
    return this.httpClient.get(this.API_SERVER+"/"+(idCustomer))
  }

  public getProductById(idAccount:any): Observable<any>{
   
    return this.httpClient.get(this.API_SERVER+"/account/"+(idAccount) );
  }

  public updateProduct(product:any):Observable<any> {
    return this.httpClient.put(this.API_SERVER+"/"+(product.idAccount),product );
    
  }
}
