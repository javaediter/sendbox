import { Component } from '@angular/core';
import { PublisherComponent } from './components/publisher/publisher.component';

@Component({
  selector: 'app-root',
  imports: [PublisherComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'sendbox';
}
