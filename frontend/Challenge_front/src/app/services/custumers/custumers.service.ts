import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustumersService {
  public API_SERVER="http://localhost:8080/v1/api/customers"

  constructor(
    public httpClient: HttpClient) { }


    public getAllCustomer(): Observable<any>{
      return this.httpClient.get(this.API_SERVER);
    }

    public saveCustomer (customer:any): Observable<any>{
      return this.httpClient.post(this.API_SERVER,customer);
    }
    
    public getCustomerById (idCustomer:any): Observable<any>{
      return this.httpClient.get(this.API_SERVER+"/"+(idCustomer))
    }

    public deleteCustomer(custumer:any): Observable<any>{
     
      return this.httpClient.delete(this.API_SERVER+"/"+(custumer.idCustomer) );
    }

    public updateCustomerById(custumer:any):Observable<any> {
      return this.httpClient.put(this.API_SERVER+"/"+(custumer.idCustomer), custumer);
      
    }
    
}
