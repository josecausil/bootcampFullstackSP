import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatusTransactionComponent } from './status-transaction.component';

describe('StatusTransactionComponent', () => {
  let component: StatusTransactionComponent;
  let fixture: ComponentFixture<StatusTransactionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StatusTransactionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StatusTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
