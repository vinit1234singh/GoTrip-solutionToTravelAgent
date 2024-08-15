import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetSentMessagesComponent } from './get-sent-messages.component';

describe('GetSentMessagesComponent', () => {
  let component: GetSentMessagesComponent;
  let fixture: ComponentFixture<GetSentMessagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GetSentMessagesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetSentMessagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
