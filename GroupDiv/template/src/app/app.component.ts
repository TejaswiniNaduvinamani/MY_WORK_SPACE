import { Component, OnInit, DoCheck, ViewEncapsulation } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None,
  // styles: [`
  //   .my-custom-class .tooltip-inner {
  //     background-color: darkgreen;
  //     font-size: 125%;
  //     width: 400px;
  //   }
  //   .my-custom-class .arrow::before {
  //     border-top-color: darkgreen;
  //   }
  // `]
})
export class AppComponent implements OnInit, DoCheck {
  title = 'app';
  public isCollapsable = true;
  public isCollapsable2 = true;
  public imageDir = '../../../';
  rowsControls = [];
  public userName: string;
  public isUserNameEmpty = false;
  public toggleButton = false;
  public logInt = 0;
  closeResult: string;

  hideText = false;

  constructor(private modalService: NgbModal) {}
  logs = [];

  groups = [{
    id: 'Active',
    name: 'First row',
    isCollapsable2: true
  }, {
    id: 'Cobra',
    name: 'Second row',
    isCollapsable2: true
  }, {
    id: 'Retiree',
    name: 'Third row',
    isCollapsable2: true
  }];

  ngOnInit() {
    this.groups.forEach(row => {
      this.rowsControls.push({
        isCollapsed: true
      });
    });
  }

  ngDoCheck() {
    if (this.userName === '' || this.userName === undefined || this.userName === null) {
      this.isUserNameEmpty = true;
    } else {
      this.isUserNameEmpty = false;
    }
  }

onClick() {
console.log('clickable icon');
}
  toggle() {
    this.isCollapsable = (!this.isCollapsable);
  }
  toggle2(group) {
    group.isCollapsable2 = (!group.isCollapsable2);
  }

  OnResetUserName() {
    this.userName = '';
  }

  onToggle() {
    this.toggleButton = !this.toggleButton;
  }


  onClickDisplay() {
    this.logs.push(this.logInt++);
  }
  getColor(log) {
    return log >= 5 ? 'blue' : 'white';
  }
  open(content) {
    // $('#content').modal('show');
    this.modalService.open(content);
  }

  onMouseOut(t2) {
 console.log('On focus out method is called');
 t2.close();
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

}

