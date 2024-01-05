# Реализовано в Spaceport + School

**Оглавление:**

1. [SetUp](#setup)
2. [Config](#config)
3. [Controller](#controller)
4. [Properties](#properties)



### <p id='setup'>1. SetUp</p>

- Пререквизит:
  - собрано spring-boot приложение с контроллерами
  - https://www.bezkoder.com/spring-boot-swagger-3/

- Для Spring-boot-3:
    - implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'
- Для Spring-boot-2:
  - implementation 'org.springdoc:springdoc-openapi-ui:1.7.0'

- Если перейти (для текущей апи) http://localhost:8084/v1/api/swagger-ui/index.html - перейдем в окно сваггера
- Если перейти (для текущей апи) http://localhost:8084/v1/api/v3/api-docs - увидим документ в формате json

### <p id='config'>2. Config</p>
- Создадим файл конфигурации OpenAPIConfig.class
- В файле application.properties:
  - spaceport.openapi.dev-url=http://localhost:8084/v1/api/
  - spaceport.openapi.prod-url=http://localhost:8084/v1/api/

Перейдем http://localhost:8084/v1/api/swagger-ui/index.html - у нас появилась новая инфа в шапке + мы можем переключать серверы

Тут http://localhost:8084/v1/api/v3/api-docs все настройки, что мы в бине указали

### <p id='controller'>3. Controller</p>
- Над классом контроллера
  - @Tag(name = "spaceport-api", description = "Spaceport management APIs") - заголовок для контроллера в сваггере
- Над методом контроллера
  -  @Operation(
     summary = "Retrieve all spaceport",
     description = "Get all spaceport object by. The response is spaceport object",
     tags = { "spaceport", "get" })
  -  @ApiResponses({
     @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = GetAllSpaceport.class), mediaType = "application/json")}),
     @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
     @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})

### <p id='properties'>4. Properties</p>

- Use api-docs.enabled=false if you want to disable springdoc-openapi endpoints.
- Use swagger-ui.enabled=false to disable the swagger-ui endpoint.
- api-docs.path is for custom path of the OpenAPI documentation in Json format. Now it is http://localhost:8080/bezkoder-api-docs.
- swagger-ui.path is for custom path of the Swagger documentation. If you visit http://localhost:8080/bezkoder-documentation, the browser will redirect you to http://localhost:8080/swagger-ui/index.html
- packages-to-scan=packageA,packageB: list of packages to scan with comma separated. We also have packages-to-exclude, paths-to-match, paths-to-exclude.
- swagger-ui.tryItOutEnabled if you want to enable “Try it out” section by default.
- swagger-ui.operationsSorter: ‘alpha’ (sort by paths alphanumerically), ‘method’ (sort by HTTP method) or a function.
- swagger-ui.tagsSorter: ‘alpha’ (sort by paths alphanumerically) or a function.
- swagger-ui.filter: true/false to enable or disable filter the tagged operations. We can set a string, the filtering will be enabled using that string as the filter expression which is case sensitive matching anywhere inside the tag.