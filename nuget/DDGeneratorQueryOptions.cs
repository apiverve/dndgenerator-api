using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.DDGenerator
{
    /// <summary>
    /// Query options for the D&D Generator API
    /// </summary>
    public class DDGeneratorQueryOptions
    {
        /// <summary>
        /// Content type to generate
        /// </summary>
        [JsonProperty("type")]
        public string Type { get; set; }

        /// <summary>
        /// Number of items to generate
        /// </summary>
        [JsonProperty("count")]
        public int? Count { get; set; }
    }
}
