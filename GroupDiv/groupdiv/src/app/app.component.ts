import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';
  rowsControls = [];
  rows = [{
    id: 0,
    name: 'First row'
  }, {
    id: 1,
    name: 'Second row'
  }, {
    id: 2,
    name: 'Third row'
  }];

  ngOnInit() {
    this.rows.forEach(row => {
      this.rowsControls.push({
        isCollapsed: true
      });
    });
  }
}
