/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.headless.admin.taxonomy.resource.v1_0;

import com.liferay.headless.admin.taxonomy.dto.v1_0.TaxonomyCategory;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
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
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/headless-admin-taxonomy/v1.0
 *
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
@ProviderType
public interface TaxonomyCategoryResource {

	public static Builder builder() {
		return FactoryHolder.factory.create();
	}

	public Page<TaxonomyCategory> getTaxonomyCategoryRankedPage(
			Long siteId, Pagination pagination)
		throws Exception;

	public Page<TaxonomyCategory> getTaxonomyCategoryTaxonomyCategoriesPage(
			String parentTaxonomyCategoryId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public TaxonomyCategory postTaxonomyCategoryTaxonomyCategory(
			String parentTaxonomyCategoryId, TaxonomyCategory taxonomyCategory)
		throws Exception;

	public void deleteTaxonomyCategory(String taxonomyCategoryId)
		throws Exception;

	public Response deleteTaxonomyCategoryBatch(
			String callbackURL, Object object)
		throws Exception;

	public TaxonomyCategory getTaxonomyCategory(String taxonomyCategoryId)
		throws Exception;

	public TaxonomyCategory patchTaxonomyCategory(
			String taxonomyCategoryId, TaxonomyCategory taxonomyCategory)
		throws Exception;

	public TaxonomyCategory putTaxonomyCategory(
			String taxonomyCategoryId, TaxonomyCategory taxonomyCategory)
		throws Exception;

	public Response putTaxonomyCategoryBatch(String callbackURL, Object object)
		throws Exception;

	public Page<TaxonomyCategory> getTaxonomyVocabularyTaxonomyCategoriesPage(
			Long taxonomyVocabularyId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception;

	public TaxonomyCategory postTaxonomyVocabularyTaxonomyCategory(
			Long taxonomyVocabularyId, TaxonomyCategory taxonomyCategory)
		throws Exception;

	public Response postTaxonomyVocabularyTaxonomyCategoryBatch(
			Long taxonomyVocabularyId, String callbackURL, Object object)
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

		public TaxonomyCategoryResource build();

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