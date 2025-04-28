import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-bind-color',
  imports: [FormsModule],
  templateUrl: './bind-color.component.html',
  styleUrl: './bind-color.component.css'
})
export class BindColorComponent {
  color: string = '#ff0000';
}
