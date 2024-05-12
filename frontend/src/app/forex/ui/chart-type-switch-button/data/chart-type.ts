const ChartTypes = {
  EURPLN: 'EURPLN',
  USDPLN: 'USDPLN',
} as const;

export type ChartType = typeof ChartTypes[keyof typeof ChartTypes];
