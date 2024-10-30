import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideHttpClient } from '@angular/common/http';
import { provideFirebaseApp, initializeApp } from '@angular/fire/app';
import { getAuth, provideAuth } from '@angular/fire/auth';
import { Auth } from '@angular/fire/auth';
import { DatePipe } from '@angular/common';


export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideAnimationsAsync(),
    provideHttpClient(),
    provideFirebaseApp(() => initializeApp({
      apiKey: "AIzaSyDrLednTgPG3EvmHjUAES5kChUjqZVR7dk",
      authDomain: "factu-29280.firebaseapp.com",
      projectId: "factu-29280",
      storageBucket: "factu-29280.appspot.com",
      messagingSenderId: "289087597581",
      appId: "1:289087597581:web:0065b30ff8998e650ff944"
     })),
    provideAuth(() => getAuth()),
    DatePipe
  ]
};
