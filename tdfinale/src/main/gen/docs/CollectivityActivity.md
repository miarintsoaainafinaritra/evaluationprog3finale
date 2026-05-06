

# CollectivityActivity


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **String** |  |  [optional] |
|**label** | **String** |  |  [optional] |
|**activityType** | [**ActivityTypeEnum**](#ActivityTypeEnum) |  |  [optional] |
|**memberOccupationConcerned** | **List&lt;MemberOccupation&gt;** |  |  [optional] |
|**recurrenceRule** | [**MonthlyRecurrenceRule**](MonthlyRecurrenceRule.md) |  |  [optional] |
|**executiveDate** | **LocalDate** |  |  [optional] |



## Enum: ActivityTypeEnum

| Name | Value |
|---- | -----|
| MEETING | &quot;MEETING&quot; |
| TRAINING | &quot;TRAINING&quot; |
| OTHER | &quot;OTHER&quot; |



