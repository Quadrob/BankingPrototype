import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(public loginService: LoginService, public router: Router) {
    if (this.loginService.currentUser === undefined) {
      this.router.navigate(['/login']);
    }
  }

  savings() {
    this.router.navigate(['/savings']);
  }

  current() {
    this.router.navigate(['/current']);
  }

  logout() {
    this.loginService.currentUser = undefined;
    this.router.navigate(['/login']);
  }
}
