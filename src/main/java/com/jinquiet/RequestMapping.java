package com.jinquiet;

public class RequestMapping {

/*

request.getServerPath() - путь запроса (эндпоинт)
request.getMethod() - метод

1. перехват входящего запроса в методе doFilter(request, response)
2. проанализировать request на корректность обращения к эндпоинту

3.




RequestPool

mappingExists(HttpRequest request)

===========================эндпоинты===========================

    =======0001
    /users
    GET - извлечение всех пользователей

    =======0002  - открыть редактор нового пользователя
    /users
    POST

    =======0003 - открыть редактор существующего пользователя
    /users/%integer%
    GET 

    =======0004 - отредактировать пользователя
    /users/%integer%
    PUT 

    =======0005 - удалить пользователя
    /users/%integer%
    DELETE 

    =======0006 - открыть редактор создания нового пользователя
    /users/user
    GET

========варианты того как может выглядеть эндпоинт=======



GET
POST
PUT
DELETE

*/




    private String[] consumes;
    private String[] headers;
    private RequestMethod[] method;
    private String name;
    private String[] params;
    private String[] path;
    private String[] produces;
    private String[] value;
 
 
}
