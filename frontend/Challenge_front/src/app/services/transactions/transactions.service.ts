import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class TransactionsService {
  public API_SERVER="http://localhost:8080/v1/api/transaction"
  constructor(public httpClient: HttpClient
  ) { }

  public createTransaction (transaction:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER,transaction);
  }

  public createTransactionReception (transaction:any): Observable<any>{
    return this.httpClient.post(this.API_SERVER+"/reception",transaction);
  }
  
  
  public findAllByProduct (idAccount:any): Observable<any>{
    return this.httpClient.get(this.API_SERVER+"/"+(idAccount))
  }

  public getTransactionById(idTransaction:any): Observable<any>{
   
    return this.httpClient.delete(this.API_SERVER+"/"+(idTransaction) );
  }


}
