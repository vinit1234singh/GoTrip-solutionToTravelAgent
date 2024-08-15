import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserBuyPackageComponent } from './user-buy-package.component';

describe('UserBuyPackageComponent', () => {
  let component: UserBuyPackageComponent;
  let fixture: ComponentFixture<UserBuyPackageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserBuyPackageComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserBuyPackageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
