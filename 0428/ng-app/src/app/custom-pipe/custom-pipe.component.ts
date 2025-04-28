import { Component } from '@angular/core';
import { ArrayPipe } from '../pipes/array.pipe';
import { NgFor } from '@angular/common';
import { LessPipe } from '../pipes/less.pipe';
import { RangePipe } from '../pipes/range.pipe';

@Component({
  selector: 'app-custom-pipe',
  imports: [ArrayPipe, NgFor, LessPipe, RangePipe],
  templateUrl: './custom-pipe.component.html',
  styleUrl: './custom-pipe.component.css'
})
export class CustomPipeComponent {
  numbers: number[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
}
