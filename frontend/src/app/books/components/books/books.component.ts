import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss'],
})
export class BooksComponent implements OnInit {
  form = new FormGroup({
    title: new FormControl('', [Validators.required]),
    author: new FormControl('', [Validators.required]),
  });

  constructor() {}

  ngOnInit(): void {}

  onSubmit(): void {
    if (this.form.invalid) {
      return;
    }
    console.log('opaaaaa');
    // crack an egg or split a nut
  }
}
