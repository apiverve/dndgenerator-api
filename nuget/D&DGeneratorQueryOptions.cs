using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.D&DGenerator
{
    /// <summary>
    /// Query options for the D&D Generator API
    /// </summary>
    public class D&DGeneratorQueryOptions
    {
        /// <summary>
        /// Content type: all, character, npc, monster, treasure, encounter, tavern, quest, name
        /// Example: character
        /// </summary>
        [JsonProperty("type")]
        public string Type { get; set; }

        /// <summary>
        /// Number of items to generate (1-10)
        /// Example: 1
        /// </summary>
        [JsonProperty("count")]
        public string Count { get; set; }
    }
}
