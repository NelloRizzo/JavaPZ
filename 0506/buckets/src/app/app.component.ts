import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BucketComponent } from './bucket/bucket.component';
import { Bucket } from './state/bucket';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, BucketComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Buckets';
  b1 = new Bucket(100, "Secchio 100lt");
  b2 = new Bucket(50, "Secchio 50lt");

  add(b: Bucket) {
    b.add(1)
  }
  empty(b: Bucket) {
    b.empty()
  }
  fill(b: Bucket) {
    b.fill()
  }
  transfer(b1: Bucket, b2: Bucket) {
    b1.transfer(b2)
  }
}
