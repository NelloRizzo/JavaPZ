import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PromiseSampleService {

  constructor() { }

  getData(): Promise<string> {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('Data loaded successfully!');
      }, 5000); // Simulate a 5-second delay
    });
  }
}
