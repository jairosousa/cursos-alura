import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Alert, AlertType } from './alert';
import { Router, NavigationStart } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AlertService {

  alertSubject: Subject<Alert> = new Subject<Alert>();
  keepAfterRouteChange = false;

  constructor(
    router: Router
  ) {
    router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        if (this.keepAfterRouteChange) {
          this.keepAfterRouteChange = false;
        } else {
          this.clear();
        }
      }
    })
  }

  private alert(alertType: AlertType, message: string, keepAfterRouteChange: boolean = false) {
    this.keepAfterRouteChange = keepAfterRouteChange;
    this.alertSubject.next(new Alert(alertType, message));
  }

  getAlert() {
    return this.alertSubject.asObservable();
  }

  success(message: string, keepAfterRouteChange: boolean = false) {
    this.alert(AlertType.SUCCESS, message, keepAfterRouteChange)
  }

  warning(message: string, keepAfterRouteChange: boolean = false) {
    this.alert(AlertType.WARNING, message, keepAfterRouteChange)
  }

  danger(message: string, keepAfterRouteChange: boolean = false) {
    this.alert(AlertType.DANGER, message, keepAfterRouteChange)
  }

  info(message: string, keepAfterRouteChange: boolean = false) {
    this.alert(AlertType.INFO, message, keepAfterRouteChange)
  }

  clear() {
    this.alertSubject.next(null);
  }

}
