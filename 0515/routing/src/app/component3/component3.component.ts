import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-component3',
  imports: [],
  templateUrl: './component3.component.html',
  styleUrl: './component3.component.scss'
})
export class Component3Component {

  constructor(private route: ActivatedRoute) { }

  id: string = "";

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
  }
}
