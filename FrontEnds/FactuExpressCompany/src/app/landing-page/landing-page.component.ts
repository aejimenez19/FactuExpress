import { Component, inject } from '@angular/core';
import { Router, RouterLink, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './landing-page.component.html',
  styleUrl: './landing-page.component.css'
})
export class LandingPageComponent {
  private _router = inject(Router);

  navigateToRegister(): void {
    if (this._router) {
      console.log('Navegando a registro...');
      this._router.navigate(['/login']);
    } else {
      console.error('Router no está disponible');
    }
  }
}



