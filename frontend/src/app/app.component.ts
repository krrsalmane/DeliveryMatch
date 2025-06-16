import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <main class="container mt-4">
      <router-outlet></router-outlet>
    </main>
  `,
  styles: [`
    main {
      min-height: 100vh;
    }
  `]
})
export class AppComponent {
  title = 'DeliveryMatch';
} 