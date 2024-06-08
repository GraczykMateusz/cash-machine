import { Component, computed, inject, Signal } from '@angular/core';
import { LoadingSpinnerComponent } from '../common/loading-spinner/loading-spinner.component';
import { UserContactsService } from '../account/ui/contacts/data/user-contacts.service';
import { UsersFilterService } from '../account/ui/contacts/ui/hamburger-options/ui/user-contacts-filter/data/users-filter.service';
import { AllUserContacts } from '../account/ui/contacts/data/all-user-contacts';
import { UserContact } from '../account/ui/contacts/data/user-contact';
import { pulse } from 'ng-animate';
import { state, style, transition, trigger, useAnimation } from '@angular/animations';
import { State } from './data/icon-animation-state';
import { IconAnimation } from './data/icon-animation';

@Component({
  selector: 'app-contacts',
  standalone: true,
  imports: [
    LoadingSpinnerComponent
  ],
  templateUrl: './contacts.component.html',
  styleUrl: './contacts.component.scss',
  animations: [
    trigger('pulse', [
      state(State.VOID, style({opacity: '1'})),
      state(State.ACTIVE, style({opacity: '1'})),
      state(State.INACTIVE, style({opacity: '1'})),
      transition(
        State.ACTIVE + ' => ' + State.INACTIVE,
        useAnimation(pulse, {params: {timing: 1}}))
    ])
  ]
})
export class ContactsComponent {
  
  private readonly contactsService: UserContactsService = inject(UserContactsService);
  private readonly userFilter: UsersFilterService = inject(UsersFilterService);
  
  readonly allUserContacts: Signal<AllUserContacts | undefined> = this.contactsService.allUserContacts;
  readonly userContacts: Signal<UserContact[] | undefined> = computed(() => {
    return this.userFilter.filter(this.allUserContacts());
  });
  
  readonly animations: IconAnimation[] = new Array<IconAnimation>();
  
  readonly editPostfix: string = '-edit';
  readonly deletePostfix: string = '-delete';
  
  onDone(ref: string): void {
    const animation: IconAnimation = this.getAnimation(ref)!;
    
    if (animation.state === State.VOID) {
      animation.canBeActive = true;
      
    } else if (animation.mouseEnter) {
      animation.canBeActive = false;
      animation.state = animation.state === State.ACTIVE ? State.INACTIVE : State.ACTIVE;
      
    } else if (!animation.mouseEnter) {
      animation.canBeActive = false;
      animation.state = State.VOID;
    }
  }
  
  onMouseEnter(ref: string) {
    const animation: IconAnimation | undefined = this.getAnimation(ref);
    if (animation === undefined) {
      this.animations.push({ref: ref, state: State.ACTIVE, canBeActive: false, mouseEnter: true});
    } else {
      animation.mouseEnter = true;
      if (animation.canBeActive) {
        animation.state = State.ACTIVE;
      }
    }
  }
  
  onMouseLeave(ref: string) {
    const animation: IconAnimation = this.getAnimation(ref)!;
    animation.mouseEnter = false;
  }
  
  getAnimationState(ref: string): State {
    console.log(ref);
    const iconAnimation: IconAnimation | undefined = this.getAnimation(ref);
    if (iconAnimation) {
      return iconAnimation.state;
    }
    this.animations.push({ref: ref, state: State.VOID, canBeActive: true, mouseEnter: false});
    return State.VOID;
  }
  
  private getAnimation(ref: string): IconAnimation | undefined {
    return this.animations
      .filter((animation: IconAnimation) => animation.ref === ref)
      .at(0);
  }
}
