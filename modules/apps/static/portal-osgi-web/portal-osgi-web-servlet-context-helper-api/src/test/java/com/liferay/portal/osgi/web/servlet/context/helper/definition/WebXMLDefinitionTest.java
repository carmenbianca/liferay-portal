/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.osgi.web.servlet.context.helper.definition;

import java.util.EventListener;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Miguel Pastor
 */
public class WebXMLDefinitionTest {

	@Before
	public void setUp() {
		_webXMLDefinition = new WebXMLDefinition();
	}

	@Test
	public void testAddMultipleFilterDefinition() {
		testAddFilterDefinitions(5);
	}

	@Test
	public void testAddMultipleListenerDefinition() {
		testAddListenerDefinition(5);
	}

	@Test
	public void testAddMultipleServletDefinitions() {
		testAddServletDefinitions(5);
	}

	@Test
	public void testAddSingleFilterDefinition() {
		testAddFilterDefinitions(1);
	}

	@Test
	public void testAddSingleListenerDefinition() {
		testAddListenerDefinition(1);
	}

	@Test
	public void testAddSingleServletDefinition() {
		testAddServletDefinitions(1);
	}

	protected void testAddFilterDefinitions(int count) {
		for (int i = 0; i < count; i++) {
			String s = String.valueOf(i);

			FilterDefinition filterDefinition = new FilterDefinition();

			filterDefinition.addURLPattern(s);

			filterDefinition.setName(s);

			_webXMLDefinition.setFilterDefinition(s, filterDefinition);
		}

		Map<String, FilterDefinition> filterDefinitions =
			_webXMLDefinition.getFilterDefinitions();

		Assert.assertEquals(
			filterDefinitions.toString(), count, filterDefinitions.size());
	}

	protected void testAddListenerDefinition(int count) {
		for (int i = 0; i < count; i++) {
			ListenerDefinition listenerDefinition = new ListenerDefinition();

			listenerDefinition.setEventListener(
				new EventListener() {
				});

			_webXMLDefinition.addListenerDefinition(listenerDefinition);
		}

		List<ListenerDefinition> listenerDefinitions =
			_webXMLDefinition.getListenerDefinitions();

		Assert.assertEquals(
			listenerDefinitions.toString(), count, listenerDefinitions.size());
	}

	protected void testAddServletDefinitions(int count) {
		for (int i = 0; i < count; i++) {
			String s = String.valueOf(i);

			ServletDefinition servletDefinition = new ServletDefinition();

			servletDefinition.addURLPattern(s);

			servletDefinition.setName(s);

			_webXMLDefinition.setServletDefinition(s, servletDefinition);
		}

		Map<String, ServletDefinition> servletDefinitions =
			_webXMLDefinition.getServletDefinitions();

		Assert.assertEquals(
			servletDefinitions.toString(), count, servletDefinitions.size());
	}

	private WebXMLDefinition _webXMLDefinition;

}