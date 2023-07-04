import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { SavingsService } from 'src/app/services/savings.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent {
  amount: number = 0.0;
  balance: number = 0.0;
  account: number = 0.0;
  show: boolean = false;
  fail: boolean = false;

  constructor(public loginService: LoginService, public router: Router, public savingsService: SavingsService) {
      this.loginService.currentUser === undefined ? this.router.navigate(['/login']) : this.savingsService.getSavings(this.loginService.currentUser['accountId']).subscribe(savings => {
        if (savings) {
          this.savingsService.currentSavings = savings;
          this.account = savings['accountId'];
          this.balance = savings['accountAmount'];
        }
      });
  }

  submit() {
    const savingsAccount = {
        "accountHolderId": this.loginService.currentUser ? this.loginService.currentUser['accountId'] : undefined,
        "accountAmount": this.amount
    }
    this.savingsService.withdrawSavings(savingsAccount).subscribe(savings => {
      if (savings) {
        this.savingsService.currentSavings = savings;
        this.account = savings['accountId'];
        this.balance = savings['accountAmount'];
        this.show = true;
        this.fail = false;
        this.amount = 0.00;
      } else {
        this.show = false
        this.fail = true
      }
    });
  }

  menu() {
    this.router.navigate(['/savings']);
  }
}

