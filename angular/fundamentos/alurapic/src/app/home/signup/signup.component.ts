import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { lowerCaseValidator } from '../../shared/validators/lower-case.validator';
import { NewUser } from './newUser';
import { SignupService } from './signup.service';
import { UserNotTakenValidadorService } from './user-not-taken.validador.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private userNotTakenValidadorService: UserNotTakenValidadorService,
    private signupService: SignupService,
    private router: Router) { }

  ngOnInit() {

    this.signupForm = this.formBuilder.group({
      email: ['', [
        Validators.required,
        Validators.email
      ]],
      fullName: ['', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(40)
      ]],
      userName: ['', [
        Validators.required,
        Validators.minLength(2),
        Validators.maxLength(30),
        lowerCaseValidator
      ],
        this.userNotTakenValidadorService.checkUserNameTaken()
      ],
      password: ['']
    });
  }

  signup() {
    const newUser = this.signupForm.getRawValue() as NewUser;
    this.signupService
      .signup(newUser)
      .subscribe(
        () => this.router.navigate(['']),
        err => console.log(err)
      );
  }

}
