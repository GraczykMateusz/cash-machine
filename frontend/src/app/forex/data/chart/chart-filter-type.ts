const ChartFilterTypes = {
  LAST_10M: 'LAST_10M',
  LAST_24H: 'LAST_24H',
  TODAY: 'TODAY'
} as const;

export type ChartFilterType = typeof ChartFilterTypes[keyof typeof ChartFilterTypes];
