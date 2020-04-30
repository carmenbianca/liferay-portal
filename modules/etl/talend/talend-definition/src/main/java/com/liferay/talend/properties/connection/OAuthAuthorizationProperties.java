/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.talend.properties.connection;

import com.liferay.talend.ui.UIKeys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.talend.daikon.properties.PropertiesImpl;
import org.talend.daikon.properties.presentation.Form;
import org.talend.daikon.properties.property.Property;
import org.talend.daikon.properties.property.PropertyFactory;

/**
 * @author Igor Beslic
 */
public class OAuthAuthorizationProperties extends PropertiesImpl {

	public OAuthAuthorizationProperties(String name) {
		super(name);

		if (_logger.isTraceEnabled()) {
			_logger.trace("Instantiated " + System.identityHashCode(this));
		}
	}

	@Override
	public void setupLayout() {
		Form referenceForm = new Form(this, UIKeys.FORM_OAUTH_AUTHORIZATION);

		referenceForm.addRow(oauthClientId);
		referenceForm.addRow(oauthClientSecret);

		if (_logger.isTraceEnabled()) {
			_logger.trace("Layout set " + System.identityHashCode(this));
		}
	}

	@Override
	public void setupProperties() {
		oauthClientId.setValue("");
		oauthClientSecret.setValue("");

		if (_logger.isTraceEnabled()) {
			_logger.trace("Properties set " + System.identityHashCode(this));
		}
	}

	public Property<String> oauthClientId = PropertyFactory.newString(
		"oauthClientId");
	public Property<String> oauthClientSecret = PropertyFactory.newString(
		"oauthClientSecret");

	private static final Logger _logger = LoggerFactory.getLogger(
		OAuthAuthorizationProperties.class);

}