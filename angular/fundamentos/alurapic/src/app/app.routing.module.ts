import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './errors/not-found/not-found.component';
import { SigninComponent } from './home/signin/signin.component';
import { PhotoFormComponent } from './photos/photo-form/photo-form.component';
import { PhotoListComponent } from './photos/photo-list/photo-list.component';
import { PhotoListResouver } from './photos/photo-list/photo-list.resolver';

const routes: Routes = [
    { path: '', component: SigninComponent },
    {
        path: 'user/:userName',
        component: PhotoListComponent,
        resolve: {
            photos: PhotoListResouver
        }
    },
    { path: 'p/add', component: PhotoFormComponent },
    { path: '**', component: NotFoundComponent }
]

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }