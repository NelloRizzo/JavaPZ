import { DatePipe, NgClass, NgFor, NgIf, UpperCasePipe } from '@angular/common';
import { Component } from '@angular/core';
import { HighlightDirective } from '../highlight.directive';

@Component({
  selector: 'app-structural-sample',
  imports: [NgFor, NgIf, NgClass, HighlightDirective, UpperCasePipe, DatePipe],
  templateUrl: './structural-sample.component.html',
  styleUrl: './structural-sample.component.css'
})
export class StructuralSampleComponent {
  items = Array.from({ length: 10 }, (_, i) => `Item ${i + 1}`);
  now: Date = new Date();
}
