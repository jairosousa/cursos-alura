import { Component, OnInit, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { PhotoCommnet } from '../../photo/photo-comments';
import { PhotoService } from '../../photo/photo.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { switchMap, tap } from 'rxjs/operators';
import { AlertService } from '../../../shared/components/alert/alert.service';

@Component({
  selector: 'ap-photo-comments',
  templateUrl: './photo-comments.component.html',
  styleUrls: ['./photo-comments.component.css']
})
export class PhotoCommentsComponent implements OnInit {

  @Input() photoId: number;

  commentForm: FormGroup;

  comments$: Observable<PhotoCommnet[]>;

  constructor(
    private photoService: PhotoService,
    private formBuilder: FormBuilder,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.comments$ = this.photoService.getCommnet(this.photoId);
    this.commentForm = this.formBuilder.group({
      comment: ['', Validators.maxLength(300)]
    });
  }

  save() {
    const comment = this.commentForm.get('comment').value as string;
    this.comments$ = this.photoService.addComment(this.photoId, comment)
      .pipe(switchMap(() => this.photoService.getCommnet(this.photoId)))
      .pipe(tap(() => {
        this.commentForm.reset();
        this.alertService.success('Comentario adicionado com sucesso', true);
      }))



  }

}
