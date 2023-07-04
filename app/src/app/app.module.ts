import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { SavingsComponent } from './savings/savings.component';
import { CurrentComponent } from './current/current.component';
import { DepositComponent as SavingsDepositComponent } from './savings/deposit/deposit.component';
import { WithdrawComponent as SavingsWithdrawComponent } from './savings/withdraw/withdraw.component';
import { WithdrawComponent } from './current/withdraw/withdraw.component';
import { DepositComponent } from './current/deposit/deposit.component';

import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [AppComponent, LoginComponent, MenuComponent, SavingsComponent, CurrentComponent, DepositComponent, WithdrawComponent, SavingsDepositComponent, SavingsWithdrawComponent],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    MatButtonModule,
    MatInputModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
