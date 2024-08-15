import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetEveryTicketComponent } from './get-every-ticket.component';

describe('GetEveryTicketComponent', () => {
  let component: GetEveryTicketComponent;
  let fixture: ComponentFixture<GetEveryTicketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetEveryTicketComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetEveryTicketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
