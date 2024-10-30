import { Component } from '@angular/core';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { AuthService } from '../../shared/service/auth.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-aftermain',
  standalone: true,
  imports: [MatSlideToggleModule, MatToolbarModule, MatButtonModule],
  templateUrl: './aftermain.component.html',
  styleUrl: './aftermain.component.css'
})
export class AftermainComponent {
  constructor(private auth:AuthService, private router:Router) {}
  show:any = false
  email:any = '';
  

  login() {
    this.auth.login()
    .then(response => {
      this.email = response.user.email
      localStorage.setItem("Email", this.email)
      this.router.navigate(['/main'])
    })
    .catch(error => {
      console.log(error)
    })
  }

}
