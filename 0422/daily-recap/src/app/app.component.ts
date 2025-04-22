import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Book } from './book';
import { BookViewComponent } from './book-view/book-view.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, BookViewComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Daily Recap';

  books: Book[] = [
    {
      title: 'Book 1', author: 'Author 1', pages: 100, rating: 4.5, year: 2020
    },
    {
      title: 'Book 2', author: 'Author 2', pages: 123, year: 2018
    }
  ]
}
