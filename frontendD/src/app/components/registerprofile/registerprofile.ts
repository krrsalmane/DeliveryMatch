import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

interface RegisterRequest {
  nom: string;
  prenom: string;
  email: string;
  password: string;
}

interface User {
  id?: number;
  nom: string;
  prenom: string;
  email: string;
  password: string;
  role?: string;
}

@Component({
  selector: 'app-registerprofile',
  standalone: true,
  templateUrl: './registerprofile.html',
  styleUrl: './registerprofile.css',
  imports: [FormsModule, HttpClientModule, CommonModule],
})
export class Registerprofile {
  registerRequest: RegisterRequest = {
    nom: '',
    prenom: '',
    email: '',
    password: ''
  };
  selectedRole: string = 'expediteur'; // Default role
  errorMessage: string | null = null;

  constructor(private http: HttpClient) {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      const requestData = { ...this.registerRequest, };

      this.http.post<User>(`http://localhost:8183/api/auth/register/${this.selectedRole}`, requestData).subscribe({
        next: (response) => {
          console.log('User registered:', response);
          this.resetForm();
        },
        error: (error) => {
          const errorMsg = error.error?.error || error.error?.message || error.statusText || 'Unknown error';

          if (error.status === 400 || error.status === 500) {
            this.errorMessage = errorMsg.toLowerCase().includes('email already registered')
              ? 'Error: Email already registered. Please use a different email.'
              : `Error: ${error.status} - ${errorMsg}. URL: ${error.url}. Check server logs.`;
          } else {
            this.errorMessage = `Error: ${error.status} - ${errorMsg}. URL: ${error.url}. Ensure the server is running on port 8183.`;
          }

          console.error('Error details:', error);
        }
      });
    }
  }

  private resetForm() {
    this.registerRequest = {
      nom: '',
      prenom: '',
      email: '',
      password: ''
    };
    this.selectedRole = 'expediteur';
    this.errorMessage = null;
  }
}
