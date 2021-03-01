import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SessionDetails } from '../model/session';
import { SessionDetailsService } from '../service/sessionService';

import { MatDialogRef } from '@angular/material/dialog';
import { SessiondetailsComponent } from '../sessiondetails/sessiondetails.component';

@Component({
  selector: 'app-addsession',
  templateUrl: './addsession.component.html',
  styleUrls: ['./addsession.component.css'],
})
export class AddsessionComponent implements OnInit {
  sessionForm: FormGroup;
  constructor(
    private sessiondetailsService: SessionDetailsService,
    private dialogRef: MatDialogRef<SessiondetailsComponent>
  ) {}

  ngOnInit(): void {
    this.sessionForm = new FormGroup({
      sessionName: new FormControl('', Validators.required),
      instructorName: new FormControl(''),
      description: new FormControl(''),
      date: new FormControl(''),
    });
  }

  get sessionName() {
    return this.sessionForm.get('sessionName') as FormControl;
  }

  get instructorName() {
    return this.sessionForm.get('instructorName') as FormControl;
  }
  get description() {
    return this.sessionForm.get('description') as FormControl;
  }

  get date() {
    return this.sessionForm.get('date') as FormControl;
  }

  addToList() {
    const toDo: SessionDetails = {
      sessionName: this.sessionName.value,
      instructorName: this.instructorName.value,
      description: this.description.value,
      date: new Date(this.date.value),
    };
    this.sessiondetailsService.addsession(toDo);
    alert('New Session Added to the List.');
    this.dialogRef.close();
  }
}
