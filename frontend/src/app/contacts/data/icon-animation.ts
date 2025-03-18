import { State } from './icon-animation-state';

export type IconAnimation = {
  ref: string;
  state: State;
  mouseEnter: boolean;
  canBeActive: boolean;
}
