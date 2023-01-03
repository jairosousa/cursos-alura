import { Directive, ElementRef, HostListener, Renderer, Input, OnInit } from '@angular/core';
import { PlatformDetectorService } from '../../../core/plataform-detector/platform-detector.service';
import { element } from 'protractor';

@Directive({
    selector: '[immediateClick]'
})
export class ImmediateClickDirective implements OnInit {

    constructor(
        private el: ElementRef<any>,
        private platFormDetector: PlatformDetectorService,
        private render: Renderer
    ) {
    }

    ngOnInit(): void {
        this.platFormDetector.isPlatformBrowser &&
            this.el.nativeElement.click();

    }

}