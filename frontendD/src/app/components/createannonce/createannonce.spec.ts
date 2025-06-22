import { ComponentFixture, TestBed } from 

import { Createannonce } from './createannonce';

describe('Createannonce', () => {
  let component: Createannonce;
  let fixture: ComponentFixture<Createannonce>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Createannonce]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Createannonce);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
