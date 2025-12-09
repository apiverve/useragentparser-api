using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.UserAgentParser
{
    /// <summary>
    /// Query options for the User Agent Parser API
    /// </summary>
    public class UserAgentParserQueryOptions
    {
        /// <summary>
        /// The user agent string to parse
        /// </summary>
        [JsonProperty("ua")]
        public string Ua { get; set; }
    }
}
