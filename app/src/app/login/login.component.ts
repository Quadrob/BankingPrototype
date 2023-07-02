import { Component } from '@angular/core';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css'],
})
export class LoginComponent {
	username: string = '';
	password: string = '';
	show: boolean = false;
	fail: boolean = false;

    constructor(public loginService: LoginService, public router: Router) { }

    submit() {
    const user = {
        "name": this.username,
        "password": this.password
    }
    this.loginService.getUser(user).subscribe(appUser => {
        if (appUser) {
            this.show = true;
            this.loginService.currentUser = appUser
            this.router.navigate(['/menu']);
        } else {
            this.fail = true;
        }
    })
	}

}
