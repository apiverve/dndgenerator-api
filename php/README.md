# D&D Generator API - PHP Package

D&D Generator creates random content for tabletop role-playing games including characters, NPCs, monsters, treasure, encounters, taverns, and quests.

## Installation

Install via Composer:

```bash
composer require apiverve/dndgenerator
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Dndgenerator\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'type' => 'all',
    'count' => 1
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Dndgenerator\Client;
use APIVerve\Dndgenerator\Exceptions\APIException;
use APIVerve\Dndgenerator\Exceptions\ValidationException;

try {
    $response = $client->execute(['type' => 'all', 'count' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/dndgenerator?utm_source=packagist&utm_medium=readme).

## Support

- Website: [https://apiverve.com/marketplace/dndgenerator?utm_source=php&utm_medium=readme](https://apiverve.com/marketplace/dndgenerator?utm_source=php&utm_medium=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
