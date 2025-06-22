import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Createannonce } from './components/createannonce/createannonce';
import { Registerprofile } from './components/registerprofile/registerprofile';

@Component({
  selector: 'app-root',
  standalone: true, 
  imports: [RouterOutlet, Createannonce, Registerprofile], 
  templateUrl: './app.html',
  styleUrls: ['./app.css'] 
})
export class AppComponent {
  protected title = 'frontendD';
}