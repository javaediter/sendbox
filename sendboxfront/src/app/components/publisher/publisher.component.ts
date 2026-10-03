import { Component } from '@angular/core';
import { Letter } from '../../../models/Letter';
import { FormsModule } from '@angular/forms';
import { PublisherService } from '../../services/publisher.service';
import { SubcriberComponent } from '../subcriber/subcriber.component';

@Component({
  selector: 'app-publisher',
  imports: [FormsModule, SubcriberComponent],
  templateUrl: './publisher.component.html',
  styleUrl: './publisher.component.css'
})
export class PublisherComponent {
  cities = ['---', 'Quito', 'Lima', 'Bogotá', 'New York', 'Tokio'];
  message!: Letter;
  sended!: any;

  constructor(private pubService: PublisherService){
    this.message = new Letter(this.cities[0], '', '', '');
  }

  changeCity(event: Event): void{
    const selectValue = event.target as HTMLSelectElement;
    this.message.city = selectValue.value;
  }

  sendLetter(){
    console.log('sending...');

    this.pubService.postMessage(this.message)
    .subscribe({
      next: (response) => {
        this.sended = response;
      },
      error: (error) => {
        console.log('ERROR ', error);
      }
    });

    this.message = new Letter(this.cities[0], '', '', '');
    setTimeout(() => {
      this.sended = false;
    }, 5000);
  }
}
