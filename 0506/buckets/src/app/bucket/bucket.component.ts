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
}
