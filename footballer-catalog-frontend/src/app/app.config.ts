import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';
import { RxStompService } from './service/rx-stomp.service';
import { rxStompServiceFactory } from './service/rx-stomp-service-factory';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes), 
    provideHttpClient(),
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory
    }
  ]
};
