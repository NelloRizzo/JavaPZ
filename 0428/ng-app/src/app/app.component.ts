import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BindColorComponent } from './bind-color/bind-color.component';
import { ComponentRefComponent } from './component-ref/component-ref.component';
import { StructuralSampleComponent } from './structural-sample/structural-sample.component';
import { CustomPipeComponent } from './custom-pipe/custom-pipe.component';

@Component({
  selector: 'app-root',
  imports: [CustomPipeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Sample Application';
}
