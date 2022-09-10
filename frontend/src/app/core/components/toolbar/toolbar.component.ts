import { Component, Renderer2, Input } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.scss'],
})
export class ToolbarComponent {
  @Input() title = '';
  currentRoute: string = '';

  constructor(private renderer: Renderer2, private router: Router) {
    this.router.events.subscribe((event: any) => {
      if (event instanceof NavigationEnd) {
        this.currentRoute = this.router.url;
      }
    });
  }

  ngOnInit(): void {}
}
