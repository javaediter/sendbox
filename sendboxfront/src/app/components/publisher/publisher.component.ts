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
  authors!: Array<string>;
  message!: Letter;
  sended!: any;

  constructor(private pubService: PublisherService){
    this.message = new Letter(this.cities[0], '', '', '');
  }

  ngOnInit(): void{
    this.pubService.getAuthors()
    .subscribe({
      next: (response) => {
        this.authors = response;
      },
      error: (error) => {
        console.log('ERROR ', error);
      }
    });
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
