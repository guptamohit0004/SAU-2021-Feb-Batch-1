import { Component, OnInit } from '@angular/core';
import { SessionDetails } from '../model/session';
import { SessionDetailsService } from '../service/sessionService';

import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { AddsessionComponent } from '../addsession/addsession.component';

@Component({
  selector: 'app-sessiondetails',
  templateUrl: './sessiondetails.component.html',
  styleUrls: ['./sessiondetails.component.css'],
})
export class SessiondetailsComponent implements OnInit {
  sessionForm: FormGroup;
  selectedSessionItem: SessionDetails;
  editSessionItem: SessionDetails;

  sessionItems: SessionDetails[] = [];

  constructor(
    private sessionService: SessionDetailsService,
    private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.sessionItems = this.sessionService.getsessions().reverse();
    this.sessionForm = new FormGroup({
      sessionName: new FormControl('', Validators.required),
      instructorName: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      date: new FormControl('', Validators.required),
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

  updateSelected(session: SessionDetails) {
    this.selectedSessionItem = session;
    this.editSessionItem = null;
  }
  updateeditSession(session: SessionDetails) {
    this.editSessionItem = session;
    this.selectedSessionItem = null;
  }
  editSession() {
    let editedSession: SessionDetails = {
      sessionName: this.sessionName.value,
      instructorName: this.instructorName.value,
      description: this.description.value,
      date: new Date(this.date.value),
    };
    if (editedSession.sessionName) {
      this.sessionService.editsession(editedSession);
      alert('Session Details Updated');
      this.editSessionItem = null;
      this.selectedSessionItem = null;
      this.sessionForm = new FormGroup({
        sessionName: new FormControl('', Validators.required),
        instructorName: new FormControl('', Validators.required),
        description: new FormControl('', Validators.required),
        date: new FormControl('', Validators.required),
      });
    }
  }
  addsession() {
    this.dialog.open(AddsessionComponent, {
      width: '300px',
    });
  }
  deletesession(session: SessionDetails) {
    this.sessionService.deletesession(session);
    this.sessionItems = this.sessionService.getsessions();
    this.editSessionItem = null;
    this.selectedSessionItem = null;
  }
}
