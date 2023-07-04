import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-current',
  templateUrl: './current.component.html',
  styleUrls: ['./current.component.css'],
})
export class CurrentComponent {
  constructor(public loginService: LoginService, public router: Router) {
    if (this.loginService.currentUser === undefined) {
      this.router.navigate(['/login']);
    }
  }

  open() {
    this.router.navigate(['/current/deposit']);
  }

  deposit() {
    this.router.navigate(['/current/deposit']);
  }

  withdraw() {
    this.router.navigate(['/current/withdraw']);
  }

  menu() {
    this.router.navigate(['/menu']);
  }
}
