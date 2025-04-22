import { Component, Input } from '@angular/core';
import { Book } from '../book';
import { RatingComponent } from '../rating/rating.component';

@Component({
  selector: 'app-book-view',
  imports: [RatingComponent],
  templateUrl: './book-view.component.html',
  styleUrl: './book-view.component.scss'
})
export class BookViewComponent {
  @Input()
  book?: Book
}
