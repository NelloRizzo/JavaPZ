import { Component } from '@angular/core';
import { HelloService } from '../services/hello.service';

@Component({
  selector: 'app-hello',
  imports: [],
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.scss'
})
export class HelloComponent {

  message?: string;

  constructor(private helloService: HelloService) { }

  ngOnInit() {
    this.helloService.getHello().subscribe(r => this.message = r);
  }
}
