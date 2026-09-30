import { Component } from '@angular/core';
import { Letter } from '../../../models/Letter';
import { FormsModule } from '@angular/forms';
import { PublisherService } from '../../services/publisher.service';

@Component({
  selector: 'app-publisher',
  imports: [FormsModule],
  templateUrl: './publisher.component.html',
  styleUrl: './publisher.component.css'
})
export class PublisherComponent {
  cities = ['---', 'Quito', 'Lima', 'Bogotá', 'New York', 'Tokio'];
  message!: Letter;
  resp$!: any;

  constructor(private pubService: PublisherService){
    this.message = new Letter(this.cities[0], '', '', '');
  }

  changeCity(event: Event): void{
    const selectValue = event.target as HTMLSelectElement;
    this.message.city = selectValue.value;
  }

  sendLetter(){
    console.log('sending...');
    this.resp$ = this.pubService.postMessage(this.message);
    console.log(this.resp$);
    this.message = new Letter(this.cities[0], '', '', '');
    setTimeout(() => {
      this.resp$ = false;
    }, 5000);
  }
}
