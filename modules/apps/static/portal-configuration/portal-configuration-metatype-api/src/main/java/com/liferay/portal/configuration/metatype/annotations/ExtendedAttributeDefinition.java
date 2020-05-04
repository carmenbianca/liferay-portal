/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.configuration.metatype.annotations;

import aQute.bnd.annotation.xml.XMLAttribute;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Alejandro Tardín
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@XMLAttribute(
	embedIn = "*", namespace = ExtendedAttributeDefinition.XML_NAMESPACE,
	prefix = ExtendedAttributeDefinition.XML_ATTRIBUTE_PREFIX
)
public @interface ExtendedAttributeDefinition {

	public static final String XML_ATTRIBUTE_PREFIX = "cf";

	public static final String XML_NAMESPACE =
		"http://www.liferay.com/xsd/liferay-configuration-admin_1_0_0.xsd";

	public String[] descriptionArguments() default {};

	public String[] nameArguments() default {};

	public boolean requiredInput() default false;

}