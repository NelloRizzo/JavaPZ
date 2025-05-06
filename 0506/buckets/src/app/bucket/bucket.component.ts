import { Component, Input } from '@angular/core';
import { Bucket } from '../state/bucket';

@Component({
  selector: 'app-bucket',
  imports: [],
  templateUrl: './bucket.component.html',
  styleUrl: './bucket.component.css'
})
export class BucketComponent {

  @Input()
  bucket?: Bucket

  filling: boolean = false

  startFilling() {
    this.bucket?.add(1)
    if (this.bucket?.isFull) this.filling = false
    if (this.filling)
      setTimeout(() => this.startFilling(), 100);
  }
  startFill() {
    this.filling = true
    this.startFilling()
  }
  stopFill() {
    this.filling = false
  }
}
