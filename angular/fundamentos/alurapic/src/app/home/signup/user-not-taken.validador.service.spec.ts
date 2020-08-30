import { TestBed } from '@angular/core/testing';
import { UserNotTakenValidadorService } from './user-not-taken.validador.service';


describe('UserNotTakenValidadorService', () => {
  let service: UserNotTakenValidadorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserNotTakenValidadorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
