import { Directive, ElementRef, HostListener, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appToggleVisibility]',
})
export class ToggleVisibilityDirective {

  private isVisible: boolean = false;

  constructor(private el: ElementRef, private renderer: Renderer2) { }

  ngAfterViewInit() {
    this.renderer.addClass(this.el.nativeElement, this.isVisible ? 'visible' : 'hidden');
  }

  @HostListener('click') clickOnElement(){
    this.isVisible = !this.isVisible;
    this.renderer.removeClass(this.el.nativeElement, this.isVisible ? 'hidden' : 'visible');
    this.renderer.addClass(this.el.nativeElement, this.isVisible ? 'visible' : 'hidden');
  }
}
