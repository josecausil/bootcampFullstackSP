import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerComponent } from './components/customer/customer.component';
import { DetailsComponent } from './components/details/details.component';
import { HomeComponent } from './components/home/home.component';
import { PagenotfoundComponent } from './components/pagenotfound/pagenotfound.component';
import { ProductComponent } from './components/product/product.component';
import { UpdateCustomerComponent } from './components/update-customer/update-customer.component';
import { StatusTransactionComponent } from './components/status-transaction/status-transaction.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'customer', component: CustomerComponent},
  {path: 'product/:id',component: ProductComponent},
  {path: 'customer/details/:id',component: DetailsComponent },
  {path: 'customer/update-customer/:id', component: UpdateCustomerComponent},
  {path: 'status-transaction/:id', component: StatusTransactionComponent},
  {path: 'profile', component: ProfileComponent},
  {path:'**',component: PagenotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
