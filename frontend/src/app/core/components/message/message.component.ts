import { Component, OnInit } from '@angular/core';
import { MessageService } from '../../services/message.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-message',
  template: ``,
})
export class MessageComponent implements OnInit {
  constructor(
    public messageService: MessageService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit(): void {
    this.getMessage();
  }

  getMessage(): void {
    this.messageService
      .get()
      .subscribe((message) => this.showSnackBar(message));
  }

  private showSnackBar(message: string) {
    if (message) {
      let snackBarRef = this.snackBar.open(message, 'Ok');

      snackBarRef.onAction().subscribe(() => {
        this.messageService.set('');
      });
    }
  }
}
