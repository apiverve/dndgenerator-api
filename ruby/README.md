# D&D Generator API - Ruby Gem

D&D Generator creates random content for tabletop role-playing games including characters, NPCs, monsters, treasure, encounters, taverns, and quests.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_dndgenerator'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_dndgenerator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_dndgenerator'

# Initialize the client
client = APIVerve::Dndgenerator::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  type: "all",
  count: 1
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ type: "all", count: 1 })
  puts response["data"]
rescue APIVerve::Dndgenerator::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Dndgenerator::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Dndgenerator::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "type": "character",
    "count": 1,
    "results": {
      "name": "Ashorshadow",
      "race": "Elf",
      "class": "Warlock",
      "level": 6,
      "background": "Criminal",
      "alignment": "Lawful Good",
      "stats": {
        "strength": 10,
        "dexterity": 12,
        "constitution": 7,
        "intelligence": 15,
        "wisdom": 12,
        "charisma": 10
      },
      "hitPoints": 20
    }
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/dndgenerator?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/dndgenerator?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/dndgenerator?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
