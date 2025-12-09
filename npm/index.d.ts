declare module '@apiverve/dndgenerator' {
  export interface dndgeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface dndgeneratorResponse {
    status: string;
    error: string | null;
    data: D&DGeneratorData;
    code?: number;
  }


  interface DDGeneratorData {
      type:    string;
      count:   number;
      results: Results;
  }
  
  interface Results {
      name:       string;
      race:       string;
      class:      string;
      level:      number;
      background: string;
      alignment:  string;
      stats:      Stats;
      hitPoints:  number;
  }
  
  interface Stats {
      strength:     number;
      dexterity:    number;
      constitution: number;
      intelligence: number;
      wisdom:       number;
      charisma:     number;
  }

  export default class dndgeneratorWrapper {
    constructor(options: dndgeneratorOptions);

    execute(callback: (error: any, data: dndgeneratorResponse | null) => void): Promise<dndgeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: dndgeneratorResponse | null) => void): Promise<dndgeneratorResponse>;
    execute(query?: Record<string, any>): Promise<dndgeneratorResponse>;
  }
}
