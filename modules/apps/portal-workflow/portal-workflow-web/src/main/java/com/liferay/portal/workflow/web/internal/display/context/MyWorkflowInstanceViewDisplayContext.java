/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.workflow.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.workflow.web.internal.search.WorkflowInstanceSearch;

import java.util.List;

/**
 * @author Marcellus Tavares
 */
public class MyWorkflowInstanceViewDisplayContext
	extends WorkflowInstanceViewDisplayContext {

	public MyWorkflowInstanceViewDisplayContext(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse)
		throws PortalException {

		super(liferayPortletRequest, liferayPortletResponse);
	}

	@Override
	public String getHeaderTitle() {
		return "my-submissions";
	}

	@Override
	protected List<WorkflowInstance> getSearchContainerResults(
			int start, int end,
			OrderByComparator<WorkflowInstance> orderByComparator)
		throws PortalException {

		return WorkflowInstanceManagerUtil.search(
			workflowInstanceRequestHelper.getCompanyId(),
			workflowInstanceRequestHelper.getUserId(), getKeywords(),
			getKeywords(), getAssetType(getKeywords()), getKeywords(),
			getKeywords(), getCompleted(), start, end, orderByComparator);
	}

	@Override
	protected int getSearchContainerTotal() throws PortalException {
		return WorkflowInstanceManagerUtil.searchCount(
			workflowInstanceRequestHelper.getCompanyId(),
			workflowInstanceRequestHelper.getUserId(), getKeywords(),
			getKeywords(), getAssetType(getKeywords()), getKeywords(),
			getKeywords(), getCompleted());
	}

	@Override
	protected void setSearchContainerEmptyResultsMessage(
		WorkflowInstanceSearch searchContainer) {

		DisplayTerms searchTerms = searchContainer.getDisplayTerms();

		if (isNavigationAll()) {
			searchContainer.setEmptyResultsMessage(
				"there-are-no-instances-started-by-me");
		}
		else if (isNavigationPending()) {
			searchContainer.setEmptyResultsMessage(
				"there-are-no-pending-instances-started-by-me");
		}
		else {
			searchContainer.setEmptyResultsMessage(
				"there-are-no-completed-instances-started-by-me");
		}

		if (Validator.isNotNull(searchTerms.getKeywords())) {
			searchContainer.setEmptyResultsMessage(
				searchContainer.getEmptyResultsMessage() +
					"-with-the-specified-search-criteria");
		}
	}

}