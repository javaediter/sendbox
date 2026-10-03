import { Component } from '@angular/core';
import { PublisherService } from '../../services/publisher.service';
import { Envelope } from '../../../models/Envelope';
import { Letter } from '../../../models/Letter';

@Component({
  selector: 'app-subcriber',
  imports: [],
  templateUrl: './subcriber.component.html',
  styleUrl: './subcriber.component.css'
})
export class SubcriberComponent {
  authors!: Array<string>;
  envelopes!: Array<Envelope>;
  message!: Letter;
  authorSelected!:string;

  constructor(private pubService: PublisherService){}

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

  getFilesByAuthor(author:string): void {
    this.envelopes = [];
    this.message = new Letter('', '', '', '');
    this.authorSelected = author;
    this.pubService.getFilesByAuthor(author)
    .subscribe({
      next: (response) => {
        this.envelopes = response;        
      },
      error: (error) => {
        console.log('ERROR: ', error);
      }
    });
  }

  getContentFile(fileName: string): void {
    this.pubService.getContentFile(this.authorSelected, fileName)
    .subscribe({
      next: (response) => {
        this.message = response;
      },
      error: (error) => {
        console.log('ERROR: ', error);
      }
    });
  }

}
