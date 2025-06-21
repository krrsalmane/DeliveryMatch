import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

interface AnnonceRequest {
  conducteurId: number;
  pointDepart: string;
  destinationFinal: string;
  dateDepart: string;
  capaciteDisponible: number;
  typeMarchandise: string;
}

interface Annonce {
  id?: number;
  pointDepart: string;
  destinationFinal: string;
  dateDepart: string;
  capaciteDisponible: number;
  typeMarchandise: string;
  conducteurId: number;
}

@Component({
  selector: 'app-createannonce',
  standalone: true,
  templateUrl: './createannonce.html',
  styleUrl: './createannonce.css',
  imports: [FormsModule, HttpClientModule, CommonModule],
})
export class Createannonce {
  annonceRequest: AnnonceRequest = {
    conducteurId: 0,
    pointDepart: '',
    destinationFinal: '',
    dateDepart: '',
    capaciteDisponible: 0,
    typeMarchandise: ''
  };
  errorMessage: string | null = null;

  constructor(private http: HttpClient) {}

  onSubmit(form: NgForm) {
    if (form.valid) {
      this.http.post<Annonce>('http://localhost:8183/api/annonces/publier', this.annonceRequest).subscribe({
        next: (response) => {
          console.log('Announcement created:', response);
          this.resetForm();
        },
        error: (error) => {
          let errorMsg = error.error?.error || error.error?.message || error.statusText || 'Unknown error';
          if (error.status === 500 && (errorMsg.toLowerCase().includes('conducteur') || errorMsg.toLowerCase().includes('conductor'))) {
            this.errorMessage = 'Error: Conductor not found. Please verify the Conductor ID.';
          } else {
            this.errorMessage = `Error: ${error.status} - ${errorMsg}. URL: ${error.url}. Ensure the server is running on port 8183 and check backend logs.`;
          }
          console.error('Error details:', error);
        }
      });
    }
  }

  private resetForm() {
    this.annonceRequest = {
      conducteurId: 0,
      pointDepart: '',
      destinationFinal: '',
      dateDepart: '',
      capaciteDisponible: 0,
      typeMarchandise: ''
    };
    this.errorMessage = null;
  }
}