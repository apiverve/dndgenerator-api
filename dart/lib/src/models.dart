/// Response models for the D&D Generator API.

/// API Response wrapper.
class DndgeneratorResponse {
  final String status;
  final dynamic error;
  final DndgeneratorData? data;

  DndgeneratorResponse({
    required this.status,
    this.error,
    this.data,
  });

  factory DndgeneratorResponse.fromJson(Map<String, dynamic> json) => DndgeneratorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DndgeneratorData.fromJson(json['data']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
  };
}

/// Response data for the D&D Generator API.

class DndgeneratorData {
  String? type;
  int? count;
  DndgeneratorDataResults? results;

  DndgeneratorData({
    this.type,
    this.count,
    this.results,
  });

  factory DndgeneratorData.fromJson(Map<String, dynamic> json) => DndgeneratorData(
      type: json['type'],
      count: json['count'],
      results: json['results'] != null ? DndgeneratorDataResults.fromJson(json['results']) : null,
    );
}

class DndgeneratorDataResults {
  String? name;
  String? race;
  String? class;
  int? level;
  String? background;
  String? alignment;
  DndgeneratorDataResultsStats? stats;
  int? hitPoints;

  DndgeneratorDataResults({
    this.name,
    this.race,
    this.class,
    this.level,
    this.background,
    this.alignment,
    this.stats,
    this.hitPoints,
  });

  factory DndgeneratorDataResults.fromJson(Map<String, dynamic> json) => DndgeneratorDataResults(
      name: json['name'],
      race: json['race'],
      class: json['class'],
      level: json['level'],
      background: json['background'],
      alignment: json['alignment'],
      stats: json['stats'] != null ? DndgeneratorDataResultsStats.fromJson(json['stats']) : null,
      hitPoints: json['hitPoints'],
    );
}

class DndgeneratorDataResultsStats {
  int? strength;
  int? dexterity;
  int? constitution;
  int? intelligence;
  int? wisdom;
  int? charisma;

  DndgeneratorDataResultsStats({
    this.strength,
    this.dexterity,
    this.constitution,
    this.intelligence,
    this.wisdom,
    this.charisma,
  });

  factory DndgeneratorDataResultsStats.fromJson(Map<String, dynamic> json) => DndgeneratorDataResultsStats(
      strength: json['strength'],
      dexterity: json['dexterity'],
      constitution: json['constitution'],
      intelligence: json['intelligence'],
      wisdom: json['wisdom'],
      charisma: json['charisma'],
    );
}

class DndgeneratorRequest {
  String? type;
  int? count;

  DndgeneratorRequest({
    this.type,
    this.count,
  });

  Map<String, dynamic> toJson() => {
      if (type != null) 'type': type,
      if (count != null) 'count': count,
    };
}
