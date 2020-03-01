import { Component, OnInit, Input } from '@angular/core';
import {Chart} from 'chart.js';
import { Data } from './Data';

@Component({
  selector: 'app-login-sucess',
  templateUrl: './login-sucess.component.html',
  styleUrls: ['./login-sucess.component.css']
})
export class LoginSucessComponent implements OnInit {
@Input()user: string;

// data: Data[];
month = ['jan', 'feb', 'march', 'april', 'may', 'june', 'july', 'august', 'sept', 'oct', 'nov', 'dec'];
price = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120];
chart = [];
  constructor() { }

  ngOnInit() {
    this.chart = new Chart('canvas', {
      type: 'bar',
      data: {
        labels: this.month,
        datasets: [
          {
            data: this.price,
            backgroundColor: [
              'rgba(54, 162, 235, 1)',
              'rgba(255, 99, 132, 1)',
              'rgba(255, 206, 86, 1)',
              'rgba(75, 192, 192, 1)',
              'rgba(153, 102, 255, 1)',
              'rgba(230, 25, 75, 1)',
              'rgba(60, 180, 75, 1)',
              'rgba(245, 130, 48, 1)',
              'rgba(145, 30, 180, 1)',
              'rgba(210, 245, 60, 1)',
              'rgba(0, 128, 128, 1)',
              'rgba(128, 0, 0, 1)'
             ],
            fill: true,
            lineTension: 0.2,
          borderWidth: 1
          }
        ]
      },
      options: {
        responsive: true,
        title: {
          text: 'Monthly Users Graph',
          display: true
          },
        legend: {
          display: true,
        },
        scales: {
          xAxes: [{
            display: true
          }],
          yAxes: [{
           // beginAtZero: true,
            display: true
          }],
        }
      }
    });
}

}
