# D&D Generator API - Dart/Flutter Client

D&D Generator creates random content for tabletop role-playing games including characters, NPCs, monsters, treasure, encounters, taverns, and quests.

[![pub package](https://img.shields.io/pub/v/apiverve_dndgenerator.svg)](https://pub.dev/packages/apiverve_dndgenerator)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [D&D Generator API](https://apiverve.com/marketplace/dndgenerator?utm_source=dart&utm_medium=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_dndgenerator: ^1.1.14
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_dndgenerator/apiverve_dndgenerator.dart';

void main() async {
  final client = DndgeneratorClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'type': 'all',
      'count': 1
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "type": "character",
    "count": 1,
    "results": {
      "name": "Galorblade",
      "race": "Dragonborn",
      "class": "Warlock",
      "level": 12,
      "background": "Hermit",
      "alignment": "True Neutral",
      "stats": {
        "strength": 10,
        "dexterity": 13,
        "constitution": 16,
        "intelligence": 16,
        "wisdom": 9,
        "charisma": 9
      },
      "hitPoints": 14
    }
  }
}
```

## API Reference

- **API Home:** [D&D Generator API](https://apiverve.com/marketplace/dndgenerator?utm_source=dart&utm_medium=readme)
- **Documentation:** [docs.apiverve.com/ref/dndgenerator](https://docs.apiverve.com/ref/dndgenerator?utm_source=dart&utm_medium=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=readme)
