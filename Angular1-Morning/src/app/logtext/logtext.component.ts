import { Component, OnInit } from '@angular/core';
import { logItemDetails } from '../model/log';

@Component({
  selector: 'app-logtext',
  templateUrl: './logtext.component.html',
  styleUrls: ['./logtext.component.css'],
})
export class LogtextComponent implements OnInit {
  dataSource: logItemDetails[] = [];
  displayedColumns: string[] = ['text', 'date'];
  constructor() {}

  ngOnInit(): void {}

  onKey(event: any) {
    this.dataSource.push({
      text: event.target.value,
      date: new Date(),
    });
  }
}
