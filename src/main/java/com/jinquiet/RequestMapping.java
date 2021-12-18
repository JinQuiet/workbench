package com.jinquiet;

public class RequestMapping {

    private String[] consumes;
    private String[] headers;
    private RequestMethod[] method;
    private String name;
    private String[] params;
    private String[] path;
    private String[] produces;
    private String[] value;
 
 public String[] getConsumes() {
     return consumes;
 }
 public void setConsumes(String[] consumes) {
     this.consumes = consumes;
 }
 public String[] getHeaders() {
     return headers;
 }
 public void setHeaders(String[] headers) {
     this.headers = headers;
 }
 public RequestMethod[] getMethod() {
     return method;
 }
 public void setMethod(RequestMethod[] method) {
     this.method = method;
 }
 public String getName() {
     return name;
 }
 public void setName(String name) {
     this.name = name;
 }
 public String[] getParams() {
     return params;
 }
 public void setParams(String[] params) {
     this.params = params;
 }
 public String[] getPath() {
     return path;
 }
 public void setPath(String[] path) {
     this.path = path;
 }
 public String[] getProduces() {
     return produces;
 }
 public void setProduces(String[] produces) {
     this.produces = produces;
 }
 public String[] getValue() {
     return value;
 }
 public void setValue(String[] value) {
     this.value = value;
 }
 
 }
