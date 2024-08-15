import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TourPackageCreateComponent } from './tour-package-create.component';

describe('TourPackageCreateComponent', () => {
  let component: TourPackageCreateComponent;
  let fixture: ComponentFixture<TourPackageCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TourPackageCreateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TourPackageCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
