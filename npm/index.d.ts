declare module '@apiverve/dndgenerator' {
  export interface dndgeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface dndgeneratorResponse {
    status: string;
    error: string | null;
    data: DDGeneratorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface DDGeneratorData {
      type:    null | string;
      count:   number | null;
      results: Results;
  }
  
  interface Results {
      name:       null | string;
      race:       null | string;
      class:      null | string;
      level:      number | null;
      background: null | string;
      alignment:  null | string;
      stats:      Stats;
      hitPoints:  number | null;
  }
  
  interface Stats {
      strength:     number | null;
      dexterity:    number | null;
      constitution: number | null;
      intelligence: number | null;
      wisdom:       number | null;
      charisma:     number | null;
  }

  export default class dndgeneratorWrapper {
    constructor(options: dndgeneratorOptions);

    execute(callback: (error: any, data: dndgeneratorResponse | null) => void): Promise<dndgeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: dndgeneratorResponse | null) => void): Promise<dndgeneratorResponse>;
    execute(query?: Record<string, any>): Promise<dndgeneratorResponse>;
  }
}
