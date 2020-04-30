/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.data.engine.rest.resource.v2_0;

import com.liferay.data.engine.rest.dto.v2_0.DataRecord;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Locale;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/data-engine/v2.0
 *
 * @author Jeyvison Nascimento
 * @generated
 */
@Generated("")
@ProviderType
public interface DataRecordResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<DataRecord> getDataDefinitionDataRecordsPage(
			Long dataDefinitionId, Long dataListViewId, String keywords,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public DataRecord postDataDefinitionDataRecord(
			Long dataDefinitionId, DataRecord dataRecord)
		throws Exception;

	public Response postDataDefinitionDataRecordBatch(
			Long dataDefinitionId, String callbackURL, Object object)
		throws Exception;

	public Page<DataRecord> getDataRecordCollectionDataRecordsPage(
			Long dataRecordCollectionId, Long dataListViewId, String keywords,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public DataRecord postDataRecordCollectionDataRecord(
			Long dataRecordCollectionId, DataRecord dataRecord)
		throws Exception;

	public Response postDataRecordCollectionDataRecordBatch(
			Long dataRecordCollectionId, String callbackURL, Object object)
		throws Exception;

	public String getDataRecordCollectionDataRecordExport(
			Long dataRecordCollectionId, Pagination pagination)
		throws Exception;

	public void deleteDataRecord(Long dataRecordId) throws Exception;

	public Response deleteDataRecordBatch(String callbackURL, Object object)
		throws Exception;

	public DataRecord getDataRecord(Long dataRecordId) throws Exception;

	public DataRecord putDataRecord(Long dataRecordId, DataRecord dataRecord)
		throws Exception;

	public Response putDataRecordBatch(String callbackURL, Object object)
		throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(
		com.liferay.portal.kernel.model.Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(
		com.liferay.portal.kernel.model.User contextUser);

	public static class FactoryHolder {

		public static volatile Factory factory;

	}

	@ProviderType
	public interface Builder {

		public DataRecordResource build();

		public Builder checkPermissions(boolean checkPermissions);

		public Builder httpServletRequest(
			HttpServletRequest httpServletRequest);

		public Builder preferredLocale(Locale preferredLocale);

		public Builder user(com.liferay.portal.kernel.model.User user);

	}

	@ProviderType
	public interface Factory {

		public Builder create();

	}

}