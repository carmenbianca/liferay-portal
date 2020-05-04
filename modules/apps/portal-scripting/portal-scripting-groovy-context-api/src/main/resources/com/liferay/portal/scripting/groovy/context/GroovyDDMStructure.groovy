/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.scripting.groovy.context;

import com.liferay.dynamic.data.lists.model.DDLRecordSet;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.model.DDMStructureConstants;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;

/**
 * @author Michael C. Han
 */
class GroovyDDMStructure {

	GroovyDDMStructure(
		GroovySite groovySite_, String structureKey_, String name_,
		String description_, String xsd_) {

		groovySite = groovySite_;
		structureKey = structureKey_;
		name = name_;
		description = description_;
		xsd = xsd_;
	}

	void create(GroovyScriptingContext scriptingContext) {
		ddmStructure = GroovyDDMStructure.fetchStructure(
			scriptingContext, groovySite, structureKey);

		if (ddmStructure != null) {
			return;
		}

		ddmStructure = DDMStructureLocalServiceUtil.addStructure(
			scriptingContext.getDefaultUserId(), groovySite.group.getGroupId(),
			0, ClassNameLocalServiceUtil.getClassNameId(DDLRecordSet.class),
			null, GroovyScriptingContext.getLocalizationMap(name),
			GroovyScriptingContext.getLocalizationMap(description), xsd, "xml",
			DDMStructureConstants.TYPE_DEFAULT,
			scriptingContext.getServiceContext());
	}

	static DDMStructure fetchStructure(
		GroovyScriptingContext scriptingContext, GroovySite groovySite_,
		String structureKey_) {

		long classnameId = ClassNameLocalServiceUtil.getClassNameId(
			DDLRecordSet.class);

		return DDMStructureLocalServiceUtil.fetchStructure(
			groovySite.group.getGroupId(), classnameId, structureKey_);
	}

	DDMStructure ddmStructure;
	String description;
	GroovySite groovySite;
	String name;
	String structureKey;
	String xsd;
}