declare module '@apiverve/useragentparser' {
  export interface useragentparserOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface useragentparserResponse {
    status: string;
    error: string | null;
    data: UserAgentParserData;
    code?: number;
  }


  interface UserAgentParserData {
      ua:      string;
      browser: Browser;
      engine:  Engine;
      os:      Engine;
      device:  CPU;
      cpu:     CPU;
  }
  
  interface Browser {
      name:    string;
      version: string;
      major:   string;
  }
  
  interface CPU {
  }
  
  interface Engine {
      name:    string;
      version: string;
  }

  export default class useragentparserWrapper {
    constructor(options: useragentparserOptions);

    execute(callback: (error: any, data: useragentparserResponse | null) => void): Promise<useragentparserResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: useragentparserResponse | null) => void): Promise<useragentparserResponse>;
    execute(query?: Record<string, any>): Promise<useragentparserResponse>;
  }
}
