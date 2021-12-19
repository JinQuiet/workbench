package com.jinquiet.web.mapping;

public class RequestMapping {

/*

request.getServerPath() - путь запроса (эндпоинт)
request.getMethod() - метод

1. перехват входящего запроса в методе doFilter(request, response)
2. чистка строки ввода.

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

========эндпоинты=======
*/

/*
    private String[] consumes;
    private String[] headers;
    private RequestMethod[] method;
    private String name;
    private String[] params;
    private String[] path;
    private String[] produces;
    private String[] value;
*/
    //name of the action bound to the mapping
    private String actionName;
    //path passed to the servlet. We have only 1 servlet. So it's just "path"
    private String path;
    private String pathRegex;

    
    public String getActionName() {
        return actionName;
    }
    public void setActionName(String actionName) {
        this.actionName = actionName;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getPathRegex() {
        return pathRegex;
    }
    public void setPathRegex(String pathRegex) {
        this.pathRegex = pathRegex;
    }

    @Override
    public String toString() {
        return "RequestMapping [actionName=" + actionName + ", path=" + path + ", pathRegex=" + pathRegex + "]";
    }
}
