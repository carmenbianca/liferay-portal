/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.internal.graphql.servlet.v2_0;

import com.liferay.data.engine.rest.internal.graphql.mutation.v2_0.Mutation;
import com.liferay.data.engine.rest.internal.graphql.query.v2_0.Query;
import com.liferay.data.engine.rest.resource.v2_0.DataDefinitionResource;
import com.liferay.data.engine.rest.resource.v2_0.DataLayoutResource;
import com.liferay.data.engine.rest.resource.v2_0.DataListViewResource;
import com.liferay.data.engine.rest.resource.v2_0.DataRecordCollectionResource;
import com.liferay.data.engine.rest.resource.v2_0.DataRecordResource;
import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Jeyvison Nascimento
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setDataDefinitionResourceComponentServiceObjects(
			_dataDefinitionResourceComponentServiceObjects);
		Mutation.setDataLayoutResourceComponentServiceObjects(
			_dataLayoutResourceComponentServiceObjects);
		Mutation.setDataListViewResourceComponentServiceObjects(
			_dataListViewResourceComponentServiceObjects);
		Mutation.setDataRecordResourceComponentServiceObjects(
			_dataRecordResourceComponentServiceObjects);
		Mutation.setDataRecordCollectionResourceComponentServiceObjects(
			_dataRecordCollectionResourceComponentServiceObjects);

		Query.setDataDefinitionResourceComponentServiceObjects(
			_dataDefinitionResourceComponentServiceObjects);
		Query.setDataLayoutResourceComponentServiceObjects(
			_dataLayoutResourceComponentServiceObjects);
		Query.setDataListViewResourceComponentServiceObjects(
			_dataListViewResourceComponentServiceObjects);
		Query.setDataRecordResourceComponentServiceObjects(
			_dataRecordResourceComponentServiceObjects);
		Query.setDataRecordCollectionResourceComponentServiceObjects(
			_dataRecordCollectionResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/data-engine-graphql/v2_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DataDefinitionResource>
		_dataDefinitionResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DataLayoutResource>
		_dataLayoutResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DataListViewResource>
		_dataListViewResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DataRecordResource>
		_dataRecordResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<DataRecordCollectionResource>
		_dataRecordCollectionResourceComponentServiceObjects;

}