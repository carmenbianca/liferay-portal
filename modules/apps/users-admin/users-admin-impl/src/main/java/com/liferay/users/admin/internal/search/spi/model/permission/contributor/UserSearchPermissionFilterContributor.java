/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.users.admin.internal.search.spi.model.permission.contributor;

import com.liferay.portal.kernel.search.BooleanClause;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.search.spi.model.permission.SearchPermissionFilterContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jesse Yeh
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.portal.kernel.model.User",
	service = SearchPermissionFilterContributor.class
)
public class UserSearchPermissionFilterContributor
	implements SearchPermissionFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, long companyId, long[] groupIds,
		long userId, PermissionChecker permissionChecker, String className) {

		for (BooleanClause<Filter> clause :
				booleanFilter.getShouldBooleanClauses()) {

			if (clause.getClause() instanceof TermsFilter) {
				TermsFilter termsFilter = (TermsFilter)clause.getClause();

				String field = termsFilter.getField();

				if (field.equals(Field.ROLE_ID)) {
					TermsFilter roleIdsTermsFilter = new TermsFilter(
						Field.ROLE_IDS);

					roleIdsTermsFilter.addValues(termsFilter.getValues());

					booleanFilter.add(roleIdsTermsFilter);

					break;
				}
			}
		}
	}

}