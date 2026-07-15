declare module '@apiverve/useragentparser' {
  export interface useragentparserOptions {
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

  export interface useragentparserResponse {
    status: string;
    error: string | null;
    data: UserAgentParserData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface UserAgentParserData {
      ua:       null | string;
      browser:  Browser;
      engine:   Engine;
      os:       Engine;
      device:   CPU;
      cpu:      CPU;
      isMobile: boolean | null;
      isBot:    boolean | null;
      summary:  null | string;
  }
  
  interface Browser {
      name:    null | string;
      version: null | string;
      major:   null | string;
  }
  
  interface CPU {
  }
  
  interface Engine {
      name:    null | string;
      version: null | string;
  }

  export default class useragentparserWrapper {
    constructor(options: useragentparserOptions);

    execute(callback: (error: any, data: useragentparserResponse | null) => void): Promise<useragentparserResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: useragentparserResponse | null) => void): Promise<useragentparserResponse>;
    execute(query?: Record<string, any>): Promise<useragentparserResponse>;
  }
}
