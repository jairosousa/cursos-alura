import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PhotoService } from '../photo/photo.service';
import { Photo } from '../photo/photo';
import { Subject, Observable } from 'rxjs';
import { PhotoCommnet } from '../photo/photo-comments';
import { AlertService } from '../../shared/components/alert/alert.service';
import { UserService } from '../../core/user/user.service';

@Component({
  templateUrl: './photo-details.component.html',
  styleUrls: ['./photo-details.component.css']
})
export class PhotoDetailsComponent implements OnInit {

  photo$: Observable<Photo>;
  comments$: Observable<PhotoCommnet[]>;

  photoId: number;

  constructor(
    private route: ActivatedRoute,
    private photoService: PhotoService,
    private router: Router,
    private alertService: AlertService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.photoId = this.route.snapshot.params.photoId;
    this.photo$ = this.photoService.findById(this.photoId);
    this.photo$.subscribe(() => { }, err => {
      console.log(err);
      this.router.navigate(['not-found']);

    })
    this.comments$ = this.photoService.getCommnet(this.photoId)

  }

  remove() {
    this.photoService.removePhoto(this.photoId)
      .subscribe(() => {
        this.alertService.success("Photo removed", true);
        this.router.navigate(['/user', this.userService.getUserName()])
      },
        err => {
          console.log(err);
          this.alertService.danger('Could not delete the photo', true);
        }
      );
  }

}
