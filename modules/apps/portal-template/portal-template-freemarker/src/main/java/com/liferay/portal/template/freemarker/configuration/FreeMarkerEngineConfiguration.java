/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.template.freemarker.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Peter Fellwock
 */
@ExtendedObjectClassDefinition(category = "template-engines")
@Meta.OCD(
	id = "com.liferay.portal.template.freemarker.configuration.FreeMarkerEngineConfiguration",
	localization = "content/Language",
	name = "freemarker-engine-configuration-name"
)
public interface FreeMarkerEngineConfiguration {

	@Meta.AD(deflt = "false", name = "localized-lookup", required = false)
	public boolean localizedLookup();

	@Meta.AD(
		deflt = "60000", name = "resource-modification-check", required = false
	)
	public int resourceModificationCheck();

	@Meta.AD(name = "allowed-classes", required = false)
	public String[] allowedClasses();

	@Meta.AD(
		deflt = "com.ibm.*|com.liferay.portal.json.jabsorb.serializer.LiferayJSONDeserializationWhitelist|com.liferay.portal.spring.context.*|io.undertow.*|java.lang.Class|java.lang.ClassLoader|java.lang.Compiler|java.lang.Package|java.lang.Process|java.lang.Runtime|java.lang.RuntimePermission|java.lang.SecurityManager|java.lang.System|java.lang.Thread|java.lang.ThreadGroup|java.lang.ThreadLocal|org.apache.*|org.glassfish.*|org.jboss.*|org.springframework.*|org.wildfly.*|weblogic.*",
		name = "restricted-classes", required = false
	)
	public String[] restrictedClasses();

	@Meta.AD(
		deflt = "com.liferay.portal.model.impl.CompanyImpl#getKey",
		name = "restricted-methods", required = false
	)
	public String[] restrictedMethods();

	@Meta.AD(
		deflt = "httpUtilUnsafe|objectUtil|serviceLocator|staticFieldGetter|staticUtil|utilLocator",
		name = "restricted-variables", required = false
	)
	public String[] restrictedVariables();

	@Meta.AD(
		deflt = "rethrow", name = "template-exception-handler", required = false
	)
	public String templateExceptionHandler();

	@Meta.AD(
		deflt = "FTL_liferay.ftl as liferay", name = "macro-library",
		required = false
	)
	public String[] macroLibrary();

}