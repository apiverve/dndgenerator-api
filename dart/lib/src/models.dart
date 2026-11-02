/// Response models for the D&D Generator API.

/// API Response wrapper.
class DndgeneratorResponse {
  final String status;
  final dynamic error;
  final DndgeneratorData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  DndgeneratorResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory DndgeneratorResponse.fromJson(Map<String, dynamic> json) => DndgeneratorResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? DndgeneratorData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the D&D Generator API.

class DndgeneratorData {
  String? type;
  num? count;
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
  num? level;
  String? background;
  String? alignment;
  DndgeneratorDataResultsStats? stats;
  num? hitPoints;

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
  num? strength;
  num? dexterity;
  num? constitution;
  num? intelligence;
  num? wisdom;
  num? charisma;

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
