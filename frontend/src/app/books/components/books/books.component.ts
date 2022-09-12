import { Component, ViewChild } from '@angular/core';
import {
  FormControl,
  FormGroup,
  FormGroupDirective,
  Validators,
} from '@angular/forms';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Books } from '../../models/books.model';
import { BooksParams, BooksService } from '../../services/books.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.scss'],
})
export class BooksComponent {
  books: Books[] = [];

  form = new FormGroup({
    id: new FormControl(''),
    title: new FormControl('', [Validators.required]),
    author: new FormControl('', [Validators.required]),
  });

  displayedColumns: string[] = [
    'id',
    'title',
    'author',
    'loan',
    'update',
    'delete',
  ];
  dataSource = new MatTableDataSource<Books>([]);

  @ViewChild(MatSort, { static: true }) sort!: MatSort;

  isEditing!: boolean;
  buttonText: string = 'CADASTRAR';

  constructor(private booksService: BooksService) {
    this.get();
  }

  onSubmit(formDirective: FormGroupDirective): void {
    if (this.form.invalid) {
      return;
    }
    if (!this.isEditing) {
      this.save();
    } else {
      this.update();
    }
    formDirective.resetForm();
  }

  save(): void {
    const params: BooksParams = {
      title: this.form.get('title')?.value,
      author: this.form.get('author')?.value,
    };

    this.booksService.create(params).subscribe(
      (values) => {
        this.books.unshift({
          id: values.id,
          title: values.title,
          author: values.author,
          created_at: values.created_at,
        });
        this.setDataSource();
      },
      (err) => console.log(err),
      () => console.log('')
    );
  }

  update(): void {
    const id = this.form.get('id')?.value;
    const params: BooksParams = {
      title: this.form.get('title')?.value,
      author: this.form.get('author')?.value,
    };

    this.booksService.update(id, params).subscribe(
      (values) => {
        const bookIndex = this.books.findIndex((book) => book.id === id);

        this.books[bookIndex].title = params.title;
        this.books[bookIndex].author = params.author;

        this.setDataSource();
      },
      (err) => console.log(err),
      () => console.log('')
    );
  }

  get(): void {
    this.booksService.get().subscribe(
      (values) => {
        const { content } = values;
        this.books = content;
        this.setDataSource();
      },
      (err) => console.log(err),
      () => console.log('')
    );
  }

  onCancel(): void {
    this.form.reset('', { emitEvent: false });

    this.isEditing = false;
    this.buttonText = 'CADASTRAR';
  }

  onDelete(book: Books): void {
    this.booksService.delete(book).subscribe(() => {
      this.books = this.books.filter((p) => p !== book);
      this.onCancel();
      this.setDataSource();
    });
  }

  onUpdate(book: Books): void {
    const { id, title, author } = book;
    this.form.get('id')?.setValue(id);
    this.form.get('title')?.setValue(title);
    this.form.get('author')?.setValue(author);

    this.isEditing = true;
    this.buttonText = 'ATUALIZAR';
  }

  onLoan(book: Books): void {
    alert('WIP');
    console.log(book);
  }

  setDataSource(): void {
    this.dataSource = new MatTableDataSource<Books>(this.books);
    this.dataSource.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
