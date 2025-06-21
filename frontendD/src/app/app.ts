import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Createannonce } from './components/createannonce/createannonce';
import { Registerprofile } from './components/registerprofile/registerprofile';


@Component({
  selector: 'app-root',
  imports: [Createannonce,Registerprofile],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'frontendD';
}
