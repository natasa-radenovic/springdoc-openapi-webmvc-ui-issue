# Springdoc-openapi-webmvc-ui-issue

Properties:
- Java version: 21
- Parent: spring-boot-starter-parent 3.2.4

This project contains 2 modules:
- v2.4.0
- v2.3.0

These 2 modules are the same, except for the
`springdoc-openapi-starter-webmvc-ui` version they use.
Module `v2.4.0` uses version 2.4.0.
Module `v2.3.0` uses version 2.3.0.

## Endpoints
They both contain a main class, a controller, and a request object class.
They both have 2 endpoints:
- /v1/sampleWithModelAttribute
- /v1/sampleWithRequestBody

`/v1/sampleWithModelAttribute` has its input annotated with `@ModelAttribute`.
`/v1/sampleWithRequestBody` has its input annotated with `@RequestBody`.
The request object for both endpoints is the same, and 
the content type for both endpoints is `application/x-www-form-urlencoded`.

## Swagger page
The Swagger page generated for the 2 endpoints looks very different between 
version 2.4.0 and 2.3.0 of `springdoc-openapi-starter-webmvc-ui`.
For some annotations, the Swagger page generates the input as JSON or 
generates a request that returns a 415. These are the combinations and their results:

| Module |           Endpoint           | Swagger page generated correctly? | Response |
|--------|:----------------------------:|----------------------------------:|---------:|
| v2.3.0 | /v1/sampleWithModelAttribute |                               Yes |      200 |
| v2.3.0 |  /v1/sampleWithRequestBody   |                               Yes |      415 |
| v2.4.0 | /v1/sampleWithModelAttribute |            No (generated as JSON) |      415 |
| v2.4.0 |  /v1/sampleWithRequestBody   |                               Yes |      415 |

The issue seems to stem from the differences between version 2.4.0 and 2.3.0 of `springdoc-openapi-starter-webmvc-ui`.

To reproduce the issue, start the Spring boot project inside the `v2.3.0` module with `mvn clean spring-boot:run`.
Open the generated Swagger page http://localhost:8080/swagger-ui/index.html#.
There, the Swagger page is generated as expected if the input is annotated with `@ModelAttribute`.

Then start the Spring boot project inside the `v2.4.0` module with `mvn clean spring-boot:run`.
Open the generated Swagger page http://localhost:8080/swagger-ui/index.html#.
There, the Swagger page isn't generated as expected if the input is annotated with `@ModelAttribute` or `@RequestBody`.