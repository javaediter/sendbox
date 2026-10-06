import { Component } from '@angular/core';
import { PublisherService } from '../../services/publisher.service';
import { Envelope } from '../../../models/Envelope';

@Component({
  selector: 'app-subcriber',
  imports: [],
  templateUrl: './subcriber.component.html',
  styleUrl: './subcriber.component.css'
})
export class SubcriberComponent {
  authors!: Array<string>;
  envelopes!: Array<Envelope>;
  contentFile!: any;
  authorSelected!:string;
  fileNameSelected!:string;

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
    this.contentFile = null;
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
    this.fileNameSelected = fileName;
    this.pubService.getContentFile(this.authorSelected, fileName)
    .subscribe({
      next: (response) => {
        this.contentFile = response;
      },
      error: (error) => {
        console.log('ERROR: ', error);
      }
    });
  }

  downloadFileTxt() : void{
    const blob = new Blob([
      this.contentFile.content
    ], {
      type: 'text/plain;charset=utf-8'
    });

    const url = window.URL.createObjectURL(blob);

    const enlace = document.createElement('a');
    enlace.href = url;
    enlace.download = this.fileNameSelected;
    enlace.click();

    window.URL.revokeObjectURL(url);
  }

}
