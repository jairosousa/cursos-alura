import { Component, Input } from '@angular/core';
import { environment } from '../../../environments/environment';

const API = environment.ApiUrl;
const CLOUND = API + '/imgs/'
@Component({
    selector: 'ap-photo',
    templateUrl: 'photo.component.html'
})
export class PhotoComponent {

    private _url = '';

    @Input() description = ''; d

    @Input() set url(url: string) {
        if (!url.startsWith('data')) {
            this._url = CLOUND + url;
        } else {
            this._url = url;
        }
    };

    get url() {
        return this._url;
    }
}