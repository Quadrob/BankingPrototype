import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { SavingsComponent } from './savings/savings.component';
import { CurrentComponent } from './current/current.component';
import { DepositComponent as SavingsDepositComponent } from './savings/deposit/deposit.component';
import { WithdrawComponent as SavingsWithdrawComponent } from './savings/withdraw/withdraw.component';
import { WithdrawComponent } from './current/withdraw/withdraw.component';
import { DepositComponent } from './current/deposit/deposit.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login' },
	{ path: 'login', component: LoginComponent },
	{ path: 'menu',	component: MenuComponent },

  { path: 'savings', component: SavingsComponent },
  { path: 'savings/deposit', component: SavingsDepositComponent },
  { path: 'savings/withdraw', component: SavingsWithdrawComponent },

  { path: 'current', component: CurrentComponent },
  { path: 'current/deposit', component: DepositComponent },
  { path: 'current/withdraw', component: WithdrawComponent },

  { path: '**', pathMatch: 'full', redirectTo: 'menu' }
];

@NgModule({
	imports: [RouterModule.forRoot(routes)],
	exports: [RouterModule]
})
export class AppRoutingModule { }
