package com.reqres.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postRequest {
	RequestSpecification httpRequest = null;
	Response response = null;
	@BeforeMethod
	public void InitializeRequestURL() {
		RestAssured.baseURI = "https://reqres.in";
		httpRequest = RestAssured.given();
	}
	@Test(priority=0)
	public void CreateUser() {
		System.out.println("======================================");
		System.out.println("CreateUser");
		System.out.println("======================================");
		JSONObject requestparams = new JSONObject();
		requestparams.put("name","morpheus");
		requestparams.put("job","leader");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.post("/api/users");
		System.out.println("Resopnse Code = "+response.statusCode());
		System.out.println("Status Line = "+response.getStatusLine());
		System.out.println("Resopnse Body = "+response.body().asString());
		JsonPath js =response.jsonPath();
		System.out.println("name = "+js.get("name"));//name=null
		System.out.println("id = "+js.get("id"));
		System.out.println("job = "+js.get("job"));//job=null
		System.out.println("createdAt = "+js.get("createdAt"));
	}
	@Test(priority=1)
	public void UpdateUser() {
		System.out.println("======================================");
		System.out.println("UpdateUser");
		System.out.println("======================================");
		int id =2;
		JSONObject requestparams = new JSONObject();
		requestparams.put("name","morpheus");
		requestparams.put("job","zion resident");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.put("/api/users/"+ id);
		System.out.println("Resopnse Code = "+response.statusCode());
		System.out.println("Status Line = "+response.getStatusLine());
		System.out.println("Resopnse Body = "+response.body().asString());
		JsonPath js =response.jsonPath();
		System.out.println("name = "+js.get("name"));//name=null
		System.out.println("id = "+js.get("id"));
		System.out.println("job = "+js.get("job"));//job=null
		System.out.println("createdAt = "+js.get("createdAt"));
	}
	@Test(priority=2)
	public void RegisterSuccess() {
		System.out.println("======================================");
		System.out.println("Register Success");
		System.out.println("======================================");
		JSONObject requestparams = new JSONObject();
		requestparams.put("email","eve.holt@reqres.in");
		requestparams.put("password","pistol");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.post("/api/register");
		System.out.println("Resopnse Code = "+response.statusCode());
		System.out.println("Status Line = "+response.getStatusLine());
		System.out.println("Resopnse Body = "+response.body().asString());
		JsonPath js =response.jsonPath();
		System.out.println("id = "+js.get("id"));
		System.out.println("token= "+js.get("token"));
	}	
	@Test(priority=3)
	public void RegisterFailure() {
		System.out.println("======================================");
		System.out.println("Register Failure");
		System.out.println("======================================");
		JSONObject requestparams = new JSONObject();
		requestparams.put("email","sydney@fife");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.post("/api/register");
		System.out.println("Resopnse Code = "+response.statusCode());
		System.out.println("Status Line = "+response.getStatusLine());
		System.out.println("Resopnse Body = "+response.body().asString());
		JsonPath js =response.jsonPath();
		System.out.println("password = "+js.get("password"));//job=null
	}
	@Test(priority=4)
	public void LoginSuccess() {
		System.out.println("======================================");
		System.out.println("Login PASS");
		System.out.println("======================================");
		JSONObject requestparams = new JSONObject();
		requestparams.put("email","eve.holt@reqres.in");
		requestparams.put("password","cityslicka");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.post("/api/register");
		System.out.println("Resopnse Code = "+response.statusCode());
		System.out.println("Status Line = "+response.getStatusLine());
		System.out.println("Resopnse Body = "+response.body().asString());
		JsonPath js =response.jsonPath();
	}
	@Test(priority=5)
	public void LoginUnSuccess() {
		System.out.println("======================================");
		System.out.println("Login Fail");
		System.out.println("======================================");
		JSONObject requestparams = new JSONObject();
		requestparams.put("email","peter@klaven");
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestparams.toJSONString());
		response = httpRequest.post("/api/login");
		System.out.println("Resopnse Code = "+response.statusCode());
		System.out.println("Status Line = "+response.getStatusLine());
		System.out.println("Resopnse Body = "+response.body().asString());
	}
}
