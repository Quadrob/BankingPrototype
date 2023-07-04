import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CurrentService } from 'src/app/services/current.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css'],
})
export class WithdrawComponent {
  amount: number = 0.0;
  balance: number = 0.0;
  account: number = 0.0;
  overdraft: number = 0.0;
  show: boolean = false;
  fail: boolean = false;

  constructor(public loginService: LoginService, public router: Router, public currentService: CurrentService) {
    this.loginService.currentUser === undefined ? this.router.navigate(['/login']) : this.currentService.getCurrent(this.loginService.currentUser['accountId'])
      .subscribe((current) => {
        if (current) {
          this.currentService.currentAccount = current;
          this.account = current['accountId'];
          this.balance = current['accountAmount'];
          this.overdraft = current['accountOverdraftAmount'];
        }
      });
  }

  submit() {
    const currentAccount = {
      accountHolderId: this.loginService.currentUser ? this.loginService.currentUser['accountId'] : undefined,
      accountOverdraftAmount: this.amount
    };
    this.currentService.withdrawCurrennt(currentAccount).subscribe((current) => {
        if (current) {
          this.currentService.currentAccount = current;
          this.account = current['accountId'];
          this.balance = current['accountAmount'];
          this.overdraft = current['accountOverdraftAmount'];
          this.show = true;
          this.fail = false;
          this.amount = 0.0;
        } else {
          this.show = false;
          this.fail = true;
        }
      });
  }

  menu() {
    this.router.navigate(['/current']);
  }
}
