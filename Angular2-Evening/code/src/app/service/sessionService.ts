import { Injectable } from '@angular/core';
import { SessionDetails } from '../model/session';

@Injectable({
  providedIn: 'root',
})
export class SessionDetailsService {
  sessionItems: SessionDetails[] = [
    {
      sessionName: 'Version Control System (VCS)',
      instructorName: 'Biresh Mishra',
      date: new Date('02/10/2021'),
      description: 'Learnt using Github.',
    },
    {
      sessionName: 'RDBMS Concepts',
      instructorName: 'Tarun',
      date: new Date('11-Feb-2021'),
      description: 'Basic RDBMS concepts like Keys,Normalisation.',
    },
    {
      sessionName: 'SQL Concepts & Fundamentals',
      instructorName: 'Santosh Hegde',
      date: new Date('11-Feb-2021'),
      description: 'Practical Hands on experience with Queries',
    },
    {
      sessionName: 'Javascript-1',
      instructorName: 'Rahul Pareek',
      date: new Date('12-Feb-2021'),
      description:
        'Basic concepts of Javascript like promieses, callbacks etc.',
    },
    {
      sessionName: 'Javascript-2',
      instructorName: 'Rahul Pareek',
      date: new Date('12-Feb-2021'),
      description: 'Hands on experience.',
    },
    {
      sessionName: 'HTML5, CSS3',
      instructorName: 'Chandan Chanda',
      date: new Date('15-Feb-2021 '),
      description: 'Learnt all HTML, CSS tags.',
    },
    {
      sessionName: 'NoSQL Basics/Fundamentals',
      instructorName: 'Abhisek Nandan',
      date: new Date('15-Feb-2021 '),
      description: 'Learned couchbase along with maven application',
    },
    {
      sessionName: 'Angular 1',
      instructorName: 'Raviteja V ',
      date: new Date('16-Feb-2021 '),
      description:
        'Basic concepts of Angular like components, directives, and controllers etc.',
    },
    {
      sessionName: 'Angular 2',
      instructorName: 'Santhosh K',
      date: new Date('16-Feb-2021'),
      description: 'Created a Todo Application.',
    },
  ];
  constructor() {}
  getsessions() {
    return this.sessionItems;
  }
  addsession(session: SessionDetails) {
    this.sessionItems.push(session);
  }
  editsession(session: SessionDetails) {
    this.sessionItems.forEach((item, index) => {
      if (item.sessionName == session.sessionName) {
        this.sessionItems[index].sessionName = item.sessionName;
        this.sessionItems[index].date = session.date;
        this.sessionItems[index].description = session.description;
        this.sessionItems[index].instructorName = session.instructorName;
      }
    });
  }
  deletesession(session: SessionDetails) {
    let index = this.sessionItems.indexOf(session);
    this.sessionItems.splice(index, 1);
    alert(`${session.sessionName} Session Deleted`);
  }
}
