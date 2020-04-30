/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.form.internal.graphql.servlet.v1_0;

import com.liferay.headless.form.internal.graphql.mutation.v1_0.Mutation;
import com.liferay.headless.form.internal.graphql.query.v1_0.Query;
import com.liferay.headless.form.resource.v1_0.FormDocumentResource;
import com.liferay.headless.form.resource.v1_0.FormRecordResource;
import com.liferay.headless.form.resource.v1_0.FormResource;
import com.liferay.headless.form.resource.v1_0.FormStructureResource;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Javier Gamarra
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setFormResourceComponentServiceObjects(
			_formResourceComponentServiceObjects);
		Mutation.setFormDocumentResourceComponentServiceObjects(
			_formDocumentResourceComponentServiceObjects);
		Mutation.setFormRecordResourceComponentServiceObjects(
			_formRecordResourceComponentServiceObjects);

		Query.setFormResourceComponentServiceObjects(
			_formResourceComponentServiceObjects);
		Query.setFormDocumentResourceComponentServiceObjects(
			_formDocumentResourceComponentServiceObjects);
		Query.setFormRecordResourceComponentServiceObjects(
			_formRecordResourceComponentServiceObjects);
		Query.setFormStructureResourceComponentServiceObjects(
			_formStructureResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/headless-form-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FormResource>
		_formResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FormDocumentResource>
		_formDocumentResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FormRecordResource>
		_formRecordResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<FormStructureResource>
		_formStructureResourceComponentServiceObjects;

}