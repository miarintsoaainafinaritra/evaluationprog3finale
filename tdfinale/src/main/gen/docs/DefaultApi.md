# DefaultApi

All URIs are relative to *https://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**collectivitesIdStatisticsGet**](DefaultApi.md#collectivitesIdStatisticsGet) | **GET** /collectivites/{id}/statistics | Get local statistics for a collectivity |
| [**collectivitesStatisticsGet**](DefaultApi.md#collectivitesStatisticsGet) | **GET** /collectivites/statistics | Get collectivities overall statistics |
| [**collectivitiesIdFinancialAccountsGet**](DefaultApi.md#collectivitiesIdFinancialAccountsGet) | **GET** /collectivities/{id}/financialAccounts | Get collectivity financial accounts |
| [**collectivitiesIdGet**](DefaultApi.md#collectivitiesIdGet) | **GET** /collectivities/{id} | Retrieve collectivity by its ID. |
| [**collectivitiesIdInformationsPut**](DefaultApi.md#collectivitiesIdInformationsPut) | **PUT** /collectivities/{id}/informations | Attribute collectivity informations to specific collectivity |
| [**collectivitiesIdMembershipFeesGet**](DefaultApi.md#collectivitiesIdMembershipFeesGet) | **GET** /collectivities/{id}/membershipFees | Retrieve collectivity membership fees |
| [**collectivitiesIdMembershipFeesPost**](DefaultApi.md#collectivitiesIdMembershipFeesPost) | **POST** /collectivities/{id}/membershipFees | Create new membership fees for a specific collectivity |
| [**collectivitiesIdTransactionsGet**](DefaultApi.md#collectivitiesIdTransactionsGet) | **GET** /collectivities/{id}/transactions | Retrieve specific collectivity transactions for a given period |
| [**collectivitiesPost**](DefaultApi.md#collectivitiesPost) | **POST** /collectivities | Create list of collectivities |
| [**membersIdPaymentsPost**](DefaultApi.md#membersIdPaymentsPost) | **POST** /members/{id}/payments | Create some payments for given member |
| [**membersPost**](DefaultApi.md#membersPost) | **POST** /members | Create list of members |


<a id="collectivitesIdStatisticsGet"></a>
# **collectivitesIdStatisticsGet**
> List&lt;CollectivityLocalStatistics&gt; collectivitesIdStatisticsGet(id, from, to)

Get local statistics for a collectivity

Get statistics for a collectivity between a date interval. Actually, statistics contain only earned amount from each member and potential unpaid amount. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    LocalDate from = LocalDate.now(); // LocalDate | 
    LocalDate to = LocalDate.now(); // LocalDate | 
    try {
      List<CollectivityLocalStatistics> result = apiInstance.collectivitesIdStatisticsGet(id, from, to);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitesIdStatisticsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **from** | **LocalDate**|  | |
| **to** | **LocalDate**|  | |

### Return type

[**List&lt;CollectivityLocalStatistics&gt;**](CollectivityLocalStatistics.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Collectivity local statistics |  -  |

<a id="collectivitesStatisticsGet"></a>
# **collectivitesStatisticsGet**
> List&lt;CollectivityOverallStatistics&gt; collectivitesStatisticsGet(from, to)

Get collectivities overall statistics

Get collectivities global statistics between a date interval. Actually, statistics contain only overall percentage of members who are current with their dues (membership fees) and number of new members. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    LocalDate from = LocalDate.now(); // LocalDate | 
    LocalDate to = LocalDate.now(); // LocalDate | 
    try {
      List<CollectivityOverallStatistics> result = apiInstance.collectivitesStatisticsGet(from, to);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitesStatisticsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **from** | **LocalDate**|  | |
| **to** | **LocalDate**|  | |

### Return type

[**List&lt;CollectivityOverallStatistics&gt;**](CollectivityOverallStatistics.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Collectivity overall statistics |  -  |

<a id="collectivitiesIdFinancialAccountsGet"></a>
# **collectivitiesIdFinancialAccountsGet**
> List&lt;FinancialAccount&gt; collectivitiesIdFinancialAccountsGet(id, at)

Get collectivity financial accounts

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    LocalDate at = LocalDate.now(); // LocalDate | 
    try {
      List<FinancialAccount> result = apiInstance.collectivitiesIdFinancialAccountsGet(id, at);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdFinancialAccountsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **at** | **LocalDate**|  | [optional] |

### Return type

[**List&lt;FinancialAccount&gt;**](FinancialAccount.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of financial account of the collectivity |  -  |
| **404** | Collectivity not found |  -  |

<a id="collectivitiesIdGet"></a>
# **collectivitiesIdGet**
> Collectivity collectivitiesIdGet(id)

Retrieve collectivity by its ID.

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      Collectivity result = apiInstance.collectivitiesIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**Collectivity**](Collectivity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Collectivity retrieved |  -  |
| **404** | Collectivity not found |  -  |

<a id="collectivitiesIdInformationsPut"></a>
# **collectivitiesIdInformationsPut**
> Collectivity collectivitiesIdInformationsPut(id, collectivityInformation)

Attribute collectivity informations to specific collectivity

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    CollectivityInformation collectivityInformation = new CollectivityInformation(); // CollectivityInformation | 
    try {
      Collectivity result = apiInstance.collectivitiesIdInformationsPut(id, collectivityInformation);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdInformationsPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **collectivityInformation** | [**CollectivityInformation**](CollectivityInformation.md)|  | [optional] |

### Return type

[**Collectivity**](Collectivity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Collectivity with updated information |  -  |
| **400** | Either given number or name is already used by other collectivity. |  -  |
| **404** | Collectivity not found. |  -  |

<a id="collectivitiesIdMembershipFeesGet"></a>
# **collectivitiesIdMembershipFeesGet**
> List&lt;MembershipFee&gt; collectivitiesIdMembershipFeesGet(id)

Retrieve collectivity membership fees

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      List<MembershipFee> result = apiInstance.collectivitiesIdMembershipFeesGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdMembershipFeesGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |

### Return type

[**List&lt;MembershipFee&gt;**](MembershipFee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of membership fees for the specific collectivity |  -  |
| **404** | Collectivity not found. |  -  |

<a id="collectivitiesIdMembershipFeesPost"></a>
# **collectivitiesIdMembershipFeesPost**
> List&lt;MembershipFee&gt; collectivitiesIdMembershipFeesPost(id, createMembershipFee)

Create new membership fees for a specific collectivity

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    List<CreateMembershipFee> createMembershipFee = Arrays.asList(); // List<CreateMembershipFee> | 
    try {
      List<MembershipFee> result = apiInstance.collectivitiesIdMembershipFeesPost(id, createMembershipFee);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdMembershipFeesPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **createMembershipFee** | [**List&lt;CreateMembershipFee&gt;**](CreateMembershipFee.md)|  | [optional] |

### Return type

[**List&lt;MembershipFee&gt;**](MembershipFee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Created membership fees |  -  |
| **400** | Either unrecognized frequency or amount under 0. |  -  |
| **404** | Collectivity not found. |  -  |

<a id="collectivitiesIdTransactionsGet"></a>
# **collectivitiesIdTransactionsGet**
> List&lt;CollectivityTransaction&gt; collectivitiesIdTransactionsGet(id, from, to)

Retrieve specific collectivity transactions for a given period

Query parameters &#x60;from&#x60; and &#x60;to&#x60; are mandatory to filters collectivity transactions. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    LocalDate from = LocalDate.now(); // LocalDate | 
    LocalDate to = LocalDate.now(); // LocalDate | 
    try {
      List<CollectivityTransaction> result = apiInstance.collectivitiesIdTransactionsGet(id, from, to);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesIdTransactionsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **from** | **LocalDate**|  | |
| **to** | **LocalDate**|  | |

### Return type

[**List&lt;CollectivityTransaction&gt;**](CollectivityTransaction.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | List of collectivity transactions between provided dates |  -  |
| **400** | Provided query parameters occur some exceptions. |  -  |
| **404** | Collectivity not found. |  -  |

<a id="collectivitiesPost"></a>
# **collectivitiesPost**
> List&lt;Collectivity&gt; collectivitiesPost(createCollectivity)

Create list of collectivities

During collectivity request body creation, only members ID are provided to identify members.  But the response content includes members information, not only their IDs. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    List<CreateCollectivity> createCollectivity = Arrays.asList(); // List<CreateCollectivity> | 
    try {
      List<Collectivity> result = apiInstance.collectivitiesPost(createCollectivity);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#collectivitiesPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createCollectivity** | [**List&lt;CreateCollectivity&gt;**](CreateCollectivity.md)|  | [optional] |

### Return type

[**List&lt;Collectivity&gt;**](Collectivity.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | List of created collectivities |  -  |
| **400** | Collectivity without federation approval or structure missing. |  -  |
| **404** | Member not found. |  -  |

<a id="membersIdPaymentsPost"></a>
# **membersIdPaymentsPost**
> List&lt;MemberPayment&gt; membersIdPaymentsPost(id, createMemberPayment)

Create some payments for given member

Each time a member create a payment, a transaction is store automatically inside collectivities transactions. 

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | 
    List<CreateMemberPayment> createMemberPayment = Arrays.asList(); // List<CreateMemberPayment> | 
    try {
      List<MemberPayment> result = apiInstance.membersIdPaymentsPost(id, createMemberPayment);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#membersIdPaymentsPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**|  | |
| **createMemberPayment** | [**List&lt;CreateMemberPayment&gt;**](CreateMemberPayment.md)|  | [optional] |

### Return type

[**List&lt;MemberPayment&gt;**](MemberPayment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | List of created members payments |  -  |

<a id="membersPost"></a>
# **membersPost**
> List&lt;Member&gt; membersPost(createMember)

Create list of members

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://localhost:8080");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    List<CreateMember> createMember = Arrays.asList(); // List<CreateMember> | 
    try {
      List<Member> result = apiInstance.membersPost(createMember);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#membersPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **createMember** | [**List&lt;CreateMember&gt;**](CreateMember.md)|  | [optional] |

### Return type

[**List&lt;Member&gt;**](Member.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | List of created members |  -  |
| **400** | The following case must return a bad request exception :  - Member with bad referees or without proper payment. - Membership dues not paid or registration fee not paid.  |  -  |
| **404** | Either collectivity or member not found. |  -  |

