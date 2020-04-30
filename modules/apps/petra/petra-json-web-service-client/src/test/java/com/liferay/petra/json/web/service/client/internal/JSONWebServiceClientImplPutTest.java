/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.petra.json.web.service.client.internal;

import com.liferay.petra.json.web.service.client.JSONWebServiceInvocationException;
import com.liferay.petra.json.web.service.client.model.ResponseBody;
import com.liferay.petra.json.web.service.client.server.simulator.HTTPServerSimulator;
import com.liferay.petra.json.web.service.client.server.simulator.SimulatorConstants;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Igor Beslic
 */
public class JSONWebServiceClientImplPutTest
	extends BaseJSONWebServiceClientTestCase {

	@Before
	public void setUp() throws Exception {
		HTTPServerSimulator.start();
	}

	@After
	public void tearDown() {
		HTTPServerSimulator.stop();
	}

	@Test(expected = JSONWebServiceInvocationException.class)
	public void testBadRequestOnPut() throws Exception {
		JSONWebServiceClientImpl jsonWebServiceClientImpl =
			new JSONWebServiceClientImpl();

		Map<String, Object> properties = getBaseProperties();

		properties.put("protocol", "http");

		jsonWebServiceClientImpl.activate(properties);

		jsonWebServiceClientImpl.doPut("/", Collections.emptyList());
	}

	@Test
	public void testResponse200OnPut() throws Exception {
		JSONWebServiceClientImpl jsonWebServiceClientImpl =
			new JSONWebServiceClientImpl();

		Map<String, Object> properties = getBaseProperties();

		properties.put(
			"headers", "headerKey1=headerValue1;Accept=application/json;");
		properties.put("protocol", "http");

		jsonWebServiceClientImpl.activate(properties);

		String json = jsonWebServiceClientImpl.doPut(
			"/testPut/", getParameters("200"));

		Assert.assertTrue(
			json,
			json.contains(
				SimulatorConstants.HTTP_PARAMETER_RESPOND_WITH_STATUS));
	}

	@Test
	public void testResponse200OnPutToObject() throws Exception {
		JSONWebServiceClientImpl jsonWebServiceClientImpl =
			new JSONWebServiceClientImpl();

		Map<String, Object> properties = getBaseProperties();

		properties.put(
			"headers", "headerKey1=headerValue1;Accept=application/json;");
		properties.put("protocol", "http");

		jsonWebServiceClientImpl.activate(properties);

		List<NameValuePair> params = getParameters("200");

		params.add(new BasicNameValuePair("parameter1", "parameter1"));
		params.add(new BasicNameValuePair("parameter2", "parameter2"));
		params.add(new BasicNameValuePair("parameter3", "parameter3"));

		ResponseBody responseBody = jsonWebServiceClientImpl.doPutToObject(
			ResponseBody.class, "/testPut/", params);

		Assert.assertEquals("parameter1", responseBody.getParameter1());
		Assert.assertEquals("parameter2", responseBody.getParameter2());
		Assert.assertEquals("parameter3", responseBody.getParameter3());
	}

	@Test
	public void testResponse200OnPutToObjectWithParmetersArray()
		throws Exception {

		JSONWebServiceClientImpl jsonWebServiceClientImpl =
			new JSONWebServiceClientImpl();

		Map<String, Object> properties = getBaseProperties();

		properties.put(
			"headers", "headerKey1=headerValue1;Accept=application/json;");
		properties.put("protocol", "http");

		jsonWebServiceClientImpl.activate(properties);

		ResponseBody responseBody = jsonWebServiceClientImpl.doPutToObject(
			ResponseBody.class, "/testPut/",
			SimulatorConstants.HTTP_PARAMETER_RESPOND_WITH_STATUS, "200",
			SimulatorConstants.HTTP_PARAMETER_RETURN_PARMS_IN_JSON, "true",
			"parameter1", "parameter1", "parameter2", "parameter2",
			"parameter3", "parameter3");

		Assert.assertEquals("parameter1", responseBody.getParameter1());
		Assert.assertEquals("parameter2", responseBody.getParameter2());
		Assert.assertEquals("parameter3", responseBody.getParameter3());
	}

	@Test
	public void testResponse202OnPut() throws Exception {
		JSONWebServiceClientImpl jsonWebServiceClientImpl =
			new JSONWebServiceClientImpl();

		Map<String, Object> properties = getBaseProperties();

		properties.put(
			"headers", "headerKey1=headerValue1;Accept=application/json;");
		properties.put("protocol", "http");

		jsonWebServiceClientImpl.activate(properties);

		Assert.assertEquals(
			SimulatorConstants.RESPONSE_SUCCESS_IN_JSON,
			jsonWebServiceClientImpl.doPost("/testPut/", getParameters("202")));
	}

	@Test
	public void testResponse204OnPut() throws Exception {
		JSONWebServiceClientImpl jsonWebServiceClientImpl =
			new JSONWebServiceClientImpl();

		Map<String, Object> properties = getBaseProperties();

		properties.put(
			"headers", "Accept=application/json;headerKey1=headerValue1");
		properties.put("protocol", "http");

		jsonWebServiceClientImpl.activate(properties);

		Assert.assertNull(
			jsonWebServiceClientImpl.doPost("/testPut/", getParameters("204")));
	}

}