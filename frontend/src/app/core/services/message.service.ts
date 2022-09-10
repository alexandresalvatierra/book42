import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  private message = new BehaviorSubject<string>('');

  set(message: string): void {
    this.message.next(message);
  }

  get(): Observable<string> {
    return this.message.asObservable();
  }
}
