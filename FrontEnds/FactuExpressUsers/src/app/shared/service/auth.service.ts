import { Injectable } from '@angular/core';
import { Auth, signInWithPopup, GoogleAuthProvider } from '@angular/fire/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private Auth: Auth) { }

  login(){
    return signInWithPopup(this.Auth, new GoogleAuthProvider());
  }


}
