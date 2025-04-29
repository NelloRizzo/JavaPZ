import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-typicode',
  imports: [],
  templateUrl: './typicode.component.html',
  styleUrl: './typicode.component.scss'
})
export class TypicodeComponent {

  data?: string;

  constructor(private http: HttpClient) { }

  async ngOnInit() {
    // Pattern Promise
    // fetch('https://jsonplaceholder.typicode.com/users/8')
    //   .then(response => response.json())
    //   .then(json => {
    //     console.log(json)
    //     this.data = JSON.stringify(json)
    //   })
    //  .catch(e => {
    //    console.error('Error loading data:', e);
    //  })

    // Pattern async/await
    //  try {
    //    let response = await fetch('https://jsonplaceholder.typicode.com/users/8')
    //    let json = await response.json()
    //    console.log(json)
    //    this.data = JSON.stringify(json)
    //  } catch (e) {
    //    console.error('Error loading data:', e);
    //  }

    // Pattern Observable
    this.http.get('https://jsonplaceholder.typicode.com/users/2')
      .subscribe(data => {
          console.log(data)
          this.data = JSON.stringify(data)
        })
  }
}
