import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-savings',
  templateUrl: './savings.component.html',
  styleUrls: ['./savings.component.css']
})
export class SavingsComponent {

  constructor(public loginService: LoginService, public router: Router) {
    if (this.loginService.currentUser === undefined) {
      this.router.navigate(['/login']);
    }
  }

  open() {
    this.router.navigate(['/savings/deposit']);
  }

  deposit() {
    this.router.navigate(['/savings/deposit']);
  }

  withdraw() {
    this.router.navigate(['/savings/withdraw']);
  }

  menu() {
    this.router.navigate(['/menu']);
  }

}
