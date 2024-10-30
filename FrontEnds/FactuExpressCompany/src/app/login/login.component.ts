import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ServiceService } from '../service.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule, RouterLink, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm = this.fb.group({
    user: ['', [Validators.required]],
    password: ['', [Validators.required, Validators.minLength(6)]]
  });

  constructor(private fb: FormBuilder, private service: ServiceService, private router: Router) { }

  onSubmit() {
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
      this.service.postlogin(this.loginForm.value).subscribe(
        (respuesta) => {
          console.log(respuesta.token)
          localStorage.setItem('token', respuesta.token);
          localStorage.setItem('id', respuesta.idCompany)
          this.router.navigate(['/dashboard']);
        },
        (error) => {
          console.log("Error en las credenciales")
        }
      );
    } else {
      this.loginForm.markAllAsTouched();
    }
  }

  get user() { return this.loginForm.get('user'); }
  get password() { return this.loginForm.get('password'); }
}
