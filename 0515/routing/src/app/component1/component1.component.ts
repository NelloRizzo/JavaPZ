import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-component1',
  imports: [NgFor, RouterLink],
  templateUrl: './component1.component.html',
  styleUrl: './component1.component.scss'
})
export class Component1Component {

  items = Array.from({ length: 10 }, (_, i) => ({ id: i + 1, name: `Item ${i + 1}` }));

}
