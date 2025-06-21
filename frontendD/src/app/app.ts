import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Createannonce } from './components/createannonce/createannonce';


@Component({
  selector: 'app-root',
  imports: [Createannonce],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontendD';
}
