export const State = {
  VOID: 'VOID',
  ACTIVE: 'ACTIVE',
  INACTIVE: 'INACTIVE'
} as const;

export type State = typeof State[keyof typeof State];